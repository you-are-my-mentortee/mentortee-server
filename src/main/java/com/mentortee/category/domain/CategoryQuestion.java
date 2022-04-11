package com.mentortee.category.domain;

import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
public class CategoryQuestion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="CATEGORY_ID")
    private Category category;

}
