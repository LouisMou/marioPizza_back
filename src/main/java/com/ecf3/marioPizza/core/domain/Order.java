/**
 * 
 */
package com.ecf3.marioPizza.core.domain;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.Set;

import com.ecf3.marioPizza.security.models.User;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "`order`") // "order" is a reserved keyword in SQL, so it needs to be escaped
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "date")
	private Date date;

	@Column(name = "total_amount")
	private BigDecimal total;

	@ManyToOne
	@JoinColumn(name = "usr_id")
	private User user;

	/**
	 * 
	 */
	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
	private Set<OrderLine> orderLines;

	/**
	 * default constructor.
	 */
	public Order() {
		super();
	}

}
