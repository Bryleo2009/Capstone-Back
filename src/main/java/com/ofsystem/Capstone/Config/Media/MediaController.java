package com.ofsystem.Capstone.Config.Media;

import lombok.AllArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/media")
@AllArgsConstructor
public class MediaController {


    private final MediaServiceImpl service;

    @GetMapping("/{folder}/{filename:.+}")
    public ResponseEntity<Resource> getEmpleadoFile(@PathVariable String folder, @PathVariable String filename) {
        Resource file = service.loadAsResource(filename, folder);
        String contentType = determineContentType(filename);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_TYPE, contentType)
                .body(file);
    }

    private String determineContentType(String filename) {
        if (filename.endsWith(".pdf")) {
            return "application/pdf";
        } else if (filename.endsWith(".png")) {
            return "image/png";
        } else {
            // Si el tipo de archivo no es PDF ni PNG, puedes definir un tipo de contenido predeterminado o manejarlo según tus necesidades.
            return "application/octet-stream"; // Tipo de contenido genérico para otros tipos de archivo
        }
    }



}
