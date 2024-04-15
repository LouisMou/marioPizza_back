/**
 *
 */
package com.ecf3.marioPizza.security.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecf3.marioPizza.security.models.Role;
import com.ecf3.marioPizza.security.models.RoleName;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
	/**
	 *
	 * @param roleName
	 * @return return thecorrespondif.
	 */
	Optional<Role> findByName(RoleName roleName);
}
