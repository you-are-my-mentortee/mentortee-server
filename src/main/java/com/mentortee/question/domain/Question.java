package com.mentortee.question.domain;

import com.mentortee.category.domain.CategoryQuestion;
import com.mentortee.common.BaseTimeEntity;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Entity
@Getter
public class Question extends BaseTimeEntity {

    @Id

    private long id;
    private String questionContents;
    private LocalDate questionDate;
    private boolean questionPublic;
    private boolean questionBlind;
    private boolean questionAnonymous;

    @ManyToOne
    @JoinColumn(name = "CATEGORY_ID")
    private CategoryQuestion categoryQuestion;
}
