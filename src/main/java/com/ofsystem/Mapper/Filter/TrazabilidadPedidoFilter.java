package com.ofsystem.Mapper.Filter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TrazabilidadPedidoFilter {

    public int id_pedido;
    public String vista_item;
    public Date fecha_ini_proc;
    public Date fecha_fin_proc;

}
