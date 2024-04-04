/**
 *
 */
package com.ecf3.marioPizza.core.service;

import java.util.List;

import com.ecf3.marioPizza.core.domain.Pizza;

public interface IPizzaService {

	/**
	 * gets all pizzas for the list.
	 *
	 * @return the pizzas
	 */
	List<Pizza> getAllPizzas();

}
