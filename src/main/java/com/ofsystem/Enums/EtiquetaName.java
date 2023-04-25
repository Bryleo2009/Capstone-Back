package com.ofsystem.Enums;

public enum EtiquetaName {
    ETAPA_ANIO("Verano"),
    MANGA_LARGA("Manga larga"),
    COLOR_AZUL("#123");

    private final Object value;

    private EtiquetaName() {
        this.value = null;
    }

    private EtiquetaName(Object value) {
        this.value = value;
    }

    public Object getValue() {
        return this.value;
    }
}
