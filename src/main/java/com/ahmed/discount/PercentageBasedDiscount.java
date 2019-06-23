package com.ahmed.discount;

import java.util.List;
import java.util.stream.Collectors;

import com.ahmed.model.Cart;
import com.ahmed.model.Item;
import com.ahmed.util.ProductType;

/**
 * Abstract Class to calculate the percentage based discount, also to provide an
 * abstract method to be override by different classes based on the discount
 * type
 * 
 * @author ahmed
 *
 */
public abstract class PercentageBasedDiscount implements DiscountPolicy {

	@Override
	public double getDiscount(Cart cart) {

		// Filter out all non grocery items to be calculate the total amount
		List<Item> otherItems = cart.getItems().stream()
				.filter(o -> o.getProduct().getProductType() != ProductType.GROCERY).collect(Collectors.toList());

		double totalAmount = otherItems.stream().map(o -> o.getProduct().getPrice() * o.getQuantity())
				.reduce((x, y) -> x + y).orElse(0.0);

		return calculateDiscountPolicy(totalAmount);
	}

	public abstract double calculateDiscountPolicy(double amount);

}
