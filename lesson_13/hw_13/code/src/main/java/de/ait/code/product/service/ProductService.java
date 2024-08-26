package de.ait.code.product.service;

import de.ait.code.product.dto.ProductRequestDto;
import de.ait.code.product.dto.ProductResponseDto;

import java.util.List;

public interface ProductService {

    List<ProductResponseDto> findAll();
    ProductResponseDto save(ProductRequestDto dto);
    ProductResponseDto findById(Long id);
}
