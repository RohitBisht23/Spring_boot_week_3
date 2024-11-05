package com.Rohit.jpaTutorial.JpaTuts;

import com.Rohit.jpaTutorial.JpaTuts.Entities.ProductEntity;
import com.Rohit.jpaTutorial.JpaTuts.Repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class JpaTutsApplicationTests {

	@Autowired
	ProductRepository productRepository;

	@Test
	void contextLoads() {
	}

	@Test
	void testRepository() {
		ProductEntity productEntity = ProductEntity.builder()
				.sku("mecrony43334")
				.title("macrone Chocolate")
				.price(BigDecimal.valueOf(1.24))
				.quantity(1)
				.build();

		ProductEntity savedEntity = productRepository.save(productEntity);
		System.out.println(savedEntity);

	}

	//Test to fetch all
	@Test
	void getRepository() {
//		List<ProductEntity> entities = productRepository.
//				findByCreatedAtAfter(LocalDateTime.of(25,1,01,0,0,0));

		List<ProductEntity> entities = productRepository
				.findByTitleContainingIgnoreCase("choco");
		System.out.println(entities);
	}

	@Test
	void getSingleElementRepository() {
		Optional<ProductEntity> optionalEntity = productRepository.findById(2L); // Use Optional<ProductEntity>

		if (optionalEntity.isPresent()) {
			ProductEntity entity = optionalEntity.get();
			System.out.println(entity);
		} else {
			System.out.println("Entity not found for ID 2");
		}
	}

	@Test
	void getRepositoryByTitleAndPrice() {
		Optional<ProductEntity> entity = productRepository
				.findByTitleAndPrice("macrone Chocolate", BigDecimal.valueOf(1.24));
		entity.ifPresent(System.out::println);
	}

}
