package com.ecf3.marioPizza.core.dto.mapper;

import com.ecf3.marioPizza.core.domain.Order;
import com.ecf3.marioPizza.core.dto.OrderDTO;

public class OrderMapper {

	/**
	 * Create an OrderLine from an OrderLineDTO.
	 *
	 * @param dto the dto used as a source
	 * @return an OrderLine filled with datas from dto
	 */
	public static Order dtoToEntity(final OrderDTO dto) {
		Order entity = null;

		if (dto != null) {
			entity = new Order();
			entity.setId(dto.getId());
			entity.setDate(dto.getDate());
			entity.setTotal(dto.getTotal());
			entity.setUser(dto.getUser());
			entity.setOrderLines(dto.getOrderLines());
			entity.setPizzas(dto.getPizzas());
		}

		return entity;
	}

	/**
	 *
	 * @param orderLine a OrderLine
	 * @return the OrderLine turned into its sibling OrderLineDTO
	 */
	public static OrderDTO orderToDto(final Order order) {
		OrderDTO dto = null;

		if (order != null) {
			dto = new OrderDTO();

			dto.setId(order.getId());
			dto.setDate(order.getDate());
			dto.setTotal(order.getTotal());
			dto.setUser(order.getUser());
			dto.setOrderLines(order.getOrderLines());
			dto.setPizzas(order.getPizzas());
		}

		return dto;
	}

}
