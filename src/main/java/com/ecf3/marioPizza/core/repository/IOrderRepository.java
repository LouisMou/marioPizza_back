/**
 * 
 */
package com.ecf3.marioPizza.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecf3.marioPizza.core.domain.Order;

/**
 * 
 */
public interface IOrderRepository extends JpaRepository<Order, Long> {

}
