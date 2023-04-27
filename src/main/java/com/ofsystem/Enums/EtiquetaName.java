package com.ofsystem.Enums;

public enum EtiquetaName {
    ESTACION_VERANO("Verano", "ESTVER"),
    MANGA_LARGA("Manga larga", "MANLAR"),
    COLOR_AZUL("#123", "CBLUE");

    private final Object value;
    private final String abreviatura;

    private EtiquetaName(Object value, String abreviatura) {
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

