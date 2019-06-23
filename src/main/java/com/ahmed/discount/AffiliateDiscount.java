package com.ahmed.discount;

/**
 * Override the abstract method from Percentage Based Discount class to have the Affiliate User Discount
 * 
 * @author ahmed
 *
 */
public class AffiliateDiscount extends PercentageBasedDiscount{

	private static final double DISCOUNT = 0.10;
	@Override
	public double calculateDiscountPolicy(double amount) {
		return amount * DISCOUNT;
	}

}
