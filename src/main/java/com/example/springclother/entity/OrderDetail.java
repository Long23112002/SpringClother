package com.example.springclother.entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;

@Entity
@Data
@Table(name = "order_detail")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_order_detail")
    private Integer id;
    @Column(name = "price")
    private Double price;
    @Column(name = "quantity")
    private Integer quantity;
    @Column(name = "total_money")
    private Double totalMoney;
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
