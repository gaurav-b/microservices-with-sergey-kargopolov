package com.appsdeveloperblog.estore.productservice.command;

import java.math.BigDecimal;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

import lombok.Builder;
import lombok.Data;

/**
 * @author gaura
 *
 * Command classes in CQRS usually follow below naming convention
 * 
 * <Verb><Noun>Command - so we named this class as CreateProductCommand
 */

@Builder @Data
public class CreateProductCommand {

	@TargetAggregateIdentifier
	private final String productId;
	
	private final String title;
	private final BigDecimal price;
	private final Integer quantity;
}
