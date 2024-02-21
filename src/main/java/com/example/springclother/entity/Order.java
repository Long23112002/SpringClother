package com.example.springclother.entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
import java.util.List;

@Entity
@Data
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_order")
    private Integer id;
    @Column(name ="code")
    private Integer code;
    @Column(name ="phone_number")
    private String phoneNumber;
    @Column(name ="address")
    private String address;
    @Column(name ="user_name")
    private String userName;
    @Column(name ="ship_date")
    private Date shipDate;
    @Column(name ="type")
    private Double type;
    @Column(name ="money_reduce")
    private Double moneyReduce;
    @Column(name ="note")
    private String note;
    @Column(name ="money_ship")
    private Double moneyShip;
    @Column(name ="status")
    private Boolean status;
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
    @JoinTable (
            name = "order_payment_method",
            joinColumns = @JoinColumn(name = "id_order"),
            inverseJoinColumns = @JoinColumn(name = "id_payment_method")
    )
    private List<PaymentMethod> paymentMethods;

    @OneToMany(mappedBy = "orders", cascade = CascadeType.ALL)
    private List<OrderHistory> orderHistories;

    @ManyToMany(cascade = {
            CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.PERSIST, CascadeType.REFRESH
    })
    @JoinTable(
            name = "order_detail",
            joinColumns = @JoinColumn(name = "id_order"),
            inverseJoinColumns = @JoinColumn(name = "id_product_detail")
    )
    private List<ProductDetail> productDetails;

    @ManyToOne(cascade = {
            CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.PERSIST, CascadeType.REFRESH
    })
    @JoinColumn(name = "id_voucher")
    private Voucher voucher;

    @ManyToOne(cascade = {
            CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.PERSIST, CascadeType.REFRESH
    })
    @JoinColumn(name = "id_customer")
    private Customer customer;

    @ManyToOne(cascade = {
            CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.PERSIST, CascadeType.REFRESH
    })
    @JoinColumn(name = "id_user")
    private User users;

}
