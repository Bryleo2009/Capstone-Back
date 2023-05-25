package com.ofsystem.Service.Service.Comprobante;

import com.ofsystem.Model.Comprobante.Detalle;
import com.ofsystem.Service.Service.ICRUDService;

import java.util.List;

public interface IDetalleService extends ICRUDService<Detalle, Integer> {
    int idDetalle();
    List<Detalle> findByIdComp_Iuc (String iuc);
}
