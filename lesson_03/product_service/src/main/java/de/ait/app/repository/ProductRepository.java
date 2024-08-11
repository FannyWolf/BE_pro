package de.ait.app.repository;

import de.ait.app.entity.Product;

import java.util.List;

public interface ProductRepository {

    List<Product> findAll();
    Product save (Product product);
    Product delete(Product product);


}

