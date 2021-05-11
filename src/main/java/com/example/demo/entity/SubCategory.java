package com.example.demo.entity;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Builder
public class SubCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String subCategoryName;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private  Category category;

    @ManyToOne
    @JoinColumn(name = "status_id")
    private StatusSubCategory status;

    @OneToMany(mappedBy = "status", cascade = CascadeType.ALL)
    private List<Product> products;
}
