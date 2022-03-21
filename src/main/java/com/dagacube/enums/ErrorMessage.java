package com.dagacube.enums;

import lombok.Getter;

@Getter
public enum ErrorMessage {

    INVALID_OPERATION("Invalid operation"),
    PLAYER_NOT_FOUND("Player not found");

    private final String value;

    ErrorMessage(String value) {
        this.value = value;
    }
}
