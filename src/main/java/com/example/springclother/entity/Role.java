package com.example.springclother.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_role")
    private Integer id;
    @Column(name = "role_name")
    private String roleName;

    @ManyToMany(cascade = {
            CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.PERSIST, CascadeType.REFRESH
    })
    @JoinTable(
            name = "role_user",
            joinColumns = @JoinColumn(name="id_role"),
            inverseJoinColumns = @JoinColumn(name = "id_user")
    )
    private List<User> users;
}
