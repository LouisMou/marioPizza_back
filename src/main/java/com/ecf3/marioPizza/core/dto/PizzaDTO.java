/**
 *
 */
package com.ecf3.marioPizza.core.dto;

/**
 *
 */
public class PizzaDTO {

	/**
	 * pizzaDTO id.
	 */
	private Integer id;

	/**
	 * pizzaDTO name.
	 */
	private String name;

	/**
	 * pizzaDTO description.
	 */
	private String description;

	/**
	 * pizzaDTO picture.
	 */
	private String picture;

	/**
	 * pizzaDTO price.
	 */
	private Integer price;

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
	public Integer getPrice() {
		return price;
	}

	/**
	 * @param pPrice the price to set
	 */
	public void setPrice(final Integer pPrice) {
		this.price = pPrice;
	}

	/**
	 * pizzaDTO super constructor.
	 */
	public PizzaDTO() {
		super();
	}

}
