package com.ahmed.util;

import java.util.Optional;
import java.util.Set;

import com.ahmed.model.Item;

public class Utils {

	private Utils() {}
	
	public static double calculate(Set<Item> items) {
		Optional<Double> total = items.stream().map(o -> o.getProduct().getPrice() * o.getQuantity()).reduce((a,b) -> a+b);
		return total.orElse(0.0);
	}
}
