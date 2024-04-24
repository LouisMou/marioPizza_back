package com.ecf3.marioPizza;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.ecf3.marioPizza.core.domain.Pizza;
import com.ecf3.marioPizza.core.dto.PizzaDTO;
import com.ecf3.marioPizza.core.dto.mapper.PizzaMapper;

@SpringBootTest
public final class PizzaTest {

	@Test
	public void testDtoToEntity_withValidDto() {
		// given
		PizzaDTO dto = new PizzaDTO();
		dto.setId(1);
		dto.setName("Test Pizza");
		dto.setDescription("Test Description");
		dto.setPicture("test.jpg");
		dto.setPrice(BigDecimal.TEN);

		// when
		Pizza entity = PizzaMapper.dtoToEntity(dto);

		// then
		assertThat(entity).isNotNull();
		assertEquals(dto.getId(), entity.getId());
		assertEquals(dto.getName(), entity.getName());
		assertEquals(dto.getDescription(), entity.getDescription());
		assertEquals(dto.getPicture(), entity.getPicture());
		assertEquals(dto.getPrice(), entity.getPrice());
	}

	@Test
	public void testDtoToEntity_withNullDto() {
		// given
		PizzaDTO dto = null;

		// when
		Pizza entity = PizzaMapper.dtoToEntity(dto);

		// then
		assertNull(entity);
	}

	@Test
	public void testPizzaToDto_withValidPizza() {
		// given
		Pizza pizza = new Pizza();
		pizza.setId(1);
		pizza.setName("Test Pizza");
		pizza.setDescription("Test Description");
		pizza.setPicture("test.jpg");
		pizza.setPrice(BigDecimal.TEN);

		// when
		PizzaDTO dto = PizzaMapper.pizzaToDto(pizza);

		// then
		assertThat(dto).isNotNull();
		assertEquals(pizza.getId(), dto.getId());
		assertEquals(pizza.getName(), dto.getName());
		assertEquals(pizza.getDescription(), dto.getDescription());
		assertEquals(pizza.getPicture(), dto.getPicture());
		assertEquals(pizza.getPrice(), dto.getPrice());
	}

	@Test
	public void testPizzaToDto_withNullPizza() {
		// given
		Pizza pizza = null;

		// when
		PizzaDTO dto = PizzaMapper.pizzaToDto(pizza);

		// then
		assertNull(dto);
	}

	@Test
	public void testPizzasToDtos_withValidPizzas() {
		// given
		List<Pizza> pizzas = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			Pizza pizza = new Pizza();
			pizza.setId(i);
			pizza.setName("Pizza " + i);
			pizza.setDescription("Description " + i);
			pizza.setPicture("picture" + i + ".jpg");
			pizza.setPrice(BigDecimal.valueOf(i * 2));
			pizzas.add(pizza);
		}

		// when
		List<PizzaDTO> dtos = PizzaMapper.pizzasToDtos(pizzas);

		// then
		assertThat(dtos).isNotNull();
		assertThat(dtos).hasSameSizeAs(pizzas);
		for (int i = 0; i < pizzas.size(); i++) {
			assertEquals(pizzas.get(i).getId(), dtos.get(i).getId());
			assertEquals(pizzas.get(i).getName(), dtos.get(i).getName());
			assertEquals(pizzas.get(i).getDescription(), dtos.get(i).getDescription());
			assertEquals(pizzas.get(i).getPicture(), dtos.get(i).getPicture());
			assertEquals(pizzas.get(i).getPrice(), dtos.get(i).getPrice());
		}
	}

	@Test
	public void testPizzasToDtos_withNullPizzas() {
		// given
		List<Pizza> pizzas = null;

		// when
		List<PizzaDTO> dtos = PizzaMapper.pizzasToDtos(pizzas);

		// then
		assertNull(dtos);
	}

	@Test
	public void testPizzasToDtos_withEmptyPizzas() {
		// given
		List<Pizza> pizzas = new ArrayList<>();

		// when
		List<PizzaDTO> dtos = PizzaMapper.pizzasToDtos(pizzas);

		// then
		assertThat(dtos).isEmpty();
	}

	@Test
	public void testDtoToEntityAndBack() {
		// given
		PizzaDTO dto = new PizzaDTO();
		dto.setId(1);
		dto.setName("Test Pizza");
		dto.setDescription("Test Description");
		dto.setPicture("test.jpg");
		dto.setPrice(BigDecimal.TEN);

		// when
		Pizza entity = PizzaMapper.dtoToEntity(dto);
		PizzaDTO mappedDto = PizzaMapper.pizzaToDto(entity);

		// then
		assertThat(mappedDto).isNotNull();
		assertEquals(dto.getId(), mappedDto.getId());
		assertEquals(dto.getName(), mappedDto.getName());
		assertEquals(dto.getDescription(), mappedDto.getDescription());
		assertEquals(dto.getPicture(), mappedDto.getPicture());
		assertEquals(dto.getPrice(), mappedDto.getPrice());
	}

	@Test
	public void testDtoToEntity_withPartialDto() {
		// given
		PizzaDTO dto = new PizzaDTO();
		dto.setName("Test Pizza");
		dto.setPrice(BigDecimal.TEN);

		// when
		Pizza entity = PizzaMapper.dtoToEntity(dto);

		// then
		assertThat(entity).isNotNull();
		assertNull(entity.getId());
		assertEquals(dto.getName(), entity.getName());
		assertNull(entity.getDescription());
		assertNull(entity.getPicture());
		assertEquals(dto.getPrice(), entity.getPrice());
	}

	@Test
	public void testPizzaToDto_withPartialPizza() {
		// given
		Pizza pizza = new Pizza();
		pizza.setId(1);
		pizza.setName("Test Pizza");
		pizza.setPrice(BigDecimal.TEN);

		// when
		PizzaDTO dto = PizzaMapper.pizzaToDto(pizza);

		// then
		assertThat(dto).isNotNull();
		assertEquals(pizza.getId(), dto.getId());
		assertEquals(pizza.getName(), dto.getName());
		assertNull(dto.getDescription());
		assertNull(dto.getPicture());
		assertEquals(pizza.getPrice(), dto.getPrice());
	}
}
