package com.mentortee.user.api;

import com.mentortee.question.dto.AnswerSaveDto;
import com.mentortee.user.dto.NickNameDto;
import com.mentortee.user.service.MemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
@Api(tags = {"사용자 API 정보를 제공"})
public class MemberApi {

    private final MemberService memberService;

    @ApiOperation(value = "사용자 닉네임 설정")
    @PostMapping(path = "/user")
    public ResponseEntity<Void> setNickName(@RequestBody NickNameDto nickNameDto) {
        memberService.save(nickNameDto);
        return ResponseEntity.ok().build();
    }

}
