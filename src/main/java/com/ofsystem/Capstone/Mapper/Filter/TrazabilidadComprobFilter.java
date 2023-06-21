package com.ofsystem.Capstone.Mapper.Filter;

import com.ofsystem.Capstone.Model.Usuario.Cliente;
import com.ofsystem.Capstone.Model.Comprobante.Comprobante;
import com.ofsystem.Capstone.Model.Usuario.Trabajador;
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
