package com.ahmed.service.impl;

import org.springframework.stereotype.Service;

import com.ahmed.model.Cart;
import com.ahmed.model.Response;
import com.ahmed.service.CartService;

@Service
public class CartServiceImpl implements CartService{

	@Override
	public Response getBill(Cart cart) {
		
		Response response = new Response();
		response.setDiscount(0.0);
		response.setNetAmount(100);
		response.setTotal(100);
		return response;
	}

}
