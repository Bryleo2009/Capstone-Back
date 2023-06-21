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
    public ResponseEntity<Resource> getEmpleadoFile(@PathVariable String folder,@PathVariable String filename) {
        Resource file = service.loadAsResource(filename, folder);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
                .body(file);
    }

}
