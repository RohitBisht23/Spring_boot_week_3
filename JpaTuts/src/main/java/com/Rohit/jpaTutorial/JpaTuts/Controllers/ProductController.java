package com.Rohit.jpaTutorial.JpaTuts.Controllers;

import com.Rohit.jpaTutorial.JpaTuts.Entities.ProductEntity;
import com.Rohit.jpaTutorial.JpaTuts.Repositories.ProductRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path="products")
public class ProductController {

    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping
    public List<ProductEntity> getTitleContainingIgnoreCase() {
        return productRepository.findByOrderByPriceAsc();
    }
}
