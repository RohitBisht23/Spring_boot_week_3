package com.Rohit.jpaTutorial.JpaTuts.Repositories;

import com.Rohit.jpaTutorial.JpaTuts.Entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
    List<ProductEntity> findByTitle(String title_name);

    List<ProductEntity> findByCreatedAtAfter(LocalDateTime after);


    List<ProductEntity> findByTitleContainingIgnoreCase(String title);

    //ProductEntity findByTitleAndPrice(String title, BigDecimal price);


    //Custom query for complex query
    @Query("select e ProductEntity e where e.title:title and e.price:price")
    Optional<ProductEntity> findByTitleAndPrice(String title, BigDecimal price);
}
