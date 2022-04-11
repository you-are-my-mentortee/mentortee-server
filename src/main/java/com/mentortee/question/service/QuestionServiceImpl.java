package com.mentortee.question.service;

import com.mentortee.question.domain.Question;
import com.mentortee.question.dto.MainResponse;
import com.mentortee.question.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QuestionServiceImpl implements QuestionService{

    private final QuestionRepository questionRepository;

    @Override
    public MainResponse getMain() {
        Long totalCount = questionRepository.countByQuestionAnonymousAndQuestionBlind(true, false);

        int idx = (int)(Math.random() * totalCount);

        List<Question> postPage = questionRepository
                .findAllByQuestionAnonymousAndQuestionBlind(
                        true,
                        false,
                        PageRequest.of(idx, 1)
                );

        return MainResponse.from(postPage.get(0));
    }
}
