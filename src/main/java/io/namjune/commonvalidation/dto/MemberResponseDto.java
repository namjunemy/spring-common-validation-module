package io.namjune.commonvalidation.dto;

import io.namjune.commonvalidation.domain.Member;

public class MemberResponseDto {

    private Long id;
    private String name;
    private String phoneNumber;
    private String email;

    public MemberResponseDto() {
    }

    public MemberResponseDto(Member member) {
        id = member.getId();
        name = member.getName();
        phoneNumber = toStringPhone(member.getPhone1(), member.getPhone2(), member.getPhone3());
        email = member.getEmail();
    }

    private String toStringPhone(String phone1, String phone2, String phone3) {
        return phone1 + "-" + phone2 + "-" + phone3;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }
}