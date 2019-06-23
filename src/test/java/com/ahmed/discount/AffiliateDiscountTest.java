package com.ahmed.discount;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import com.ahmed.model.Cart;
import com.ahmed.model.Customer;
import com.ahmed.model.Item;
import com.ahmed.model.Product;
import com.ahmed.util.ProductType;

@RunWith(SpringRunner.class)
public class AffiliateDiscountTest {

	
	private DiscountPolicy discountStrategy = new AffiliateDiscount();
	
	@Test
	public void affiliateDiscount_nonGrocery_Product() {
		Cart order = new Cart( new Customer(1, new Date()));
		Product product = new Product(1, 100, ProductType.OTHER);
		order.addItem(new Item(1, product, 1));
		double discount = discountStrategy.getDiscount(order);
		assertThat(discount).isEqualTo(10);
	}
	
	
	@Test
	public void affiliateDiscount_nonGrocery_multipleProducts() {
		Cart order = new Cart( new Customer(1, new Date()));
		Product product = new Product(1, 100, ProductType.OTHER);
		Product product2 = new Product(2, 100, ProductType.OTHER);
		order.addItem(new Item(1, product, 1));
		order.addItem(new Item(2, product2, 1));
		double discount = discountStrategy.getDiscount(order);
		assertThat(discount).isEqualTo(20);
	}
	
	@Test
	public void affiliateDiscount_Grocery_multipleProducts() {
		Cart order = new Cart( new Customer(1, new Date()));
		Product product = new Product(1, 100, ProductType.OTHER);
		Product product2 = new Product(2, 100, ProductType.GROCERY);
		order.addItem(new Item(1, product, 1));
		order.addItem(new Item(2, product2, 1));
		double discount = discountStrategy.getDiscount(order);
		assertThat(discount).isEqualTo(10);
	}
}
