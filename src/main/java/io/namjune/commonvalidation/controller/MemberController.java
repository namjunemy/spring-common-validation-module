package io.namjune.commonvalidation.controller;

import io.namjune.commonvalidation.dto.MemberRequestDto;
import io.namjune.commonvalidation.dto.MemberResponseDto;
import io.namjune.commonvalidation.service.MemberService;
import java.util.List;
import javax.validation.Valid;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/member")
    public Long saveMember(@RequestBody @Valid MemberRequestDto memberRequestDto) {
        return memberService.save(memberRequestDto);
    }

    @GetMapping("/members")
    public List<MemberResponseDto> findAll() {
        return memberService.findAll();
    }
}
