package com.appsdeveloperblog.estore.productservice.rest;

import java.util.UUID;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appsdeveloperblog.estore.productservice.command.CreateProductCommand;

@RestController
@RequestMapping("/products")
public class ProductsController {
	
	private final Environment env;
	private final CommandGateway commandGateway;
	
	@Autowired
	public ProductsController(Environment env, CommandGateway commandGateway) {
		this.env=env;
		this.commandGateway=commandGateway;
	}

	@GetMapping
	public String getProduct() {
		return "http Get handled on port " + env.getProperty("local.server.port");
	}
	
	@PostMapping
	public String createProduct(@RequestBody CreateProductRestModel createProductRestModel) {
		CreateProductCommand createProductCommand = CreateProductCommand.builder()
			.price(createProductRestModel.getPrice())
			.quantity(createProductRestModel.getQuantity())
			.title(createProductRestModel.getTitle())
			.productId(UUID.randomUUID().toString())
			.build();
		
		String returnValue;
		
		try {
			returnValue = commandGateway.sendAndWait(createProductCommand);
		} catch (Exception e) {
			returnValue = e.getLocalizedMessage();
		}
		
		return returnValue;
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
