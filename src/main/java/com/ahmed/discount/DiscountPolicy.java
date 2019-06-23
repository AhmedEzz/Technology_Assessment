package com.ahmed.discount;

import com.ahmed.model.Cart;

@FunctionalInterface
public interface DiscountPolicy {

	public double getDiscount(Cart cart);
}
