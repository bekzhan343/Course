package com.example.collegemanager.constants;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ApiMessage {
    COURSE_INFO_BY_IF("log{DONE SUCCESSFULLY ID -> {}}"),
    CURRENT_METHOD_NAME("log{CURRENT METHOD -> {}}");
    private final String value;

}
