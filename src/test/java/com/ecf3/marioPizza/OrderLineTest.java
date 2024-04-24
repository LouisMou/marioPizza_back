package com.ecf3.marioPizza;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.ecf3.marioPizza.core.domain.Order;
import com.ecf3.marioPizza.core.domain.OrderLine;
import com.ecf3.marioPizza.core.domain.Pizza;
import com.ecf3.marioPizza.core.dto.OrderLineDTO;
import com.ecf3.marioPizza.core.dto.mapper.OrderLineMapper;

@SpringBootTest
public class OrderLineTest {
	@Test
	public void testDtoToEntity_withValidDto() {
		// given
		OrderLineDTO dto = new OrderLineDTO();
		Order order = new Order();
		Pizza pizza = new Pizza();
		dto.setId(1);
		dto.setOrder(order);
		dto.setPizza(pizza);
		dto.setQuantity((short) 2);

		// when
		OrderLine entity = OrderLineMapper.dtoToEntity(dto);

		// then
		assertThat(entity).isNotNull();
		assertEquals(dto.getId(), entity.getId());
		assertEquals(dto.getOrder(), entity.getOrder());
		assertEquals(dto.getPizza(), entity.getPizza());
		assertEquals(dto.getQuantity(), entity.getQuantity());
	}

	@Test
	public void testDtoToEntity_withNullDto() {
		// given
		OrderLineDTO dto = null;

		// when
		OrderLine entity = OrderLineMapper.dtoToEntity(dto);

		// then
		assertNull(entity);
	}

	@Test
	public void testOrderLineToDto_withValidOrderLine() {
		// given
		OrderLine orderLine = new OrderLine();
		Order order = new Order();
		Pizza pizza = new Pizza();
		orderLine.setId(1);
		orderLine.setOrder(order);
		orderLine.setPizza(pizza);
		orderLine.setQuantity((short) 2);

		// when
		OrderLineDTO dto = OrderLineMapper.orderLineToDto(orderLine);

		// then
		assertThat(dto).isNotNull();
		assertEquals(orderLine.getId(), dto.getId());
		assertEquals(orderLine.getOrder(), dto.getOrder());
		assertEquals(orderLine.getPizza(), dto.getPizza());
		assertEquals(orderLine.getQuantity(), dto.getQuantity());
	}

	@Test
	public void testOrderLineToDto_withNullOrderLine() {
		// given
		OrderLine orderLine = null;

		// when
		OrderLineDTO dto = OrderLineMapper.orderLineToDto(orderLine);

		// then
		assertNull(dto);
	}

	@Test
	public void testDtoToEntityAndBack() {
		// given
		OrderLineDTO dto = new OrderLineDTO();
		Order order = new Order();
		Pizza pizza = new Pizza();
		dto.setId(1);
		dto.setOrder(order);
		dto.setPizza(pizza);
		dto.setQuantity((short) 2);

		// when
		OrderLine entity = OrderLineMapper.dtoToEntity(dto);
		OrderLineDTO mappedDto = OrderLineMapper.orderLineToDto(entity);

		// then
		assertThat(mappedDto).isNotNull();
		assertEquals(dto.getId(), mappedDto.getId());
		assertEquals(dto.getOrder(), mappedDto.getOrder());
		assertEquals(dto.getPizza(), mappedDto.getPizza());
		assertEquals(dto.getQuantity(), mappedDto.getQuantity());
	}

	@Test
	public void testDtoToEntity_withPartialDto() {
		// given
		OrderLineDTO dto = new OrderLineDTO();
		Order order = new Order();
		Pizza pizza = new Pizza();
		dto.setOrder(order);
		dto.setPizza(pizza);
		dto.setQuantity((short) 2);

		// when
		OrderLine entity = OrderLineMapper.dtoToEntity(dto);

		// then
		assertThat(entity).isNotNull();
		assertNull(entity.getId());
		assertEquals(dto.getOrder(), entity.getOrder());
		assertEquals(dto.getPizza(), entity.getPizza());
		assertEquals(dto.getQuantity(), entity.getQuantity());
	}

	@Test
	public void testOrderLineToDto_withPartialOrderLine() {
		// given
		OrderLine orderLine = new OrderLine();
		orderLine.setId(1);
		orderLine.setQuantity((short) 2);

		// when
		OrderLineDTO dto = OrderLineMapper.orderLineToDto(orderLine);

		// then
		assertThat(dto).isNotNull();
		assertEquals(orderLine.getId(), dto.getId());
		assertNull(dto.getOrder());
		assertNull(dto.getPizza());
		assertEquals(orderLine.getQuantity(), dto.getQuantity());
	}

}
