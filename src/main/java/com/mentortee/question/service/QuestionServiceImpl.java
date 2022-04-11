package com.mentortee.question.service;

import com.mentortee.question.domain.Answer;
import com.mentortee.question.domain.Question;
import com.mentortee.question.dto.AnswerSaveDto;
import com.mentortee.question.dto.MainResponse;
import com.mentortee.question.repository.AnswerRepository;
import com.mentortee.question.repository.QuestionRepository;
import com.mentortee.user.domain.Member;
import com.mentortee.user.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QuestionServiceImpl implements QuestionService{

    private final QuestionRepository questionRepository;
    private final AnswerRepository answerRepository;
    private final MemberRepository memberRepository;

    @Override
    public MainResponse getMain() {
        Long totalCount = questionRepository.countByQuestionAnonymousAndQuestionBlind(true, false);

        int idx = (int)(Math.random() * totalCount);

        List<Question> postPage = questionRepository
                .findAllByQuestionAnonymousAndQuestionBlind(
                        true,
                        false,
                        PageRequest.of(0,1)
                );

        return MainResponse.from(postPage.get(0));
    }

    @Override
    public void answerQuestion(long questionId, AnswerSaveDto answerSaveDto, String userName){
        Member member = memberRepository.findByNickName(userName);

        Answer answer = Answer.builder()
                .answerContent(answerSaveDto.getAnswerContent())
                .answerPublic(answerSaveDto.isAnswerPublic())
                .answerBlind(answerSaveDto.isAnswerBlind())
                .answerAnonymous(answerSaveDto.isAnswerAnonymous())
                .member(member)
                .build();

        answerRepository.save(answer);
    }
}
