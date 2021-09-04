package com.revature.app;

public class Food {
	private String name;
	private Type type;
	private Double price;
	private Integer quantity;
	
	public static class Builder {
		// Required fields
		private String name;
		private Type type;
		
		// Optional fields
		private Double price = 0.0;
		private Integer quantity = 0;
		
		public Builder(String name, Type type) {
			this.name = name;
			this.type = type;
		}
		
		public Builder price(Double price) {
			this.price = price;
			return this;
		}
		
		public Builder quantity(Integer quantity) {
			this.quantity = quantity;
			return this;
		}
		
		public Food build() {
			return new Food(this);
		}
	}
	
	public Food(Builder builder) {
		super();
		this.name = builder.name;
		this.type = builder.type;
		this.price = builder.price;
		this.quantity = builder.quantity;
	}
	
	public Food(String name, Type type, Double price, Integer quantity) {
		super();
		this.name = name;
		this.type = type;
		this.price = price;
		this.quantity = quantity;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + ((quantity == null) ? 0 : quantity.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Food other = (Food) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (quantity == null) {
			if (other.quantity != null)
				return false;
		} else if (!quantity.equals(other.quantity))
			return false;
		if (type != other.type)
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "\nFood [name=" + name + ", type=" + type + ", price=" + price + ", quantity=" + quantity + "]";
	}
}
