package com.ofsystem.Config.Media;

import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class MediaServiceImpl {

    @Value("${media.location}")
    private String mediaLocation;

    public Path rootLocation;


    @PostConstruct
    public void init() throws IOException {
        rootLocation = Paths.get(mediaLocation);
        Path productosQr = rootLocation.resolve("productosQr");
        Files.createDirectories(productosQr);
    }

    /*public String store(MultipartFile file, String subruta ) {
        try {
            if(file.isEmpty()){
                throw new RuntimeException("Error de subida de archivo");
            }
            String filename = file.getOriginalFilename();
            Path destinationFile = rootLocation.resolve(Paths.get(subruta +'/'+ file.getOriginalFilename()))
                    .normalize().toAbsolutePath();
            try (InputStream inputStream = file.getInputStream()) {
                Files.copy(inputStream,destinationFile, StandardCopyOption.REPLACE_EXISTING);
            }
            return filename;
        }
         catch (IOException ex) {
            throw new RuntimeException("Error de archivo: ", ex);
        }

    }*/

    public Resource loadAsResource(String filename, String folder) {
        try {
            Path file = rootLocation.resolve(folder).resolve(filename);
            Resource resource = new UrlResource((file.toUri()));
            if(resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                throw new RuntimeException("Error de lectura de documento: " + filename);
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException("Error de lectura de documento: " + filename);
        }
    }

/*
    public void delete(String filename, String folder) {
        try {
            Path file = rootLocation.resolve(folder).resolve(filename);
            if (Files.exists(file)) {
                Files.delete(file);
            }
        } catch (IOException e) {
            throw new RuntimeException("Error al eliminar el archivo: " + filename);
        }
    }

    public void rename(String filename, String newFilename, String folder) {
        try {
            Path file = rootLocation.resolve(folder).resolve(filename);
            Path newFile = rootLocation.resolve(folder).resolve(newFilename);
            Files.move(file, newFile, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            throw new RuntimeException("Error al renombrar el archivo: " + filename, e);
        }
    }*/


}
