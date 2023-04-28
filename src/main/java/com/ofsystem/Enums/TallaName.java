package com.ofsystem.Enums;

public enum TallaName {
    LARGE("Large","L","L"),
    SMALL("Small","S","S");

    private final Object value;
    private final String abreviatura;
    private final String vista;

    private TallaName(Object value, String abreviatura, String vista) {
        this.value = value;
        this.abreviatura = abreviatura;
        this.vista = vista;
    }

    public String getValue() {
        return this.value.toString();
    }

    public String getAbreviatura() {
        return this.abreviatura;
    }

    public String getVista() {
        return this.vista;
    }
}
