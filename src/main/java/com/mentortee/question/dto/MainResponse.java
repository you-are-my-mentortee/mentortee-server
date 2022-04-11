package com.mentortee.question.dto;

import com.mentortee.question.domain.Question;
import lombok.Builder;
import lombok.Getter;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

@Getter
@Builder
public class MainResponse {

    public LocalDate todayDate;
    public String todayDay;
    public String questionContent;
    public String questionCategory;
    public long questionId;

    public static MainResponse from(Question question) {
        LocalDate now = LocalDate.now();
        DayOfWeek dayOfWeek = now.getDayOfWeek();

        if(question == null){
            return null;
        }

        return MainResponse.builder()
                .todayDate(now)
                .todayDay(dayOfWeek.getDisplayName(TextStyle.SHORT, Locale.KOREAN))
                .questionContent(question.getQuestionContents())
                .questionCategory(question.getCategoryQuestion().getCategory().getCategoryContents())
                .questionId(question.getId())
                .build();
    }
}
