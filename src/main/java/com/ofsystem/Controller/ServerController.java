package com.ofsystem.Controller;

import com.ofsystem.Config.Exception.ModeloNotFoundException;
import com.ofsystem.Model.Rol;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/server")
public class ServerController {
    @GetMapping()
    public ResponseEntity<?> server() {
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
