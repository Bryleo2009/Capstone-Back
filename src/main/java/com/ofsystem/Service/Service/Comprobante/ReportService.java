package com.ofsystem.Service.Service.Comprobante;

import com.ofsystem.Model.Comprobante.Comprobante;
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

//    public String exportReport(String reportFormat) throws FileNotFoundException, JRException {
//        List<Comprobante> comprobantes = service.findAll();
//        // cargar datos
//        File file = ResourceUtils.getFile("classpath:comprobante.jrxml");
//        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
//        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(comprobantes);
//        Map<String, Object> parameters = new HashMap<>();
//        parameters.put("CreatedBy", "JULIAN SAC");
//        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
//
//        if(reportFormat.equalsIgnoreCase("html")){
//            JasperExportManager.exportReportToHtmlFile(jasperPrint,"C:\\Users\\Adrian\\Desktop\\Report"+"\\comprobante.html");
//        }
//        if (reportFormat.equalsIgnoreCase("pdf")){
//
//        }
//
//        return "";
//    }
}
