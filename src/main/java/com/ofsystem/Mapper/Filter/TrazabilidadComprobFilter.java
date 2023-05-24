package com.ofsystem.Mapper.Filter;

import com.ofsystem.Model.Usuario.Cliente;
import com.ofsystem.Model.Comprobante.Comprobante;
import com.ofsystem.Model.Usuario.Trabajador;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TrazabilidadComprobFilter {
    public Comprobante idComp;
    public Cliente idCliente;
    public Trabajador idTrabajador;
    public String Observac;


}
