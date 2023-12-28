package com.watching.backend.domain.product;

import com.watching.backend.domain.price.Price;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@Getter
@Entity
public class Product implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "product_id")
  private int productId;

  @Column(name = "\"rank\"")
  private int rank;

  private String img;

  private String productName;

  private String productUrl;

  private String brand;

  private String brandUrl;

  private LocalDateTime modifiedDate;

  private String category;

  @OneToMany(mappedBy = "product")
  Set<Price> prices = new HashSet<>();

  @Builder
  public Product(int productId, String productName, String brand, String category, int rank ){
    this.productId = productId;
    this.productName = productName;
    this.brand = brand;
    this.category = category;
    this.rank = rank;
  }
}
