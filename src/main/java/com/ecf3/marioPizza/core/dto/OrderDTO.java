/**
 * 
 */
package com.ecf3.marioPizza.core.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import com.ecf3.marioPizza.core.domain.OrderLine;
import com.ecf3.marioPizza.core.domain.Pizza;
import com.ecf3.marioPizza.security.models.User;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderDTO {

	/**
	 * 
	 */
	private Long id;

	/**
	 * 
	 */
	private LocalDate date;

	/**
	 * 
	 */
	private BigDecimal total;

	/**
	 * 
	 */
	private User user;

	/**
	 * 
	 */
	private List<OrderLine> orderLines;

	/**
	 * 
	 */
	private List<Pizza> pizzas;

	/**
	 * 
	 */
	public OrderDTO() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the date
	 */
	public LocalDate getDate() {
		return date;
	}

	/**
	 * @param localDate the date to set
	 */
	public void setDate(LocalDate localDate) {
		this.date = localDate;
	}

	/**
	 * @return the total
	 */
	public BigDecimal getTotal() {
		return total;
	}

	/**
	 * @param total the total to set
	 */
	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * @return the orderLines
	 */
	public List<OrderLine> getOrderLines() {
		return orderLines;
	}

	/**
	 * @param orderLines the orderLines to set
	 */
	public void setOrderLines(List<OrderLine> orderLines) {
		this.orderLines = orderLines;
	}

	/**
	 * @return the pizzas
	 */
	public List<Pizza> getPizzas() {
		return pizzas;
	}

	/**
	 * @param pizzas the pizzas to set
	 */
	public void setPizzas(List<Pizza> pizzas) {
		this.pizzas = pizzas;
	}

}
