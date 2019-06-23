package com.ahmed.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ahmed.model.Cart;
import com.ahmed.model.Response;
import com.ahmed.service.CartService;

@RestController
public class CartController {

	@Autowired
	private CartService cartService;
	
	@PostMapping("/bill")
	public Response bill(@RequestBody Cart cart)
	{
		return cartService.getBill(cart);
	}
}
