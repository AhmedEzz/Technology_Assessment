package com.ahmed.service.impl;

import org.springframework.stereotype.Service;

import com.ahmed.discount.DiscountPolicy;
import com.ahmed.discount.DiscountPolicyFactory;
import com.ahmed.model.Cart;
import com.ahmed.model.Response;
import com.ahmed.service.CartService;
import com.ahmed.util.Utils;

@Service
public class CartServiceImpl implements CartService{

	@Override
	public Response getBill(Cart cart) {
		
		DiscountPolicy discountStrategy = DiscountPolicyFactory.getDiscountPolicy(cart.getCustomer());
		
		double discount = discountStrategy.getDiscount(cart);
		double total = Utils.calculate(cart.getItems());
		Response response = new Response();
		response.setDiscount(discount);
		response.setNetAmount(total - discount);
		response.setTotal(total);
		
		return response;
	}

}
