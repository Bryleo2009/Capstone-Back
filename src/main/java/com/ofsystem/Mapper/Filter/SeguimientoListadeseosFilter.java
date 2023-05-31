package com.ofsystem.Mapper.Filter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SeguimientoListadeseosFilter {
            public int id_listadeseo;
            public String celular_recojo_listadeseo;
            public String correo_recojo_listadeseo;
            public String direccion_recojo_listadeseo;
            public String nombre_recojo_listadeseo;
            public String id_comp;

}
