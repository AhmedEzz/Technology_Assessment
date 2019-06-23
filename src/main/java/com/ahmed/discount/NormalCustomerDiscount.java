package com.ahmed.discount;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import com.ahmed.model.Customer;

/**
 * Override the abstract method from Percentage Based Discount class to have the
 * Normal Customer Discount
 * 
 * @author ahmed
 *
 */
public class NormalCustomerDiscount extends PercentageBasedDiscount {

	private static final int YEARS = 2; // Customer with more than 2 years will have discount
	private Customer customer;
	private static final double DISCOUNT = .05;

	public NormalCustomerDiscount(Customer customer) {
		this.customer = customer;
	}

	@Override
	public double calculateDiscountPolicy(double amount) {
		if (customerOverTwoYears(customer.getJoinedDate(), YEARS)) {
			return amount * DISCOUNT;
		} else {
			return 0;
		}
	}

	/**
	 * Check if the customer over 2 years member or not
	 * 
	 * @param date
	 * @param factor
	 * @return
	 */
	private boolean customerOverTwoYears(Date date, int factor) {
		LocalDateTime joinDate = LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
		LocalDateTime now = LocalDateTime.now();
		LocalDateTime twoYearsAgo = now.minusYears(factor);

		return joinDate.isBefore(twoYearsAgo) || joinDate.isEqual(twoYearsAgo);
	}

}
