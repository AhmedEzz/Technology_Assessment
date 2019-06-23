package com.ahmed.discount;

/**
 * Override the abstract method from Percentage Based Discount class to have the Employee Discount
 * 
 * @author ahmed
 *
 */
public class EmployeeDiscount extends PercentageBasedDiscount{

	private static final double DISCOUNT = 0.30;
	
	@Override
	public double calculateDiscountPolicy(double amount) {
		
		return amount * DISCOUNT;
	}

}
