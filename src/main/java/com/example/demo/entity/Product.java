package com.example.demo.entity;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Data
@Builder
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private String name;
    private String quantity;
    private double price;
    private String description;
    private String imageUrl;
    private Date createdDate;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<Image> images ;

    @ManyToOne
    @JoinColumn(name = "status_id")
    private StatusProduct status;

    @OneToMany(mappedBy = "product",cascade = CascadeType.ALL)
    private List<OrderDetail> orderDetails;

    @ManyToOne
    @JoinColumn(name = "subCategory_id")
    private SubCategory subCategory;
}
