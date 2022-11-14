package com.appsdeveloperblog.estore.productservice.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductsController {
	
	@Autowired
	private Environment env;

	@PostMapping
	public String createProduct(@RequestBody CreateProductRestModel createProductRestModel) {
		return "http post handled " + createProductRestModel.getTitle();
	}
	
	@GetMapping
	public String getProduct() {
		return "http Get handled on port " + env.getProperty("local.server.port");
	}
	
	@PutMapping
	public String updateProduct() {
		return "http Put handled";
	}
	
	@DeleteMapping
	public String deleteProduct() {
		return "http delete handled";
	}
}
