package com.ofsystem.Enums;

public enum TipoProductoName {
    CAMISA("CAMISA","CAM"),
    CHOMPA("CHOMPA","CHOM"),
    PANTALON("PANTALON","PANT"),
    JEANS("JEANS","JEANS");

    private final Object value;
    private final String abreviatura;

    private TipoProductoName(Object value, String abreviatura) {
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
