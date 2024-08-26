package de.ait.code.product.service;

import de.ait.code.product.dto.ProductRequestDto;
import de.ait.code.product.dto.ProductResponseDto;
import de.ait.code.product.entity.Product;
import de.ait.code.product.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repository;
    private final ModelMapper mapper;


    @Override
    public List<ProductResponseDto> findAll() {
        return repository.findAll().stream()
                .map(e -> mapper.map(e, ProductResponseDto.class))
                .toList();
    }

    @Override
    public ProductResponseDto save(ProductRequestDto dto) {
        Product entity = mapper.map(dto, Product.class);
        Product newProduct = repository.save(entity);
        return mapper.map(newProduct, ProductResponseDto.class);
    }

    @Override
    public ProductResponseDto findById(Long id) {
        Optional<Product> productById = repository.findById(id);
        return productById
                .map(p -> mapper.map(p, ProductResponseDto.class))
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }


}
