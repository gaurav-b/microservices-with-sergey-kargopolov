package com.appsdeveloperblog.estore.productservice.query;

import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.appsdeveloperblog.estore.productservice.core.data.ProductEntity;
import com.appsdeveloperblog.estore.productservice.core.data.ProductRepository;
import com.appsdeveloperblog.estore.productservice.core.events.ProductCreatedEvent;

/**
 * @author gaura
 * 
 * can be named as ProjectProjection also
 */

@Component
public class ProductEventsHandler {

	private final ProductRepository productRepository;
	
	public ProductEventsHandler(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
	
	@EventHandler
	public void on(ProductCreatedEvent event) {
	
		ProductEntity productEntity = new ProductEntity();
		BeanUtils.copyProperties(event, productEntity);
		productRepository.save(productEntity);
	}
}
