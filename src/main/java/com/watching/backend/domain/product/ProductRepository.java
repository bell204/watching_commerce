package com.watching.backend.domain.product;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.watching.backend.domain.product.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

  //2
  @Query(value = "select distinct brand from product WHERE (brand RLIKE ?1 OR ( brand >= ?2 AND brand < ?3 ))"
          , nativeQuery = true)
  List<String> findBrandByInitial(String initial1, String initial2, String initial3);

  //1
  Page<Product> findByCategory(String category, Pageable pageable);

}
