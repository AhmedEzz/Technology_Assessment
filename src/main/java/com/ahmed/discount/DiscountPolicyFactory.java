package com.ahmed.discount;

import com.ahmed.model.Customer;
import com.ahmed.util.CustomerType;

/**
 * Factory Class to get the proper instance of Discount Policy
 * 
 * @author ahmed
 *
 */
public class DiscountPolicyFactory {

	private DiscountPolicyFactory() {}
	
	public static DiscountPolicy getDiscountPolicy(Customer customer) {
		if(customer.getCustomerType() == CustomerType.EMPLOYEE) {
			return new MainDiscount(new EmployeeDiscount());
		}else if(customer.getCustomerType() == CustomerType.AFFILIATE) {
			return new MainDiscount(new AffiliateDiscount());
		}else {
			return new MainDiscount(new NormalCustomerDiscount(customer));
		}
	}
}
