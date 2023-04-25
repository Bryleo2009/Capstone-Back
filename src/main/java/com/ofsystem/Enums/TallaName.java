package com.ofsystem.Enums;

public enum TallaName {
    LARGE("L"),
    SMOLL("S");

    private final Object value;

    private TallaName() {
        this.value = null;
    }

    private TallaName(Object value) {
        this.value = value;
    }

    public Object getValue() {
        return this.value;
    }
}
