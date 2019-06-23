package com.ahmed.discount;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

import com.ahmed.model.Cart;
import com.ahmed.model.Customer;
import com.ahmed.model.Item;
import com.ahmed.model.Product;
import com.ahmed.util.ProductType;

public class NormalCustomerDiscountTest {

	@Test
	public void over2yearsJoining() {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.YEAR, -3);
		Date joindate = calendar.getTime();
		DiscountPolicy discountStrategy = new NormalCustomerDiscount(new Customer(1, joindate));

		Cart order = new Cart(new Customer(1, new Date()));
		Product product = new Product(1, 100, ProductType.OTHER);
		order.addItem(new Item(1, product, 1));
		double discount = discountStrategy.getDiscount(order);
		assertThat(discount).isEqualTo(5);

	}

	@Test
	public void exactly2yearsJoining() {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.YEAR, -2);
		Date joindate = calendar.getTime();

		DiscountPolicy discountStrategy = new NormalCustomerDiscount(new Customer(1, joindate));

		Cart order = new Cart(new Customer(1, new Date()));
		Product product = new Product(1, 100, ProductType.OTHER);
		order.addItem(new Item(1, product, 1));
		double discount = discountStrategy.getDiscount(order);
		assertThat(discount).isEqualTo(5);
	}

	@Test
	public void lessThan2YearsJoining() {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.YEAR, -1);
		Date joindate = calendar.getTime();
		DiscountPolicy discountStrategy = new NormalCustomerDiscount(new Customer(1, joindate));

		Cart order = new Cart(new Customer(1, new Date()));
		Product product = new Product(1, 100, ProductType.OTHER);
		order.addItem(new Item(1, product, 1));
		double discount = discountStrategy.getDiscount(order);
		assertThat(discount).isEqualTo(0);
	}

}
