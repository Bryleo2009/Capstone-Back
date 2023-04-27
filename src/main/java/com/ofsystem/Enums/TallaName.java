package com.ofsystem.Enums;

public enum TallaName {
    LARGE("LARGE","L"),
    SMOLL("SMOLL","S");

    private final Object value;
    private final String abreviatura;

    private TallaName(Object value, String abreviatura) {
        this.value = value;
        this.abreviatura = abreviatura;
    }

    public String getValue() {
        return this.value.toString();
    }
    public String getAbreviatura() {
        return this.abreviatura;
    }
}
