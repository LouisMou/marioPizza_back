package com.ecf3.marioPizza.core.dto.mapper;

import com.ecf3.marioPizza.core.domain.OrderLine;
import com.ecf3.marioPizza.core.dto.OrderLineDTO;

public class OrderLineMapper {

	/**
	 * Create an OrderLine from an OrderLineDTO.
	 *
	 * @param dto the dto used as a source
	 * @return an OrderLine filled with datas from dto
	 */
	public static OrderLine dtoToEntity(final OrderLineDTO dto) {
		OrderLine entity = null;

		if (dto != null) {
			entity = new OrderLine();
			entity.setId(dto.getId());
			entity.setOrder(dto.getOrder());
			entity.setPizza(dto.getPizza());
			entity.setQuantity(dto.getQuantity());
		}

		return entity;
	}

	/**
	 *
	 * @param orderLine a OrderLine
	 * @return the OrderLine turned into its sibling OrderLineDTO
	 */
	public static OrderLineDTO orderLineToDto(final OrderLine orderLine) {
		OrderLineDTO dto = null;

		if (orderLine != null) {
			dto = new OrderLineDTO();

			dto.setId(orderLine.getId());
			dto.setOrder(orderLine.getOrder());
			dto.setPizza(orderLine.getPizza());
			dto.setQuantity(orderLine.getQuantity());
		}

		return dto;
	}

}
