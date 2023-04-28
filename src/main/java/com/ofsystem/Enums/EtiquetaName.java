package com.ofsystem.Enums;

public enum EtiquetaName {
    ESTACION_VERANO("", "ESTVER","Ropa de verano"),
    ESTACION_PRIMAVERA("", "ESTPRIM","Ropa de primavera"),
    TIPO_MANGA_LARGA("", "MANLAR", "Manga larga"),
    TIPO_MANGA_CORTA("", "MANCOR", "Manga corta"),
    MAT_ALGODON("", "ALG", "Algodón");

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

