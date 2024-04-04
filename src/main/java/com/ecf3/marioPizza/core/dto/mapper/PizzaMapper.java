package com.ecf3.marioPizza.core.dto.mapper;

import java.util.ArrayList;
import java.util.List;

import com.ecf3.marioPizza.core.domain.Pizza;
import com.ecf3.marioPizza.core.dto.PizzaDTO;

public class PizzaMapper {

	/**
	 * Create a Pokemon from a PokemonDTO.
	 *
	 * @param dto the dto used as a source
	 * @return a Pokemon filled with datas from dto
	 */
	public static Pizza dtoToEntity(final PizzaDTO dto) {
		Pizza entity = null;

		if (dto != null) {
			entity = new Pizza();
			entity.setId(dto.getId());
			entity.setPicture(dto.getPicture());
			entity.setName(dto.getName());
			entity.setDescription(dto.getDescription());
			entity.setPrice(dto.getPrice());
		}

		return entity;
	}

	/**
	 *
	 * @param pizza a Pizza
	 * @return the Pokemon turned into its sibling PokemonDTO
	 */
	public static PizzaDTO pizzaToDto(final Pizza pizza) {
		PizzaDTO dto = null;

		if (pizza != null) {
			dto = new PizzaDTO();

			dto.setId(pizza.getId());
			dto.setDescription(pizza.getDescription());
			dto.setPrice(pizza.getPrice());
			dto.setName(pizza.getName());
			dto.setPicture(pizza.getPicture());
		}

		return dto;
	}

	/**
	 *
	 * @param pizzas a list of pizzas
	 * @return the list of pizzas turned into its sibling list of pizzasDTO
	 */
	public static List<PizzaDTO> pizzasToDtos(final List<Pizza> pizzas) {
		List<PizzaDTO> dtos = null;

		if ((pizzas != null)) {
			dtos = new ArrayList<>();

			for (Pizza pizza : pizzas) {
				dtos.add(pizzaToDto(pizza));
			}
		}
		return dtos;
	}

}
