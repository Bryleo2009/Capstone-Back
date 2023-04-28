package com.ofsystem.Enums;

public enum TallaName {
    EXTRA_SMALL("EXTRA_SMALL","XS","XS"),
    SMALL("SMALL","S","S"),
    MEDIUM("MEDIUM","M","M"),
    LARGE("LARGE","L","L"),
    EXTRA_LARGE("EXTRA_LARGE","XL","XL"),
    DOUBLE_EXTRA_LARGE("DOUBLE_EXTRA_LARGE","XXL","XXL");


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
