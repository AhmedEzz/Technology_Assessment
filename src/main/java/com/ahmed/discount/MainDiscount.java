package com.ahmed.discount;

import com.ahmed.model.Cart;
import com.ahmed.util.Utils;

/**
 * This class to calculate the main bill discount without giving the base percentage discount
 * during the calculation we will add the base percentage discount based on the discount policy
 * 
 * 
 * @author ahmed
 *
 */
public class MainDiscount implements DiscountPolicy {

	private static final double DISCOUNT_AMOUNT = 5;
	private static final double MAIN_AMOUNT = 100;
	private DiscountPolicy discountPolicy;

	public MainDiscount(DiscountPolicy discountPolicy) {
		this.discountPolicy = discountPolicy;
	}

	public MainDiscount() {
		this.discountPolicy = n-> 0;
	}
	
	
	@Override
	public double getDiscount(Cart cart) {
		double total = Utils.calculate(cart.getItems());
		
		// get how many 100 $ in the total bill
		int factor = (int) (total / MAIN_AMOUNT);
		
		// 5 $ discount for every 100 $
		double totalDiscount = DISCOUNT_AMOUNT * factor;
		
		// Add the 5 $ discount for every 100 $ to selected discount policy
		return totalDiscount + discountPolicy.getDiscount(cart);
	}

}
