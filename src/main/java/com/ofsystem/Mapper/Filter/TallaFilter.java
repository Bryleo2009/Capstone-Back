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
}
