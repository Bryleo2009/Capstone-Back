package com.ofsystem.Config.Media;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.springframework.security.web.header.HeaderWriter;
import org.springframework.security.web.header.HeaderWriterFilter;
import org.springframework.security.web.header.writers.StaticHeadersWriter;
import org.springframework.security.web.header.writers.frameoptions.XFrameOptionsHeaderWriter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@RestController
@RequestMapping("/media")
@AllArgsConstructor
public class MediaController {
    @Bean
    public HeaderWriterFilter frameOptionsHeaderWriterFilter() {
        XFrameOptionsHeaderWriter headerWriter = new XFrameOptionsHeaderWriter(XFrameOptionsHeaderWriter.XFrameOptionsMode.SAMEORIGIN);
        return new HeaderWriterFilter(Collections.singletonList(headerWriter));
    }


    private final MediaServiceImpl service;

    @GetMapping("/{folder}/{filename:.+}")
    public ResponseEntity<byte[]> getEmpleadoFile(@PathVariable String folder, @PathVariable String filename) throws IOException {
        Resource file = service.loadAsResource(filename, folder);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=" + file.getFilename());

        byte[] fileBytes = Files.readAllBytes(file.getFile().toPath());

        return new ResponseEntity<>(fileBytes, headers, HttpStatus.OK);
    }


}
