/**
 *
 */
package com.ecf3.marioPizza.core.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
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
	@ManyToOne
	@JoinColumn(name = "ord_id")
	private Order order;

	/**
	 *
	 */
	@ManyToOne
	@JoinColumn(name = "pizz_id")
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

}
