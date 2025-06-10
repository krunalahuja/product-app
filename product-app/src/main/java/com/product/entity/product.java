package com.product.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class product {

    @Id
    private int product_code;

    private String product_name;

    private int product_price;

    private int seller_id;

    private String seller_name;

    private String seller_group_name;
}

