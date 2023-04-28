package com.ofsystem.Enums;

public enum MarcaName {

    ETIQ_NIKE("NIKE","NK","Nike"),
    ETIQ_ADIDAS("ADIDAS","ADD","Adidas"),
    ETIQ_DOOAUSTRA("DOO AUSTRALIA","DOA","Doo Australia"),
    ETIQ_BILLAB("BILLABONG","BB","Billabong");


    private final Object value;
    private final String abreviatura;
    private final String vista;

    private MarcaName(Object value, String abreviatura, String vista) {
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
