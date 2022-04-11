package com.mentortee.question.service;

import com.mentortee.question.dto.AnswerSaveDto;
import com.mentortee.question.dto.MainResponse;
import org.springframework.stereotype.Service;

@Service
public interface QuestionService {
    MainResponse getMain();
    void answerQuestion(long questionId, AnswerSaveDto answerSaveDto);
}
