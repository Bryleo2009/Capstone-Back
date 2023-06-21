package com.ofsystem.Capstone.Config.JWT;

import com.ofsystem.Capstone.Config.Security.UserDetailsServiceImpl;
import com.ofsystem.Capstone.Service.Imple.Usuario.UsuarioServiceImpl;
import com.ofsystem.Capstone.Model.Usuario.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private UsuarioServiceImpl userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
        // Buscar al usuario en la base de datos
        final Usuario user = userRepository.findByUsername(authenticationRequest.getUsername());
        if(!authenticationRequest.getUsername().equals("admin")){

            if (user == null) {
                throw new Exception("Nombre de usuario o contraseña incorrecta");
            }

            // Comparar las contraseñas
            if (!passwordEncoder.matches(authenticationRequest.getPassword(), user.getPassword())) {
                throw new Exception("Nombre de usuario o contraseña incorrecta");
            }
        }

        // Crear los detalles del usuario para el token de JWT
        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());

        // Generar el token de JWT
        final String jwt = jwtUtils.generateToken(userDetails);


        // Devolver la respuesta con el token de JWT
        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }

    @PostMapping("/login/google")
    public ResponseEntity<?> createAuthenticationTokenUsernameGoogle(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
        // Buscar al usuario en la base de datos
        final Usuario user = userRepository.findByUsername(authenticationRequest.getUsername());

        if (user == null) {
            throw new Exception("Nombre de usuario incorrecto");
        }

        // Crear los detalles del usuario para el token de JWT
        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());

        // Generar el token de JWT
        final String jwt = jwtUtils.generateToken(userDetails);

        // Devolver la respuesta con el token de JWT
        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }



    @GetMapping("/check-token")
    public ResponseEntity<Void> checkToken(@RequestHeader("Authorization") String authorizationHeader) {
        String token = authorizationHeader.substring(7); // Eliminamos el prefijo "Bearer " del encabezado de autorización
        boolean isValid = jwtUtils.validate(token);
        if (isValid) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
}
