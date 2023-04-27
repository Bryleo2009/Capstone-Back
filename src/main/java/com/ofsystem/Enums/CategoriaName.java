package com.ofsystem.Enums;

public enum CategoriaName {
    CABALLERO("CABALLERO","CAB"),
    DAMA("DAMA","DAM"),
    NIÑOS("NIÑOS","NIÑ"),
    ACCESORIO("ACCESORIO","ACC");

    private final Object value;
    private final String abreviatura;

    private CategoriaName(Object value, String abreviatura) {
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
