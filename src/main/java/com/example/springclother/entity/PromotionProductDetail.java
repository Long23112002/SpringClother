package com.example.springclother.entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;

@Entity
@Data
@Table(name = "promotion_product_detail")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PromotionProductDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_promotion_product_detail")
    private Integer id;
    @Column(name = "created_by")
    private String createdBy;
    @Column(name="created_at")
    private Date createdAt;
    @Column(name = "updated_by")
    private String updatedBy;
    @Column(name = "updated_at")
    private Date updatedAt;
    @Column(name = "deleted")
    private Boolean deleted;

}
