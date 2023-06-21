package com.ofsystem.Capstone.Config.JWT;

import com.ofsystem.Capstone.Config.Exception.ModeloNotFoundException;
import com.ofsystem.Capstone.Config.Security.UserDetailsServiceImpl;
import io.jsonwebtoken.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Component
@Slf4j
public class JwtUtils {

    private final String secret = "ofSystem";

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    public String generateToken(String username, String password) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        String encodedPassword = new BCryptPasswordEncoder().encode(password);
        Map<String, Object> claims = new HashMap<>();
        claims.put("password", encodedPassword);
        return createToken(claims, userDetails.getUsername());
    }

    public String generateToken(UserDetails userDetails) {
        long expirationTime = 1000 * 60 * 60 * 3; // 3 hours
        //long expirationTime = 1000 * 60 * 1; // 1 minute
        Date now = new Date();
        Date expirationDate = new Date(now.getTime() + expirationTime);
        return Jwts.builder()
                .setSubject(userDetails.getUsername())
                .setExpiration(expirationDate)
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

    private String createToken(Map<String, Object> claims, String subject) {
        long expirationTime = 1000 * 60 * 60 * 2; // 2 hours
        //long expirationTime = 1000 * 60 * 1; // 1 minute
        Date now = new Date();
        Date expirationDate = new Date(now.getTime() + expirationTime);

        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(now)
                .setExpiration(expirationDate)
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

    public boolean validateToken(String token, UserDetails userDetails) {
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    private boolean isTokenExpired(String token) {
        final Date expiration = extractExpiration(token);
        return expiration.before(new Date());
    }

    String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    String extractPassword(String token) {
        return (String) extractAllClaims(token).get("password");
    }

    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    private <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    public Claims extractAllClaims(String token) {
        try {
            return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
        } catch (ExpiredJwtException e) {
            log.error("El token de autenticación ha expirado");
            throw new ModeloNotFoundException("El token de autenticación ha expirado");
        } catch (MalformedJwtException e) {
            log.error("El token de autenticación es inválido");
            throw new ModeloNotFoundException("El token de autenticación es inválido");
        } catch (SignatureException e) {
            log.error("El token de autenticación es inválido");
            throw new ModeloNotFoundException("El token de autenticación es inválido");
        }
    }


    public boolean validate(String token) {
        try {
            Claims claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
            return true;
        } catch (SignatureException e) {
            return false;
        }
    }
}

