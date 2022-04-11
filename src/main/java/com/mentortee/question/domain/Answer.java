package com.mentortee.question.domain;


import com.mentortee.category.domain.Category;
import com.mentortee.user.domain.Member;
import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String answerContent;

    private boolean answerPublic;

    private boolean answerBlind;

    private boolean anserAnonymous;

    @ManyToOne
    @JoinColumn(name="MEMBER_ID")
    private Member member;

    @ManyToOne
    @JoinColumn(name="QUESTIONS_ID")
    private Question question;


}
