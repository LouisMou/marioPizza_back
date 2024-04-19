/**
 * 
 */
package com.ecf3.marioPizza.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecf3.marioPizza.core.domain.OrderLine;

/**
 * 
 */
public interface IOLineRepository extends JpaRepository<OrderLine, Long> {

}
