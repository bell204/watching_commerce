package com.watching.backend.service;

import com.watching.backend.MapperUtils;
import com.watching.backend.domain.product.Product;
import com.watching.backend.domain.product.ProductRepository;
import com.watching.backend.web.dto.ProductResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class ProductService {

  private final ProductRepository productRepository;

  // 1
  public Page<ProductResponseDto> findByCategory(String category, Pageable pageable) {
    productRepository.findByCategory("001", pageable);
    Page<Product> page = productRepository.findByCategory(category, pageable);
    return new PageImpl<ProductResponseDto>(page.getContent()
            .stream()
            .map(ProductResponseDto::new)
            .collect(Collectors.toList()), pageable, page.getTotalElements());
  }

  //2
  public List<String> findBrandByInitial(String initial1, String initial2, String initial3) {
    return productRepository.findBrandByInitial(initial1, initial2, initial3);
  }
}
