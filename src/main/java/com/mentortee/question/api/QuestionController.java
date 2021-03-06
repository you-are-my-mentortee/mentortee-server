package com.mentortee.question.api;

import com.mentortee.question.dto.AnswerSaveDto;
import com.mentortee.question.dto.MainResponse;
import com.mentortee.question.service.QuestionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Conditional;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
@Api(tags = {"질문 API 정보를 제공"})
public class QuestionController {

    private final QuestionService questionService;

    @ApiOperation(value = "메인 화면")
    @GetMapping(path = "/main")
    public ResponseEntity<MainResponse> getMain() {
        MainResponse mainResponse = questionService.getMain();
        return ResponseEntity.ok(mainResponse);
    }

//    @ApiOperation(value = "질문하기")
//    @PostMapping(path = "/question/")
//    public ResponseEntity<Void> askQuestion(@PathVariable long questionId, @RequestBody QuestionSaveDto answerSaveDto) {
//        questionService.answerQuestion(questionId, answerSaveDto);
//        return ResponseEntity.ok().build();
//    }

    @ApiOperation(value = "답변하기")
    @PostMapping(path = "/question/{questionId}")
    public ResponseEntity<Void> answerQuestion(@PathVariable long questionId, @RequestBody AnswerSaveDto answerSaveDto) {
        questionService.answerQuestion(questionId, answerSaveDto);
        return ResponseEntity.ok().build();
    }
}
