/**
 *
 */
package com.ecf3.marioPizza.core.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "order_line")
public class OrderLine {

	/**
	 * id.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	/**
	 *
	 */
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ord_id")
	private Order order;

	/**
	 *
	 */
	@ManyToOne
	@JoinColumn(name = "piz_id")
	private Pizza pizza;

	/**
	 * quantity.
	 */
	@Column(name = "quantity")
	private short quantity;

	/**
	 *
	 */
	public OrderLine() {
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
