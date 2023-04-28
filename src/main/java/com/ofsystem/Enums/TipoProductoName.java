package com.ofsystem.Enums;

public enum TipoProductoName {
    CAMISA("","CAM","Camisa"),
    CHOMPA("","CHOM","Chompa"),
    PANTALON("","PANT","Pantalon"),
    JEANS("","JEAS","Jeans");

    private final Object value;
    private final String abreviatura;
    private final String vista;

    private TipoProductoName(Object value, String abreviatura, String vista) {
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
