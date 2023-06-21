package com.ofsystem.Capstone.Model.Enums.Name;

public enum RolName {

    ROLE_ADMIN ( "ROLE_ADMIN", "ADM", "Administrador"),
    ROLE_EMPLEADO ( "ROLE_EMPLEADO", "EMP", "Empleado"),
    ROLE_CLIENTE ( "ROLE_CLIENTE", "CLT", "Cliente"),
    ROLE_SOPORTE ( "ROLE_SOPORTE", "SPT", "Soporte");

    private final Object value;
    private final String abreviatura;
    private final String vista;

    private RolName(Object value, String abreviatura, String vista) {
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
