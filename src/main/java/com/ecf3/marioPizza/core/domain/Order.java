/**
 *
 */
package com.ecf3.marioPizza.core.domain;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

import com.ecf3.marioPizza.security.models.User;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "`order`")
public class Order {
	/**
	 * id.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/**
	 * date.
	 */
	@Column(name = "date")
	private Date date;

	/**
	 * total amount.
	 */
	@Column(name = "total_amount")
	private BigDecimal total;
	/**
	 *
	 */
	@ManyToOne
	@JoinColumn(name = "usr_id")
	private User user;

	/**
	 * 
	 */
	@OneToMany(mappedBy = "order")
	private List<OrderLine> orderLines;

	/**
	 *
	 */
	@ManyToMany
	@JoinTable(name = "order_line", joinColumns = @JoinColumn(name = "ord_id"), inverseJoinColumns = @JoinColumn(name = "piz_id"))
	private List<Pizza> pizzas;

	/**
	 * default constructor.
	 */
	public Order() {
		super();
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
	public Date getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
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

}
