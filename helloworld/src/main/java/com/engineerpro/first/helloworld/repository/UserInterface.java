package com.engineerpro.first.helloworld.repository;

import com.engineerpro.first.helloworld.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface UserInterface extends JpaRepository<User, Integer> {

}
