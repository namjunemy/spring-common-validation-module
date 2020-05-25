package io.namjune.commonvalidation.enums;


import lombok.Getter;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;

@Getter
public enum MemberType {
    MEMBER("member"),
    ADMIN("admin");

    private String title;

    public static final Map<String, MemberType> memberTypeMap = Collections.unmodifiableMap(Arrays
            .stream(values())
            .collect(Collectors.toMap(MemberType::getTitle, v -> v)));


    MemberType(String title) {
        this.title = title;
    }

    public static MemberType get(String title) {
        return memberTypeMap.get(title);
    }

    public static boolean isMemberType(String title) {
        MemberType memberType = get(title);
        return memberType != null;
    }
}
