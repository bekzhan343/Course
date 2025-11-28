package com.example.collegemanager.constants;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ApiErrorMessage {
    ERROR_MESSAGE_BY_ID("log{COURSE NOT FOUND BY ID -> %s!}"),
    DATA_ALREADY_EXISTS_INFO("log{DATA ALREADY EXISTS BY NAME -> %s}");
    private final String message;

    public String getMessage(Object... args) {
        return String.format(message, args);
    }
}
