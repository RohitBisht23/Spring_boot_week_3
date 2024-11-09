package com.Rohit.jpaTutorial.JpaTuts.Controllers;

import com.Rohit.jpaTutorial.JpaTuts.Entities.ProductEntity;
import com.Rohit.jpaTutorial.JpaTuts.Repositories.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path="products")
public class ProductController {

    private final ProductRepository productRepository;

    private final  Integer PAGE_SIZE = 5;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping
    public List<ProductEntity> getAllProduct(
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "0")Integer pageNumber,
            @RequestParam(defaultValue="")String title
    ) {
        return productRepository.findByTitleContainingIgnoreCase(title,
                PageRequest.of(pageNumber, PAGE_SIZE, Sort.by(sortBy))
                );
    }

    // GET method to get products with sorting and pagination
    //@GetMapping
    public List<ProductEntity> getAllProduct(
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "0") Integer pageNumber) {

        // Sort by the 'sortBy' field, default is 'id'
        Sort sort = Sort.by(Sort.Direction.DESC, sortBy);

        // Set page size (5)
        //Integer PAGE_SIZE = 5;

        // Create Pageable object
        Pageable pageable = PageRequest.of(pageNumber, PAGE_SIZE, sort);

        // Retrieve paginated and sorted products
        Page<ProductEntity> products = productRepository.findAll(pageable);

        return products.getContent(); // Return page of products
    }
}
