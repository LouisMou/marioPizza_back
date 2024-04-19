/**
 * 
 */
package com.ecf3.marioPizza.core.service;

import com.ecf3.marioPizza.core.domain.OrderLine;

/**
 * 
 */
public interface IOrderLineService {

	OrderLine save(OrderLine dtoToEntity);

}
