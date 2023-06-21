package com.ofsystem.Service.Service.Comprobante;

import com.ofsystem.Mapper.Filter.ComprobanteDFilter;
import com.ofsystem.Model.Comprobante.Comprobante;
import com.ofsystem.Service.Service.ICRUDService;

import java.util.List;

public interface IComprobanteService extends ICRUDService<Comprobante, String> {
    String findLastIdComp();
    Comprobante findByIuc(String iuc);

    List<ComprobanteDFilter> ListarComprobanteXID(String idComp);
}
