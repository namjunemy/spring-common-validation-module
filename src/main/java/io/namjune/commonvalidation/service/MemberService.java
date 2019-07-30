package io.namjune.commonvalidation.service;


import io.namjune.commonvalidation.dto.MemberRequestDto;
import io.namjune.commonvalidation.dto.MemberResponseDto;
import io.namjune.commonvalidation.exception.ErrorResponse.FieldError;
import io.namjune.commonvalidation.exception.ValidCustomException;
import io.namjune.commonvalidation.repository.MemberRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public Long save(MemberRequestDto memberRequestDto) {
        verifyDuplicateEmail(memberRequestDto.getEmail());
        return memberRepository.save(memberRequestDto.toEntity()).getId();
    }

    @Transactional
    public List<MemberResponseDto> findAll() {
        return memberRepository
            .findAll()
            .stream()
            .map(MemberResponseDto::new)
            .collect(Collectors.toList());
    }

    private void verifyDuplicateEmail(String email) {
        if (memberRepository.findByEmail(email).isPresent()) {
            throw new ValidCustomException(
                new FieldError(this.getClass().getName(), "email", "이미 사용중인 이메일입니다."));
        }
    }
}
