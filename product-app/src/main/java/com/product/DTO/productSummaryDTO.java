package com.product.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class productSummaryDTO {
    private Integer product_code;
    private String product_name;
    private Integer product_price;
}

