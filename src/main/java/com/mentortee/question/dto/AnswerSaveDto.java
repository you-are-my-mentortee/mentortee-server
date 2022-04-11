package com.mentortee.question.dto;

import lombok.Getter;

@Getter
public class AnswerSaveDto {

    private String answerContent;

    private boolean answerPublic;

    private boolean answerBlind;

    private boolean answerAnonymous;

}

