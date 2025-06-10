package com.product.DTO;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class productDTO {

    @NotNull(message = "Product code must be provided")
    @Min(value =1,message = "Product code is starting from 1")
    private Integer product_code;

    @NotBlank(message = "Product name cannot be blank")
    private String product_name;

    @NotNull(message = "Product price must be provided")
    @Min(value = 1, message = "Product price must be greater than 0")
    private Integer product_price;

    @NotNull(message = "Seller ID must be provided")
    @Min(value = 1, message = "Seller ID must be greater than 0")
    private Integer seller_id;

    @NotBlank(message = "Seller name cannot be blank")
    private String seller_name;

    @NotBlank(message = "Seller group name cannot be blank")
    private String seller_group_name;
}




