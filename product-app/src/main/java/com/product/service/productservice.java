package com.product.service;

import com.product.DTO.productDTO;
import com.product.DTO.productSummaryDTO;
import com.product.entity.product;
import com.product.repository.productrepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class productservice {

    @Autowired
    private productrepository repository;

    @Autowired
    private ModelMapper mapper;

    public List<productSummaryDTO> getAllProducts() {
        return repository.findAll().stream()
                .map(product -> mapper.map(product, productSummaryDTO.class))
                .collect(Collectors.toList());
    }

    public productDTO getProductById(int code) {
        Optional<product> product = repository.findById(code);
        return convertToDTO(product.orElse(null));
    }

    public productDTO saveProduct(productDTO dto) {
        product saved = repository.save(convertToEntity(dto));
        return convertToDTO(saved);
    }

    public productDTO updateProduct(int code, productDTO dto) {
        if (!repository.existsById(code)) {
            System.out.println("product not found!!");
            return null;
        }
        dto.setProduct_code(code);
        product updated = repository.save(convertToEntity(dto));
        return convertToDTO(updated);
    }

    public void deleteProduct(int code) {
        repository.deleteById(code);
    }

    public void deleteall() {
        repository.deleteAll();
    }

    // Manual mapping methods (not used currently but kept for reference)
    // public productDTO convertToDTO(product product) {
    //     return new productDTO(
    //             product.getProduct_code(),
    //             product.getProduct_name(),
    //             product.getProduct_price()
    //     );
    // }

    // public product convertToEntity(productDTO dto) {
    //     product product = new product();
    //     product.setProduct_code(dto.getProduct_code());
    //     product.setProduct_name(dto.getProduct_name());
    //     product.setProduct_price(dto.getProduct_price());
    //     return product;
    // }


    public productDTO convertToDTO(product product){
        return mapper.map(product, productDTO.class);
    }

    public product convertToEntity(productDTO dto){
        return mapper.map(dto, product.class);
    }
}



