package de.ait.code.product.repository;

import de.ait.code.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;


public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByLanguageAndTranslateLanguage(String language, String translateLanguage);

    List<Product> findByWord(String word);

}
