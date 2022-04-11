package com.mentortee.question.domain;

import com.mentortee.category.domain.CategoryQuestion;
import com.mentortee.common.BaseTimeEntity;
import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
public class Question extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String questionContents;
    private boolean questionPublic;
    private boolean questionBlind;
    private boolean questionAnonymous;

    @OneToOne
    @JoinColumn(name = "CATEGORY_QUESTION_ID")
    private CategoryQuestion categoryQuestion;
}
