package com.ofsystem.Model.Enums.Name;

public enum CategoriaName {
    CABALLERO("CABALLERO","CAB","Caballeros"),
    DAMA("DAMA","DAM","Damas"),
    NIÑOS("NIÑOS","NIÑ","Niños y Niñas"),
    ACCESORIO("ACCESORIO","ACC", "Accesorios");

    private final Object value;
    private final String abreviatura;
    private final String vista;

    private CategoriaName(Object value, String abreviatura, String vista) {
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
