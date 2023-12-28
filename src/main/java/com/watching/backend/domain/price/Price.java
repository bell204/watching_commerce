package com.watching.backend.domain.price;

import com.watching.backend.domain.product.Product;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Entity
public class Price {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "product_id", referencedColumnName = "product_id", foreignKey = @ForeignKey(value = ConstraintMode.NO_CONSTRAINT))
  private Product product;

  @Column(name = "\"rank\"")
  private int rank;

  private int price;

  private int delPrice;

  private int coupon;

  private float rating;

  private int ratingCount;

  @CreatedDate
  private LocalDateTime createdDate;

}
