package com.dagacube.enums;

import lombok.Getter;

@Getter
public enum Operation {

    ADD("win"),
    SUBTRACT("bet");

    private final String value;

    Operation(String value) {
        this.value = value;
    }

    public static Operation fromValue(String value){
        for(Operation f: Operation.values()){
            if(f.value.equalsIgnoreCase(value)){
                return f;
            }
        }
        return null;
    }
}
