package com.ofsystem.Enums;

public enum EtiquetaName {
    ESTACION_VERANO("", "ESTVER","Ropa de verano"),
    ESTACION_PRIMAVERA("", "ESTPRIM","Ropa de primavera"),
    TIPO_MANGA_LARGA("", "MANLAR", "Manga larga"),
    TIPO_MANGA_CORTA("", "MANCOR", "Manga corta"),
    MAT_ALGODON("", "ALG", "Algodón"),
    COLOR_AZUL("#013076", "CBLUE", "Azul"),
    COLOR_ROJO("#C30100", "CRED", "Rojo"),
    COLOR_NEGRO("#202124", "CBLACK", "Negro"),
    COLOR_BLANCO("#EFEFF2", "CWHITE", "Blanco"),
    COLOR_MARRON("#654030", "CBROWN", "Marrón"),
    COLOR_HUESO("#f6f5e2", "CBONE", "Hueso"),
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

