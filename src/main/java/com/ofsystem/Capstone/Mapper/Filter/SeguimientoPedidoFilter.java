package com.ofsystem.Capstone.Mapper.Filter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SeguimientoPedidoFilter {
            public int id_pedido;
            public String celular_recojo_pedido;
            public String correo_recojo_pedido;
            public String direccion_recojo_pedido;
            public String nombre_recojo_pedido;
            public String id_comp;
            List<TrazabilidadPedidoFilter> trazabilidad;

}
