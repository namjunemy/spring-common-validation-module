package io.namjune.commonvalidation.dto;

import io.namjune.commonvalidation.domain.Member;
import io.namjune.commonvalidation.valid.MemberType;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
@NoArgsConstructor
public class MemberRequestDto {

    @NotBlank(message = "이름을 작성해주세요.")
    private String name;

    @NotBlank(message = "전화번호를 작성해주세요.")
    @Pattern(regexp = "[0-9]{10,11}", message = "10 ~ 11자리의 숫자만 입력 가능합니다.")
    private String phoneNumber;

    @NotBlank(message = "메일을 작성해주세요.")
    @Email(message = "메일의 양식을 지켜주세요.")
    private String email;

    @MemberType
    private String memberType;

    @Builder
    public MemberRequestDto(String name, String phoneNumber, String email, String memberType) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.memberType = memberType;
    }

    public Member toEntity() {
        String[] phones = parsePhone();
        return Member.builder()
                .name(name)
                .phone1(phones[0])
                .phone2(phones[1])
                .phone3(phones[2])
                .email(email)
                .memberType(io.namjune.commonvalidation.enums.MemberType.get(memberType))
                .build();
    }

    private String[] parsePhone() {
        String[] phones = new String[3];
        int mid = phoneNumber.length() == 10 ? 7 : 8;
        phones[0] = phoneNumber.substring(0, 3);
        phones[1] = phoneNumber.substring(3, mid - 1);
        phones[2] = phoneNumber.substring(mid - 1);
        return phones;
    }
}
