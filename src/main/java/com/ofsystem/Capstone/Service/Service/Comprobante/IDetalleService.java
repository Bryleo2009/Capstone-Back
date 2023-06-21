package com.ofsystem.Capstone.Service.Service.Comprobante;

import com.ofsystem.Capstone.Model.Comprobante.Detalle;
import com.ofsystem.Capstone.Service.Service.ICRUDService;

import java.util.List;

public interface IDetalleService extends ICRUDService<Detalle, Integer> {
    int idDetalle();
    List<Detalle> findByIdComp_Iuc (String iuc);
}
