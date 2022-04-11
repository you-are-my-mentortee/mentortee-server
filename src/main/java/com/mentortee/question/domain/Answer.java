package com.mentortee.question.domain;


import com.mentortee.category.domain.Category;
import com.mentortee.common.BaseTimeEntity;
import com.mentortee.question.dto.AnswerSaveDto;
import com.mentortee.user.domain.Member;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Getter
public class Answer extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String answerContent;

    private boolean answerPublic;

    private boolean answerBlind;

    private boolean answerAnonymous;

    @ManyToOne
    @JoinColumn(name="MEMBER_ID")
    private Member member;

    @ManyToOne
    @JoinColumn(name="QUESTIONS_ID")
    private Question question;

    @Builder
    public Answer(String answerContent, boolean answerAnonymous, boolean answerBlind,
                  boolean answerPublic, Member member, Question question){
        this.answerContent = answerContent;
        this.answerPublic = answerAnonymous;
        this.answerBlind = answerBlind;
        this.answerAnonymous = answerBlind;
        setMember(member);
        setQuestion(question);
    }

    public void setMember (Member member){
        if (Objects.isNull(this.member)) {
            this.member = member;
        }
    }
    public void setQuestion (Question question){
        this.question = question;
    }
}
