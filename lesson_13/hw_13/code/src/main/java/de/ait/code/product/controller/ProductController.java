package de.ait.code.product.controller;

import de.ait.code.product.dto.ProductRequestDto;
import de.ait.code.product.dto.ProductResponseDto;
import de.ait.code.product.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class ProductController {

    private final ProductService service;

    @GetMapping("/products")
    public List<ProductResponseDto> getProducts() {
        return service.findAll();
    }

    @GetMapping("/products/{id}")
    public ProductResponseDto getProductById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping("/products")
    public ProductResponseDto createProduct(@RequestBody ProductRequestDto dto) {
        return service.save(dto);
    }

}
