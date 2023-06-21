package com.ofsystem.Capstone.Service.Service.Comprobante;

import com.ofsystem.Capstone.Mapper.Filter.ComprobanteDFilter;
import com.ofsystem.Capstone.Model.Comprobante.Comprobante;
import com.ofsystem.Capstone.Service.Service.ICRUDService;

import java.util.List;

public interface IComprobanteService extends ICRUDService<Comprobante, String> {
    String findLastIdComp();
    Comprobante findByIuc(String iuc);

    List<ComprobanteDFilter> ListarComprobanteXID(String idComp);
}
