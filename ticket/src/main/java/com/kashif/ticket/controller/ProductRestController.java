package com.kashif.ticket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kashif.ticket.model.Coupon;
import com.kashif.ticket.model.Product;
import com.kashif.ticket.repo.ProductRepo;
import com.kashif.ticket.restclients.CouponClient;

@RestController
@RequestMapping("/productapi")
public class ProductRestController {

	@Autowired
	private ProductRepo repo;
	
	@Autowired
	CouponClient couponClient;
	
	@PostMapping(path = "/products")
	public Product create(@RequestBody Product product) {
		Coupon coupon = couponClient.getCoupon(product.getCouponCode());
		product.setPrice(product.getPrice().subtract(coupon.getDiscount()));
		return repo.save(product);
	}
	
}
