package com.example.collegemanager.Constants;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ApiMessage {
    COURSE_INFO_BY_IF("DONE SUCCESSFULLY ID: %s");

    private final String message;

    public String getMessage(Object... args) {
        return String.format(message, args);
    }
}
