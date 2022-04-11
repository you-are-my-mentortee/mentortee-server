package com.mentortee.category.domain;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Getter
@Entity
public class CategoryQuestion {
    private Long id;

    @ManyToOne
    @JoinColumn(name="CATEGORY_ID")
    private Category category;

}
