package com.example.springclother.entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Blob;
import java.sql.Date;
import java.util.List;

@Entity
@Data
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
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

    @OneToMany(mappedBy = "users", cascade = CascadeType.ALL)
    private List<Order> orders;

    @ManyToMany(cascade = {
            CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.PERSIST, CascadeType.REFRESH
    })
    @JoinTable(
            name = "role_user",
            joinColumns = @JoinColumn(name = "id_user"),
            inverseJoinColumns = @JoinColumn(name = "id_role")
    )
    private List<Role> roles;

}
