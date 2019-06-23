package com.ahmed.discount;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;

import org.junit.Test;

import com.ahmed.model.Cart;
import com.ahmed.model.Customer;
import com.ahmed.model.Item;
import com.ahmed.model.Product;
import com.ahmed.util.ProductType;

public class EmployeeDiscountTest {

	private DiscountPolicy discountStrategy = new EmployeeDiscount();

	@Test
	public void employeeDiscount_nonGrocery_Product() {
		Cart order = new Cart(new Customer(1, new Date()));
		Product product = new Product(1, 100, ProductType.OTHER);
		order.addItem(new Item(1, product, 1));
		double discount = discountStrategy.getDiscount(order);
		assertThat(discount).isEqualTo(30);
	}

	@Test
	public void employeeDiscount_nonGrocery_multipleProducts() {
		Cart order = new Cart(new Customer(1, new Date()));
		Product product = new Product(1, 100, ProductType.OTHER);
		Product product2 = new Product(2, 100, ProductType.OTHER);
		order.addItem(new Item(1, product, 1));
		order.addItem(new Item(2, product2, 1));
		double discount = discountStrategy.getDiscount(order);
		assertThat(discount).isEqualTo(60);
	}

	@Test
	public void employeeDiscount_Grocery_multipleProducts() {
		Cart order = new Cart(new Customer(1, new Date()));
		Product product = new Product(1, 100, ProductType.OTHER);
		Product product2 = new Product(2, 100, ProductType.GROCERY);
		order.addItem(new Item(1, product, 1));
		order.addItem(new Item(2, product2, 1));
		double discount = discountStrategy.getDiscount(order);
		assertThat(discount).isEqualTo(30);
	}

}
