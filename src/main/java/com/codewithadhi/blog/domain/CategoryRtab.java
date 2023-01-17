package com.codewithadhi.blog.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Table(name = "category_rtab")
@Getter
@Setter
public class CategoryRtab {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "category_title", length = 100, nullable = false)
    private String title;

    @Column(name = "category_description")
    private String description;

}
