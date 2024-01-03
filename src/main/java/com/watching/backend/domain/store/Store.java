package com.watching.backend.domain.store;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Store implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String phone;

    private String address;

    private String openStatus;

    private String introduction;

    private long categoryId;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

}
