package com.ofsystem.Capstone.Model.Enums.Name;

public enum TipoDocName {

    DNI("DOCUMENTO NACIONAL DE IDENTIDAD","DNI","DNI"),
    CE("CARNET DE EXTRANJERÍA","CE","CE");

    private final Object value;
    private final String abreviatura;
    private final String vista;

    private TipoDocName(Object value, String abreviatura, String vista){
        this.value = value;
        this.abreviatura = abreviatura;
        this.vista = vista;
    }
    public String getValue(){return this.value.toString();}

    public String getAbreviatura(){return this.abreviatura;}

    public String getVista(){return this.vista;}

}
