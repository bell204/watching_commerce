package com.watching.backend.web.dto;

import com.watching.backend.domain.product.Product;
import lombok.Builder;
import lombok.Getter;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
public class ProductResponseDto implements Serializable {

  private int productId;
  private String img;
  private String productName;
  private String productUrl;
  private String brand;
  private String brandUrl;
  private LocalDate modifiedDate;
  private String category;

  @Builder
  public ProductResponseDto(Product entity) {
    this.productId = entity.getProductId();
    this.img = entity.getImg();
    this.productName = entity.getProductName();
    this.productUrl = entity.getProductUrl();
    this.brand = entity.getBrand();
    this.brandUrl = entity.getBrandUrl();
    this.modifiedDate = entity.getModifiedDate().toLocalDate();
    this.category = entity.getCategory();
  }
}
