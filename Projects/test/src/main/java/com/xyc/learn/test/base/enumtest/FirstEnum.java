package com.xyc.learn.test.base.enumtest;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum FirstEnum {

    FIRST("diyi");

    private String privateValue;

    FirstEnum(String privateValue) {
        this.privateValue = privateValue;
    }

    public String getPrivateValue() {
        return privateValue;
    }

    public void setPrivateValue(String privateValue) {
        this.privateValue = privateValue;
    }


    @JsonCreator
    public static FirstEnum forValue(String name) {
        for (FirstEnum fe : FirstEnum.values()) {
            if (fe.getPrivateValue().equals(name)) {
                return fe;
            }
        }
        return null;
    }

    @JsonValue
    public String getValue(){
        return this.getPrivateValue();
    }

}
