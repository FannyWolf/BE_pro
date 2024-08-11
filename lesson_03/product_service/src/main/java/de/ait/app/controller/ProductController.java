package de.ait.app.controller;

import de.ait.app.entity.Product;
import de.ait.app.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductController {
    private final ProductService service;

    @Autowired
    public ProductController(ProductService service) {
        this.service = service;
    }

    public List<Product> getAllProduct(){
        return service.getAllProducts();
    }

    public Product getProductById(Long id){
        return service.getProductById(id);
    }


}
