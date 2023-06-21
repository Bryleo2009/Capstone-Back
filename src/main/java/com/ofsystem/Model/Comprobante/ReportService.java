package com.ofsystem.Model.Comprobante;

import com.ofsystem.Mapper.Filter.ComprobanteDFilter;
import com.ofsystem.Mapper.Filter.ComprobanteFilter;
import com.ofsystem.Model.Comprobante.Comprobante;
import com.ofsystem.Service.Service.Comprobante.IComprobanteService;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReportService {

    @Autowired
    private IComprobanteService service;


    public String exportReport(String reportFormat, String idComp) throws FileNotFoundException, JRException {
        //String userHome = System.getProperty("user.home");
        String path ="mediafiles/comprobantes";
        List<ComprobanteDFilter> comprobantes = service.ListarComprobanteXID(idComp);
        // cargar datos
        File file = ResourceUtils.getFile("classpath:comprobante.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(comprobantes);
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("CreatedBy", "JULIAN SAC");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
        String rutapdf = String.format("comprobante_%s.pdf",idComp);
        String rutahtml = String.format("comprobante_%s.html",idComp);
        if(reportFormat.equalsIgnoreCase("html")){
            JasperExportManager.exportReportToHtmlFile(jasperPrint,path+ File.separator + rutahtml);
        }
        if (reportFormat.equalsIgnoreCase("pdf")){
            JasperExportManager.exportReportToPdfFile(jasperPrint,path+ File.separator + rutapdf);
        }

        return "report generated in path: " + path ;
    }
}
