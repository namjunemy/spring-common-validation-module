package io.namjune.commonvalidation.service;

import io.namjune.commonvalidation.domain.Member;
import io.namjune.commonvalidation.dto.MemberRequestDto;
import io.namjune.commonvalidation.exception.ValidCustomException;
import io.namjune.commonvalidation.repository.MemberRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;


@ExtendWith(SpringExtension.class)
class MemberServiceTest {

    private static final String TEST_EMAIL = "njkim@test.com";

    private Member member;

    @Mock
    MemberRepository memberRepository;

    @InjectMocks
    MemberService memberService;

    @Test
    @DisplayName("Email 중복 검증 테스트")
    void Email_중복_검증() {
        // given
        MemberRequestDto requestDto = MemberRequestDto.builder()
            .name("KNJ")
            .email(TEST_EMAIL)
            .phoneNumber("01012341234")
            .memberType("member")
            .build();

        this.member = requestDto.toEntity();

        // when
        when(memberRepository.findByEmail(TEST_EMAIL))
            .thenReturn(Optional.of(this.member));

        // then
        Throwable exception = assertThrows(ValidCustomException.class,
                                           () -> memberService.save(requestDto));

        assertThat(exception.getClass()).isEqualTo(ValidCustomException.class);
    }
}
