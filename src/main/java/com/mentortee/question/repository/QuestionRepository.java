package com.mentortee.question.repository;

import com.mentortee.question.domain.Question;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository <Question,Long> {
    Long countByQuestionAnonymousAndQuestionBlind(@Param(value = "questionAnonymous") boolean questionAnonymous,
                                                  @Param(value = "questionBlind") boolean questionBlind );

    List<Question> findAllByQuestionAnonymousAndQuestionBlind(@Param(value = "questionAnonymous") boolean questionAnonymous,
                                                              @Param(value = "questionBlind") boolean questionBlind, PageRequest of);
}
