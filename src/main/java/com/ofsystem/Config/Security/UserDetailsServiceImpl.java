package com.ofsystem.Config.Security;

import com.ofsystem.Model.Enums.Rol;
import com.ofsystem.Model.Usuario.Usuario;
import com.ofsystem.Service.Imple.Enums.RolServiceImpl;
import com.ofsystem.Service.Imple.Usuario.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Autowired
    private UsuarioServiceImpl service;

    @Autowired
    private RolServiceImpl serviceRol;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if ("admin".equals(username)) {
            // Este es el usuario por defecto
            List<GrantedAuthority> authorities = new ArrayList<>();

            //serviceRol.findByNombreItem("ROLE_SOPORTE");
            authorities.add(new SimpleGrantedAuthority("ROLE_SOPORTE"));
            return new User("admin", passwordEncoder.encode("admin123"), authorities);
        }
        Usuario usuario = service.findByUsername(username);

        if (usuario == null) {
            throw new UsernameNotFoundException("Usuario no encontrado con nombre de usuario: " + username);
        }

        if (!usuario.isEstadoUser()) {
            throw new DisabledException("La cuenta del usuario no está activa");
        }

        Set<GrantedAuthority> roles = new HashSet<>();
        Rol rol = usuario.getIdRol();
        roles.add(new SimpleGrantedAuthority(rol.getIdentItem().toString())); // Utiliza el identificador del rol como nombre
        return new org.springframework.security.core.userdetails.User(usuario.getUsername(), usuario.getPassword(), roles);
    }

}
