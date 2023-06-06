package com.ofsystem.Service.Service.Comprobante;

import com.ofsystem.Mapper.Filter.ComprobanteFilter;
import com.ofsystem.Model.Comprobante.Comprobante;
import com.ofsystem.Model.Usuario.Cliente;
import com.ofsystem.Service.Service.ICRUDService;

import java.util.Date;
import java.util.List;

public interface IComprobanteService extends ICRUDService<Comprobante, String> {
    String findLastIdComp();
    Comprobante findByIuc(String iuc);

    List<ComprobanteFilter> ListarComprobanteXID(String idComp);
}
