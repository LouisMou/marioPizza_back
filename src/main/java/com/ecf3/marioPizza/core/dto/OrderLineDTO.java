/**
 * 
 */
package com.ecf3.marioPizza.core.dto;

import com.ecf3.marioPizza.core.domain.Order;
import com.ecf3.marioPizza.core.domain.Pizza;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderLineDTO {
	/**
	 * 
	 */
	private long id;

	/**
	 * 
	 */
	private Order order;

	/**
	 * 
	 */
	private Pizza pizza;

	/**
	 * 
	 */
	private short quantity;

	/**
	 * 
	 */
	public OrderLineDTO() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the order
	 */
	public Order getOrder() {
		return order;
	}

	/**
	 * @param order the order to set
	 */
	public void setOrder(Order order) {
		this.order = order;
	}

	/**
	 * @return the pizza
	 */
	public Pizza getPizza() {
		return pizza;
	}

	/**
	 * @param pizza the pizza to set
	 */
	public void setPizza(Pizza pizza) {
		this.pizza = pizza;
	}

	/**
	 * @return the quantity
	 */
	public short getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(short quantity) {
		this.quantity = quantity;
	}

}
