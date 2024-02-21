package com.example.springclother.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import java.sql.Date;
import java.util.List;

@Entity
@Data
@Table(name = "voucher")
@Getter
@Setter
public class Voucher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_voucher")
    private Integer id;

    @Column(name = "name")
    private String name;
    @Column(name = "code")
    private Integer code;
    @Column(name = "quantity")
    private Integer quantity;
    @Column(name = "start_date")
    private Date startDate;
    @Column(name = "end_date")
    private Date endDate;
    @Column(name = "minimum_value")
    private String minimumValue;
    @Column(name = "type")
    private Double type;
    @Column(name = "value")
    private Double value;
    @Column(name = "minimize")
    private Double minimize;
    @Column(name = "status")
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

    @OneToMany(mappedBy = "voucher", cascade = CascadeType.ALL)
    private List<Order> listOrder;
}
