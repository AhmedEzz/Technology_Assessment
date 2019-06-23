package com.ahmed.discount;

import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.Test;

import com.ahmed.model.Customer;
import com.ahmed.util.CustomerType;

public class DiscountPolicyFactoryTest {
	
	@Test
	public void testDiscountPolicyFactory_employee() {
		Customer customer = new Customer(1, new Date(), CustomerType.EMPLOYEE);
		DiscountPolicy discountStrategy = DiscountPolicyFactory.getDiscountPolicy(customer);
		assertTrue( discountStrategy instanceof DiscountPolicy );
	}
	
	@Test
	public void testDiscountPolicyFactory_affiliate() {
		Customer customer = new Customer(1, new Date(), CustomerType.AFFILIATE);
		DiscountPolicy discountStrategy = DiscountPolicyFactory.getDiscountPolicy(customer);
		assertTrue( discountStrategy instanceof DiscountPolicy );
	}
	
	@Test
	public void testDiscountPolicyFactory_regular() {
		Customer customer = new Customer(1, new Date(), CustomerType.NORMAL);
		DiscountPolicy discountStrategy = DiscountPolicyFactory.getDiscountPolicy(customer);
		assertTrue( discountStrategy instanceof DiscountPolicy );
	}

}
