package com.engineerpro.first.helloworld.dto;

import lombok.*;

import javax.validation.constraints.NotEmpty;

@Data//toString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDTO {
    @NotEmpty(message = "Category's name cannot be empty")
    private String name;
}

