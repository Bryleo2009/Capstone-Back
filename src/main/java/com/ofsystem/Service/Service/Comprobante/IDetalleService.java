package com.ofsystem.Service.Service.Comprobante;

import com.ofsystem.Model.Comprobante.Detalle;
import com.ofsystem.Service.Service.ICRUDService;

public interface IDetalleService extends ICRUDService<Detalle, Integer> {
    int idDetalle();
}
