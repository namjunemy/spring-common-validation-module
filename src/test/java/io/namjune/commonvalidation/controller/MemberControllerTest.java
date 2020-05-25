package io.namjune.commonvalidation.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.namjune.commonvalidation.dto.MemberRequestDto;
import io.namjune.commonvalidation.service.MemberService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(MemberController.class)
public class MemberControllerTest {

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MemberService memberService;

    @Test
    @DisplayName("Enum 매칭 실패 테스트")
    void Enum_매칭_실패() throws Exception {
        // given
        MemberRequestDto requestDto = MemberRequestDto.builder()
                .name("KNJ")
                .email("namjunemy@gmail.com")
                .phoneNumber("01012341234")
                .memberType("guest")
                .build();

        // when & then
        mockMvc.perform(post("/member")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(objectMapper.writeValueAsBytes(requestDto)))
                .andExpect(status().isBadRequest());
    }
}