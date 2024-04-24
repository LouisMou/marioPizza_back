package com.ecf3.marioPizza;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.ecf3.marioPizza.core.domain.Order;
import com.ecf3.marioPizza.core.domain.OrderLine;
import com.ecf3.marioPizza.core.domain.Pizza;
import com.ecf3.marioPizza.core.dto.OrderDTO;
import com.ecf3.marioPizza.core.dto.mapper.OrderMapper;
import com.ecf3.marioPizza.security.models.User;

@SpringBootTest
public class OrderTest {
	@Test
	public void testDtoToEntity_withValidDto() {
		// given
		OrderDTO dto = new OrderDTO();
		User user = new User();
		dto.setId((long) 1);
		dto.setDate(LocalDate.now());
		dto.setTotal(BigDecimal.valueOf(25.0));
		dto.setUser(user);
		List<OrderLine> orderLines = new ArrayList<>();
		dto.setOrderLines(orderLines);
		List<Pizza> pizzas = new ArrayList<>();
		dto.setPizzas(pizzas);

		// when
		Order entity = OrderMapper.dtoToEntity(dto);

		// then
		assertThat(entity).isNotNull();
		assertEquals(dto.getId(), entity.getId());
		assertEquals(dto.getDate(), entity.getDate());
		assertEquals(dto.getTotal(), entity.getTotal());
		assertEquals(dto.getUser(), entity.getUser());
		assertEquals(dto.getOrderLines(), entity.getOrderLines());
		assertEquals(dto.getPizzas(), entity.getPizzas());
	}

	@Test
	public void testDtoToEntity_withNullDto() {
		// given
		OrderDTO dto = null;

		// when
		Order entity = OrderMapper.dtoToEntity(dto);

		// then
		assertNull(entity);
	}

	@Test
	public void testOrderToDto_withValidOrder() {
		// given
		Order order = new Order();
		User user = new User();
		order.setId((long) 1);
		order.setDate(LocalDate.now());
		order.setTotal(BigDecimal.valueOf(25.0));
		order.setUser(user);
		List<OrderLine> orderLines = new ArrayList<>();
		order.setOrderLines(orderLines);
		List<Pizza> pizzas = new ArrayList<>();
		order.setPizzas(pizzas);

		// when
		OrderDTO dto = OrderMapper.orderToDto(order);

		// then
		assertThat(dto).isNotNull();
		assertEquals(order.getId(), dto.getId());
		assertEquals(order.getDate(), dto.getDate());
		assertEquals(order.getTotal(), dto.getTotal());
		assertEquals(order.getUser(), dto.getUser());
		assertEquals(order.getOrderLines(), dto.getOrderLines());
		assertEquals(order.getPizzas(), dto.getPizzas());
	}

	@Test
	public void testOrderToDto_withNullOrder() {
		// given
		Order order = null;

		// when
		OrderDTO dto = OrderMapper.orderToDto(order);

		// then
		assertNull(dto);
	}

	@Test
	public void testDtoToEntityAndBack() {
		// given
		OrderDTO dto = new OrderDTO();
		User user = new User();
		dto.setId((long) 1);
		dto.setDate(LocalDate.now());
		dto.setTotal(BigDecimal.valueOf(25.0));
		dto.setUser(user);
		List<OrderLine> orderLines = new ArrayList<>();
		dto.setOrderLines(orderLines);
		List<Pizza> pizzas = new ArrayList<>();
		dto.setPizzas(pizzas);

		// when
		Order entity = OrderMapper.dtoToEntity(dto);
		OrderDTO mappedDto = OrderMapper.orderToDto(entity);

		// then
		assertThat(mappedDto).isNotNull();
		assertEquals(dto.getId(), mappedDto.getId());
		assertEquals(dto.getDate(), mappedDto.getDate());
		assertEquals(dto.getTotal(), mappedDto.getTotal());
		assertEquals(dto.getUser(), mappedDto.getUser());
		assertEquals(dto.getOrderLines(), mappedDto.getOrderLines());
		assertEquals(dto.getPizzas(), mappedDto.getPizzas());
	}

	@Test
	public void testDtoToEntity_withPartialDto() {
		// given
		OrderDTO dto = new OrderDTO();
		User user = new User();
		dto.setTotal(BigDecimal.valueOf(25.0));
		dto.setUser(user);

		// when
		Order entity = OrderMapper.dtoToEntity(dto);

		// then
		assertThat(entity).isNotNull();
		assertNull(entity.getId());
		assertNull(entity.getDate());
		assertEquals(dto.getTotal(), entity.getTotal());
		assertEquals(dto.getUser(), entity.getUser());
		assertNull(entity.getOrderLines());
		assertNull(entity.getPizzas());
	}

	@Test
	public void testOrderToDto_withPartialOrder() {
		// given
		Order order = new Order();
		User user = new User();
		order.setId((long) 1);
		order.setTotal(BigDecimal.valueOf(25.0));
		order.setUser(user);

		// when
		OrderDTO dto = OrderMapper.orderToDto(order);

		// then
		assertThat(dto).isNotNull();
		assertEquals(order.getId(), dto.getId());
		assertNull(dto.getDate());
		assertEquals(order.getTotal(), dto.getTotal());
		assertEquals(order.getUser(), dto.getUser());
		assertNull(dto.getOrderLines());
		assertNull(dto.getPizzas());
	}

}
