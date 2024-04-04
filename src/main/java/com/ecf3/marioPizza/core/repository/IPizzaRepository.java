/**
 */
package com.ecf3.marioPizza.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecf3.marioPizza.core.domain.Pizza;

@Repository
public interface IPizzaRepository extends JpaRepository<Pizza, Integer> {

}
