package com.ofsystem.Model.Enums.Name;

public enum TipoComproName {

    BOLETA("BOLETA ELECTRONICA","B","Boleta electronica"),
    FACTURA("FACTURA ELECTRONICA","F","Factura electronica");

    private final Object value;
    private final String abreviatura;
    private final String vista;

    private TipoComproName(Object value, String abreviatura, String vista) {
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
