package com.appsdeveloperblog.estore.productservice.core.events;

import java.math.BigDecimal;

import lombok.Data;

/**
 * @author gaura
 *
 * Command classes in CQRS usually follow below naming convention
 * 
 * <Noun><PerformedAction>Event - so we named this class as CreateProductCommand
 */

@Data
public class ProductCreatedEvent {

	private String productId;
	private String title;
	private BigDecimal price;
	private Integer quantity;
}
