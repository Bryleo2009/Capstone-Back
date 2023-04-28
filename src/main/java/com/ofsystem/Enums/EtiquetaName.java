package com.ofsystem.Enums;

public enum EtiquetaName {
    ESTACION_VERANO("", "ESTVER","Ropa de verano"),
    MANGA_LARGA("", "MANLAR", "Manga larga"),
    COLOR_AZUL("#123", "CBLUE", "Azul");

    private final Object value;
    private final String abreviatura;
    private final String vista;

    private EtiquetaName(Object value, String abreviatura, String vista) {
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

