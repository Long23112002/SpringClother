package com.example.springclother.entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
import java.util.List;

@Entity
@Data
@Table(name = "product")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_product")
    private Integer id;
    @Column(name = "code")
    private Integer code;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
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
            joinColumns = @JoinColumn(name = "id_product"),
            inverseJoinColumns = @JoinColumn(name = "id_size")
    )
    private List<Size> sizes;

    @ManyToMany(cascade = {
            CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.PERSIST, CascadeType.REFRESH
    })
    @JoinTable(
            name = "product_detail",
            joinColumns = @JoinColumn(name="id_product"),
            inverseJoinColumns = @JoinColumn(name = "id_image")
    )
    private List<Image> images;

    @ManyToMany(cascade = {
            CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.PERSIST, CascadeType.REFRESH
    })
    @JoinTable(
            name = "product_detail",
            joinColumns = @JoinColumn(name="id_product"),
            inverseJoinColumns = @JoinColumn(name = "id_category")
    )
    private List<Category> categories;

    @ManyToMany(cascade = {
            CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.PERSIST, CascadeType.REFRESH
    })
    @JoinTable(
            name = "product_detail",
            joinColumns = @JoinColumn(name="id_product"),
            inverseJoinColumns = @JoinColumn(name = "id_color")
    )
    private List<Color> colors;

    @ManyToMany(cascade = {
            CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.PERSIST, CascadeType.REFRESH
    })
    @JoinTable(
            name = "product_detail",
            joinColumns = @JoinColumn(name = "id_product"),
            inverseJoinColumns = @JoinColumn(name = "id_collar")
    )
    private List<Collar> collars;

    @ManyToMany(cascade = {
            CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.PERSIST, CascadeType.REFRESH
    })
    @JoinTable(
            name = "product_detail",
            joinColumns = @JoinColumn(name="id_product"),
            inverseJoinColumns = @JoinColumn(name = "id_sleeve_length")
    )
    private List<SleeveLength> sleeveLengths;

    @ManyToMany(cascade = {
            CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.PERSIST, CascadeType.REFRESH
    })
    @JoinTable(
            name = "product_detail",
            joinColumns = @JoinColumn(name="id_product"),
            inverseJoinColumns = @JoinColumn(name = "id_brand")
    )
    private List<Brand> brands;

    @ManyToMany(cascade = {
            CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.PERSIST, CascadeType.REFRESH
    })
    @JoinTable(
            name = "product_detail",
            joinColumns = @JoinColumn(name="id_product"),
            inverseJoinColumns = @JoinColumn(name = "id_material")
    )
    private List<Material> materials;
}
