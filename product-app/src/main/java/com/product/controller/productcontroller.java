package com.product.controller;

import com.product.DTO.productDTO;
import com.product.DTO.productSummaryDTO;
import com.product.service.productservice;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class productcontroller {

    @Autowired
    private productservice service;

    @GetMapping("/all")
    public ResponseEntity<?> getAllProducts() {
        List<productSummaryDTO> products = service.getAllProducts();
        if (products.isEmpty()) {
            return new ResponseEntity<>("No products available", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/one/{id}")
    public ResponseEntity<?> getProductById(@PathVariable int id) {
        productDTO dto = service.getProductById(id);
        if (dto == null) {
            return new ResponseEntity<>("Product not found with ID: " + id, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<?> createProduct(@Valid @RequestBody productDTO dto) {
        productDTO saved = service.saveProduct(dto);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateProduct(@PathVariable int id, @Valid @RequestBody productDTO dto) {
        productDTO updated = service.updateProduct(id, dto);
        if (updated == null) {
            return new ResponseEntity<>("Product not found with ID: " + id, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable int id) {
        productDTO dto = service.getProductById(id);
        if (dto == null) {
            return new ResponseEntity<>("Product not found with ID: " + id, HttpStatus.NOT_FOUND);
        }
        service.deleteProduct(id);
        return new ResponseEntity<>("Product deleted successfully", HttpStatus.OK);
    }

    @DeleteMapping("/deleteall")
    public ResponseEntity<?> deleteAllProducts() {
        service.deleteall();
        return new ResponseEntity<>("All products deleted successfully", HttpStatus.OK);
    }
}







