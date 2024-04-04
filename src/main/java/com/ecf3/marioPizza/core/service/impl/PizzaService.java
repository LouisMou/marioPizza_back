/**
 */
package com.ecf3.marioPizza.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecf3.marioPizza.core.domain.Pizza;
import com.ecf3.marioPizza.core.repository.IPizzaRepository;
import com.ecf3.marioPizza.core.service.IPizzaService;

@Service
public final class PizzaService implements IPizzaService {

	/**
	 * repository for pizza.
	 */
	@Autowired
	private IPizzaRepository pizzaRepo;

	@Override
	public List<Pizza> getAllPizzas() {
		return pizzaRepo.findAll();
	}

}
