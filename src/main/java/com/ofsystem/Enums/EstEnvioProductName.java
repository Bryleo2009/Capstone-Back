package com.ofsystem.Enums;

public enum EstEnvioProductName {

    ESPERA_ENVIO ( "ESPERA", "ESP", "Espera de envio"),
    PROCESO_ENVIO ( "PROCESO", "PROC", "Proceso de envio"),
    TRANSITO_PAQUETE ( "TRANSITO", "TRN", "Paquete en transito"),
    ENTREGA_PAQUETE ( "ENTREGADO", "ENT", "Paquete entregado"),
    RETENCION_PAQUETE ( "RETENIDO", "RTN", "Paquete retenido"),
    DEVOLUCION_PAQUETE ( "DEVUELTO", "DVL", "Paquete devuelto"),
    CANCELACION_PAQUETE ( "CANCELADO", "CLD", "Paquete cancelado" );

    private final Object value;
    private final String abreviatura;
    private final String vista;

    private EstEnvioProductName(Object value, String abreviatura, String vista) {
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
