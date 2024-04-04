package org.example.entities;

import jakarta.persistence.*;
import lombok.Data;
@Entity
@Table(name = "tbl_categories")
@Data
public class CategoryEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 200, nullable = false)
    private String name;

}

