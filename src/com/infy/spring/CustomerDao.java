package com.infy.spring;
import java.util.List;

import org.springframework.orm.jpa.JpaTemplate;
import org.springframework.transaction.annotation.Transactional;  

@Transactional  
public class CustomerDao {
	
	
	    JpaTemplate template;  
	  
	    public void setTemplate(JpaTemplate template) {  
	        this.template = template;  
	    }  
	    public void createRecord(long mobileNumber,String region,double amount,String email){  
	        CustomerBean cust = new CustomerBean(mobileNumber,region,amount,email);  
	        template.persist(cust);  
	    }  
	    @SuppressWarnings("unchecked")
		public List<CustomerBean> getAllTransactions(){  
	        @SuppressWarnings({ "unchecked", "unchecked", "unchecked" })
			List<CustomerBean> cust = template.find("select cb from CustomerBean cb");  
	        return cust;  
	    } 

}
