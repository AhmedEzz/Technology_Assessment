package com.ahmed.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ahmed.model.Cart;
import com.ahmed.model.Response;
import com.ahmed.service.CartService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Api(tags = {"Bill Services"})
public class CartController {

	@Autowired
	private CartService cartService;
	
	@ApiOperation(value = "Get Net Amount", notes = "Getting net amount from provided Bill")
	@ApiResponses(value = {
	@ApiResponse(code = 200, message = "JSON Response"),
	@ApiResponse(code = 500, message = "Internal Server Error")})
	@PostMapping("/bill")
	public Response bill(HttpServletRequest request, @RequestBody Cart cart)
	{
		return cartService.getBill(cart);
	}
}
