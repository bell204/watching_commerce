package com.watching.backend.web;

import com.watching.backend.domain.product.InitialWord;
import com.watching.backend.service.ProductService;
import com.watching.backend.web.dto.ProductResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@CrossOrigin("*")
@RequiredArgsConstructor
@RestController
public class ProductController {

  private final ProductService productService;
  private final String DEFAULT_PAGE = "0";

  // 2
  @GetMapping("/api/v1/search/brands")
  public List<String> findBrandByInitial(String type) {
    String[] initial = InitialWord.valueOf("type" + type).getInitials();
    return productService.findBrandByInitial(initial[0], initial[1], initial[2]);
  }

  // 1
  @GetMapping("/api/v1/product/list")
  public Page<ProductResponseDto> findProductByCategory(
          @RequestParam(required = false, defaultValue = "0") int page, String category) {
    return productService
            .findByCategory(category, PageRequest
                    .of(page, 25, Sort.by("modifiedDate").descending().and(Sort.by("rank"))));
  }

}
