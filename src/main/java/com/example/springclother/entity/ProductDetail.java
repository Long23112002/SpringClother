package com.example.springclother.entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "product_detail")
public class ProductDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_product_detail")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "gender")
    private Integer gender;
    @Column(name = "price")
    private Double price;
    @Column(name = "quantity")
    private Integer quantity;
    @Column(name = "weight")
    private Double weight;
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

    @ManyToMany(cascade = {
            CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.PERSIST, CascadeType.REFRESH
    })
    @JoinTable(
            name = "promotion_product_detail",
            joinColumns = @JoinColumn(name = "id_product_detail"),
            inverseJoinColumns = @JoinColumn(name = "id_promotion")
    )
    private List<Promotion> promotions;

    @ManyToMany(cascade = {
            CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.PERSIST, CascadeType.REFRESH
    })
    @JoinTable(
            name = "order_detail",
            joinColumns = @JoinColumn(name = "id_product_detail"),
            inverseJoinColumns = @JoinColumn(name = "id_order")
    )
    private List<Order> orders;

    @ManyToMany(cascade = {
            CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.PERSIST, CascadeType.REFRESH
    })
    @JoinTable(
            name = "cart_detail",
            joinColumns = @JoinColumn(name = "id_product_detail"),
            inverseJoinColumns = @JoinColumn(name = "id_cart")
    )
    private List<Cart> carts;


}
