package com.ofsystem.Model.Comprobante;

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

    public String exportReport(String reportFormat) throws FileNotFoundException, JRException {
        String path = "C:\\Users\\Adrian Rondan\\Desktop\\Report";
        List<Comprobante> comprobantes = service.listar();
        // cargar datos
        File file = ResourceUtils.getFile("classpath:comprobante.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(comprobantes);
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("CreatedBy", "JULIAN SAC");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);

        if(reportFormat.equalsIgnoreCase("html")){
            JasperExportManager.exportReportToHtmlFile(jasperPrint,path+"\\comprobante.html");
        }
        if (reportFormat.equalsIgnoreCase("pdf")){
            JasperExportManager.exportReportToPdfFile(jasperPrint,path+"\\comprobante.pdf");
        }

        return "report generated in path: " + path ;
    }
}
