package com.ahmed.discount;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;

import org.junit.Test;

import com.ahmed.model.Cart;
import com.ahmed.model.Customer;
import com.ahmed.model.Item;
import com.ahmed.model.Product;
import com.ahmed.util.ProductType;

public class MainDiscountTest {

	private static DiscountPolicy discountPolicy = new MainDiscount();

	@Test
	public void above100() {
		Cart order = new Cart(new Customer(1, new Date()));
		Product product = new Product(1, 120, ProductType.GROCERY);
		order.addItem(new Item(1, product, 1));
		double discount = discountPolicy.getDiscount(order);
		assertThat(discount).isEqualTo(5);
	}

	@Test
	public void bove100_multipleProductsOfMultipleQuantites() {
		Cart order = new Cart(new Customer(1, new Date()));
		Product product = new Product(1, 50, ProductType.GROCERY);
		order.addItem(new Item(1, product, 2));
		double discount = discountPolicy.getDiscount(order);
		assertThat(discount).isEqualTo(5);
	}

	@Test
	public void above100_multipleProducts() {
		Product cheese = new Product(1, 120, ProductType.GROCERY);
		Product milk = new Product(2, 180, ProductType.GROCERY);
		Cart order = new Cart(new Customer(1, new Date()));
		order.addItem(new Item(1, cheese, 1));
		order.addItem(new Item(2, milk, 1));
		double discount = discountPolicy.getDiscount(order);
		assertThat(discount).isEqualTo(15);
	}

	@Test
	public void below100() {
		Cart order = new Cart(new Customer(1, new Date()));
		Product product = new Product(1, 80, ProductType.GROCERY);
		order.addItem(new Item(1, product, 1));
		double discount = discountPolicy.getDiscount(order);
		assertThat(discount).isEqualTo(0);
	}

	@Test
	public void below100_multipleProducts() {
		Cart order = new Cart(new Customer(1, new Date()));
		Product rokka = new Product(1, 30, ProductType.GROCERY);
		Product carrot = new Product(1, 30, ProductType.GROCERY);
		order.addItem(new Item(1, rokka, 1));
		order.addItem(new Item(2, carrot, 1));
		double discount = discountPolicy.getDiscount(order);
		assertThat(discount).isEqualTo(0);
	}

	@Test
	public void equals100() {
		Cart order = new Cart(new Customer(1, new Date()));
		Product chicken = new Product(1, 100, ProductType.GROCERY);
		order.addItem(new Item(1, chicken, 1));
		double discount = discountPolicy.getDiscount(order);
		assertThat(discount).isEqualTo(5);
	}
}
