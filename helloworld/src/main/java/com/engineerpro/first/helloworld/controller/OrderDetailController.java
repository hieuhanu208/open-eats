package com.engineerpro.first.helloworld.controller;

import com.engineerpro.first.helloworld.dto.OrderDetailDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("${api.prefix}/order_details")
public class OrderDetailController {
    @PostMapping("")
    public ResponseEntity<?> createOrderDetail(@Valid @RequestBody OrderDetailDTO orderDetailDTO, BindingResult result) {
        try {
            if (result.hasErrors()) {
                List<String> errors = result.getFieldErrors().stream().map(FieldError::getDefaultMessage).toList();
                return ResponseEntity.badRequest().body(errors);
            }
            return ResponseEntity.ok("Create Order successfully");
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOrdersDetail(@Valid @PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok("get order from user");
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @GetMapping("/order/{orderId}")
    public ResponseEntity<?> getOrdersDetails(@Valid @PathVariable("orderId") Long orderId) {
        return ResponseEntity.ok("get order with order ID" + orderId);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateOrderDetails(@Valid @PathVariable("id") Long id, @Valid @RequestBody OrderDetailDTO orderDetailDTO) {
        return ResponseEntity.ok("update order details with ID" + id);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> updateOrderDetails(@Valid @PathVariable("id") Long id) {
        return ResponseEntity.ok("update order details with ID" + id);
    }
}
