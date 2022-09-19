package com.productapp.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

	@GetMapping("/products")
	public List<String> show() {
		return Arrays.asList("laptop", "mobile");

	}

	@GetMapping("/admin/add-products")
	public String add() {
		return "product added";

	}

	@GetMapping("/admin/delete-products")
	public String delete() {
		return "delete added";

	}

	@GetMapping("/products/{type}")
	public List<String> showByType(@PathVariable("type") String type) {
		if (type.equalsIgnoreCase("sports"))
			return Arrays.asList("Bat", "Ball");
		else
			return Arrays.asList("laptop", "mobile");
	}

}
