/**
 * 
 */
package com.ecf3.marioPizza.core.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecf3.marioPizza.core.dto.PizzaDTO;
import com.ecf3.marioPizza.core.dto.mapper.PizzaMapper;
import com.ecf3.marioPizza.core.service.IPizzaService;

/**
 * 
 */
@RestController
@RequestMapping("/mariopizza")
public class PizzaController {

	@Autowired
	private IPizzaService pizzaService;

	@GetMapping("/")
	public List<PizzaDTO> getAll() {
		return PizzaMapper.pizzasToDtos(pizzaService.getAllPizzas());
	}

	/**
	 * 
	 */
	public PizzaController() {
		// TODO Auto-generated constructor stub
	}

}
