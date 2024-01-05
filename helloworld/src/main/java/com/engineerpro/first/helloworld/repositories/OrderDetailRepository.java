package com.engineerpro.first.helloworld.repositories;

import com.engineerpro.first.helloworld.model.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long> {
}
