package com.mentortee.question.domain;

import com.mentortee.common.BaseTimeEntity;

import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
public class Question extends BaseTimeEntity {

    private long id;
    private String questionContents;
    private LocalDate questionDate;
    private boolean questionPublic;
    private boolean questionBlind;
    private boolean questionAnonymous;
}
