package com.ecf3.marioPizza.core.domain;

import java.math.BigDecimal;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "pizza")
public class Pizza {

	/**
	 * unique id of a pizza.
	 */
	@Id
	@Column(name = "id")
	private Integer id;

	/**
	 * name of the pizza.
	 */
	@Column(name = "name")
	private String name;

	/**
	 * description of the ingredients.
	 */
	@Column(name = "description")
	private String description;

	/**
	 * image of the pizza.
	 */
	@Column(name = "image")
	private String picture;

	/**
	 * price of the pizza.
	 */
	@Column(name = "price")
	private BigDecimal price;

	/**
	 *
	 */
	@ManyToMany(mappedBy = "pizza")
	private List<Order> orders;

	/**
	 * @return the orders
	 */
	public List<Order> getOrders() {
		return orders;
	}

	/**
	 * @param orders the orders to set
	 */
	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param pId the id to set
	 */
	public void setId(final Integer pId) {
		this.id = pId;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param pName the name to set
	 */
	public void setName(final String pName) {
		this.name = pName;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param pDescription the description to set
	 */
	public void setDescription(final String pDescription) {
		this.description = pDescription;
	}

	/**
	 * @return the picture
	 */
	public String getPicture() {
		return picture;
	}

	/**
	 * @param pPicture the picture to set
	 */
	public void setPicture(final String pPicture) {
		this.picture = pPicture;
	}

	/**
	 * @return the price
	 */
	public BigDecimal getPrice() {
		return price;
	}

	/**
	 * @param pPrice the price to set
	 */
	public void setPrice(final BigDecimal pPrice) {
		this.price = pPrice;
	}

	/**
	 * default constructor.
	 */
	public Pizza() {
		super();
	}

}
