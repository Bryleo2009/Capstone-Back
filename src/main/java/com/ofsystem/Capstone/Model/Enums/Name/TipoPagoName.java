package com.ofsystem.Capstone.Model.Enums.Name;

public enum TipoPagoName {

    VIRTUAL("","V","Pago virtual"),
    PRESENCIAL("","P","Pago presencial");

    private final Object value;
    private final String abreviatura;
    private final String vista;

    private TipoPagoName(Object value, String abreviatura, String vista) {
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
