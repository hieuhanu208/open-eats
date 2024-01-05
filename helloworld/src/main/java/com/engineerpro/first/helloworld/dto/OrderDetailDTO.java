package com.engineerpro.first.helloworld.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetailDTO {
    @JsonProperty("order_id")
    @Min(value = 1, message = "Order's ID must greater than 0")
    private Long orderId;
    @JsonProperty("product_id")
    @Min(value = 1, message = "Product's ID must greater than 0")
    private Long productId;
    @Min(value = 1, message = "Product's ID must >=1")
    private Long price;
    @JsonProperty("number_of_products")
    @Min(value = 1, message = "numberOfProducts must >=1")
    private String numberOfProducts;
    @JsonProperty("total_money")
    @Min(value = 1, message = "totalMoney must >=1")
    private int totalMoney;
    private String color;

}
