package com.ofsystem.Enums;

public enum EtiquetaName {
    ESTACION_VERANO("", "ESTVER","Ropa de verano"),
    MANGA_LARGA("", "MANLAR", "Manga larga"),
    COLOR_AZUL("#013076", "CBLUE", "Azul"),
    COLOR_ROJO("#C30100", "CRED", "Rojo"),
    COLOR_NEGRO("#202124", "CBLACK", "Negro"),
    COLOR_BLANCO("#EFEFF2", "CWHITE", "Blanco"),
    COLOR_MARRON("#654030", "CBROWN", "Marrón"),
    COLOR_VERDE("#019679", "CGREEN", "Verde");

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

