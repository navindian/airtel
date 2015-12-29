package com.infy.spring;

import java.net.URI;
import java.util.Collections;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.CacheControl;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.EntityTag;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component
@Path("/transaction")
public class CustomerService {
	
	@Context
	UriInfo uriInfo;
	@Context
	Request request;
	
	/*@Autowired
	CustomerBean customer;*/
	
	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Response createTransactionRecord(@Context UriInfo uriInfo,@FormParam ("mobileNumber") long mobileNumber,@FormParam ("region") String region,
			@FormParam ("amount") double amount,@FormParam ("email") String email) {
		
		 ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");  
		 CustomerDao custDao = context.getBean("customerDao",CustomerDao.class);  
		//CustomerDao custDao = new CustomerDao();  
		 System.out.println(mobileNumber);
		 System.out.println(region);
		 System.out.println(amount);
		 System.out.println(email);
		custDao.createRecord(mobileNumber,region,amount,email);  
		URI uri = uriInfo.getBaseUriBuilder().path("../transaction.jsp").build();
		System.out.println(uri);
		return Response.seeOther(uri).build();
		
		    }
	
	@GET
	@Path("/getTransactions")
	@Produces(MediaType.TEXT_HTML)
	public Response getAllTransactions(@Context Request req) {
		
		 ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");  
		 CustomerDao custDao = context.getBean("customerDao",CustomerDao.class);  
		 List<CustomerBean> cust = custDao.getAllTransactions();
		 Collections.sort(cust);
		 
		 //for generating hashcode on mobileNumbers
		 StringBuilder ids=new StringBuilder();
		 for (int i = 0; i < cust.size(); i++) { 
			 CustomerBean custm = cust.get(i);
			 ids.append(custm.getMobileNumber());
		 }
		 String finalIds=ids.toString();
		 
		 EntityTag tag = new EntityTag(Integer.toString(finalIds.hashCode()));
		 CacheControl cc = new CacheControl();
	     cc.setMaxAge(120);
	     System.out.println(tag);
		 Response.ResponseBuilder builder = req.evaluatePreconditions(tag);
		 //if contents are not modified on server
		 if (builder != null) {
				builder.cacheControl(cc);
				System.out.println("no modification in content");
				return builder.tag(tag).build();
					 }
		 //if contents are modified on server
		 
		 StringBuilder htmlString=new StringBuilder();
		 String finalString=null;
		 for (int i = 0; i < cust.size(); i++) { 
			 CustomerBean custm = cust.get(i); 
			 htmlString.append("<table border=1 text-align=left width=60%/><tr><td width=15%>"+custm.getMobileNumber()+"</td>" +"<td width=15%>"+custm.getRegion()+"</td>"+"<td width=15%>"+custm.getAmount()+"</td>"+"<td width=15%>"+custm.getEmail()+"</td>" +"</tr></table>");
			 finalString=htmlString.toString();
			 System.out.println(custm.getMobileNumber() + " : " + custm.getRegion() + " : " + custm.getAmount() + " : " + custm.getEmail()); 
		
		    }
		 System.out.println("modification");
		 builder = Response.status(200).entity(finalString);
		 builder.cacheControl(cc);
		 builder.tag(tag);
		 return builder.build();
		//return Response.status(200).entity(finalString).build();
	
	
	}
	
	@GET
	@Path("/getTransactions/{region}")
	@Produces(MediaType.TEXT_HTML)
	public Response getAllTransactionsForId(@PathParam("region")String region) {
		 System.out.println(region);
		 ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");  
		 CustomerDao custDao = context.getBean("customerDao",CustomerDao.class);  
		 List<CustomerBean> cust = custDao.getAllTransactions(); 
		 StringBuilder htmlString=new StringBuilder();
		 String finalString=null;
		 for (int i = 0; i < cust.size(); i++) { 
			 CustomerBean custm = cust.get(i); 
			 if(custm.getRegion().equals(region)){
				 htmlString.append("<table border=1 text-align=left width=60%/><tr><td width=15%>"+custm.getMobileNumber()+"</td>" +"<td width=15%>"+custm.getRegion()+"</td>"+"<td width=15%>"+custm.getAmount()+"</td>"+"<td width=15%>"+custm.getEmail()+"</td>" +"</tr></table>");
				 System.out.println(custm.getMobileNumber() + " : " + custm.getRegion() + " : " + custm.getAmount() + " : " + custm.getEmail());
			 }
			 finalString=htmlString.toString();
			  
		
		    }
		
		return Response.status(200).entity(finalString).build();
	
	
	}
	
	
}
