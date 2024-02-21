package com.example.springclother.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.engine.jdbc.batch.spi.BatchObserver;

import java.sql.Date;
import java.util.List;

@Entity
@Data
@Table(name = "image")
@Getter
@Setter
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_image")
    private Integer id;
    @Column(name = "cover")
    private String cover;
    @Column(name = "name")
    private String name;
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
            name = "product_detail",
            joinColumns = @JoinColumn(name="id_image"),
            inverseJoinColumns = @JoinColumn(name = "id_product")
    )
    private List<Product> products;
}
