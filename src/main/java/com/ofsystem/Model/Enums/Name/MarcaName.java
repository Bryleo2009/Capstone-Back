package com.ofsystem.Model.Enums.Name;

public enum MarcaName {

    ETIQ_NIKE("NIKE","NK","Nike"),
    ETIQ_ADIDAS("ADIDAS","ADD","Adidas"),
    ETIQ_SYBILLA("SYBILLA","SYB","Sybilla"),
    ETIQ_MINNIE("MINNIE","MNN","Minnie"),
    ETIQ_CREPIER("CREPIER","CRP","Crepier"),
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
