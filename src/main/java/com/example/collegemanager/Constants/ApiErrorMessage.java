package com.example.collegemanager.Constants;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ApiErrorMessage {
    ERROR_MESSAGE_BY_ID("NOT FOUND ID -> %s!");

    private final String message;

    public String getMessage(Object... args) {
        return String.format(message, args);
    }
}
