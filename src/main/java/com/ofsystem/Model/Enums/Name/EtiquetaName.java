package com.ofsystem.Model.Enums.Name;

public enum EtiquetaName {
    ESTACION_VERANO("", "ESTVER","Ropa de verano"),
    ESTACION_OTONIO("", "ESTOTO","Ropa de otoño"),
    ESTACION_INVIERNO("", "ESTINV","Ropa de invierno"),
    ESTACION_PRIMAVERA("", "ESTPRIM","Ropa de primavera"),
    TIPO_MANGA_LARGA("", "MANLAR", "Manga larga"),
    TIPO_MANGA_CORTA("", "MANCOR", "Manga corta"),
    MAT_ALGODON("", "ALG", "Algodón"),
    MAT_POLIESTER("", "PLT", "Poliéster");

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

