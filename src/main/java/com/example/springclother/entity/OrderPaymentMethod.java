package com.example.springclother.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;

@Entity
@Data
@Table(name = "order_payment_method")
public class OrderPaymentMethod {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_order_payment_method")
    private Integer id;
    @Column(name="note")
    private String note;
    @Column(name="money")
    private Double money;
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
