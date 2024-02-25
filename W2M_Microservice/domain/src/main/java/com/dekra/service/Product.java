package com.dekra.service;

import lombok.Builder;
import lombok.Getter;

@Builder(builderMethodName = "maker")
@Getter
public class Product {

	private Long id;
	private String name;
	private String description;
	private Double price;

	private Double tax;
	private Double totalPrice;

	public void applyTax(Double tax) {
		this.tax = tax;
		this.totalPrice = this.price + ((tax / 100.0) * this.price);
	}

	public static Builder maker() {
		return new Builder();
	}

	public static class Builder {
		private final Product product;

		private Builder() {
			this.product = new Product();
		}

		public Builder id(Long id) {
			product.id = id;
			return this;
		}

		public Builder name(String name) {
			product.name = name;
			return this;
		}

		public Builder description(String description) {
			product.description = description;
			return this;
		}

		public Builder price(double price) {
			product.price = price;
			return this;
		}

		public Product build() {
			return product;
		}
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public Double getPrice() {
		return price;
	}

	public Double getTax() {
		return tax;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

}
