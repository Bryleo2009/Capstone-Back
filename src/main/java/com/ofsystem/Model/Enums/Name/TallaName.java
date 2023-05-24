package com.ofsystem.Model.Enums.Name;

public enum TallaName {
    EXTRA_SMALL("EXTRA_SMALL","XS","XS"),
    SMALL("SMALL","S","S"),
    MEDIUM("MEDIUM","M","M"),
    LARGE("LARGE","L","L"),
    EXTRA_LARGE("EXTRA_LARGE","XL","XL"),
    DOUBLE_EXTRA_LARGE("DOUBLE_EXTRA_LARGE","XXL","XXL"),
    NUM_2("2","N2","2"),
    NUM_3("3","N3","3"),
    NUM_4("4","N4","4"),
    NUM_6("6","N6","6"),
    NUM_8("8","N8","8"),
    NUM_10("10","N10","10"),
    NUM_12("12","N12","12"),
    NUM_14("14","N14","14"),
    NUM_16("16","N16","16"),
    NUM_26("26","N26","26"),
    NUM_28("28","N28","28"),
    NUM_30("30","N30","30"),
    NUM_32("32","N32","32"),
    NUM_34("34","N34","34"),
    NUM_36("36","N36","36"),
    NUM_38("38","N38","38"),
    NUM_38M("38.5","N38M","38.5"),
    NUM_39("39","N39","39"),
    NUM_39M("39.5","N39M","39.5"),
    NUM_40("40","N40","40"),
    NUM_40M("40.5","N40M","40.5"),
    NUM_41("41","N41","41"),
    UNICA("UNICA","UNI","Talla unica");


    private final Object value;
    private final String abreviatura;
    private final String vista;

    private TallaName(Object value, String abreviatura, String vista) {
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