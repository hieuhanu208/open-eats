package com.engineerpro.first.helloworld.repositories;

import com.engineerpro.first.helloworld.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
