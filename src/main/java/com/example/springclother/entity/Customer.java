package com.example.springclother.entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Blob;
import java.sql.Date;
import java.util.List;

@Entity
@Data
@Table(name = "customer")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_customer")
    private Integer id;
    @Column(name = "full_name")
    private String fullName;
    @Column(name="email")
    private String email;
    @Column(name="date_of_birth")
    private Date dateOfBirth;
    @Column(name="phone_number")
    private String phoneNumber;
    @Column(name="gender")
    private Boolean gender;
    @Column(name="avatar")
    @Lob
    private Blob avatar;
    @Column(name="facebook_account_id")
    private Integer facebookAccountId;
    @Column(name="google_account_id")
    private Integer googleAccountId;
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
            name = "customer_address",
            joinColumns = @JoinColumn(name = "id_customer"),
            inverseJoinColumns = @JoinColumn(name = "id_address")
    )
    private List<Address> addresses;

    @ManyToOne(cascade = {
            CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.PERSIST, CascadeType.REFRESH
    })
    @JoinColumn(name="id_cart")
    private Cart cart;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Order> listOrder;

}
