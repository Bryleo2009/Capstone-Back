package com.ofsystem.Enums;

public enum EstComproName {

    EMITIDO ( "EMITIDO", "EMT", "Comprobante emitido"),
    PAGADO ( "PAGADO", "PGD", "Comprobante pagado"),
    ANULADO ( "ANULADO", "ANL", "Comprobante anulado");

    private final Object value;
    private final String abreviatura;
    private final String vista;

    private EstComproName(Object value, String abreviatura, String vista) {
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
