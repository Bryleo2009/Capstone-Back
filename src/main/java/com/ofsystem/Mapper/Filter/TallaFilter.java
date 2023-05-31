package com.ofsystem.Mapper.Filter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TallaFilter {
    int id_talla;
    String abrevi_item;
    String ident_item;
    String nombre_item;
    String vista_item;

    public int getId_talla() {
        return id_talla;
    }

    public void setId_talla(int id_talla) {
        this.id_talla = id_talla;
    }

    public String getAbrevi_item() {
        return abrevi_item;
    }

    public void setAbrevi_item(String abrevi_item) {
        this.abrevi_item = abrevi_item;
    }

    public String getIdent_item() {
        return ident_item;
    }

    public void setIdent_item(String ident_item) {
        this.ident_item = ident_item;
    }

    public String getNombre_item() {
        return nombre_item;
    }

    public void setNombre_item(String nombre_item) {
        this.nombre_item = nombre_item;
    }

    public String getVista_item() {
        return vista_item;
    }

    public void setVista_item(String vista_item) {
        this.vista_item = vista_item;
    }
}
