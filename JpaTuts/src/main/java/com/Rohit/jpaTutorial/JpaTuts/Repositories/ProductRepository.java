package com.Rohit.jpaTutorial.JpaTuts.Repositories;

import com.Rohit.jpaTutorial.JpaTuts.Entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
    List<ProductEntity>findByOrderByPriceAsc();

    //List<ProductEntity> findByCreatedAtAfter(LocalDateTime after);

    List<ProductEntity> findByTitleContainingIgnoreCase(String title);

    //ProductEntity findByTitleAndPrice(String title, BigDecimal price);

    //Custom query for complex query
    @Query("select p from ProductEntity p where p.title = :title and p.price = :price")
    Optional<ProductEntity> findByTitleAndPrice(String title, BigDecimal price);

    //Sorting
    List<ProductEntity> findByTitleOrderByPriceAsc(String title);  // or OrderByPriceDesc
}
