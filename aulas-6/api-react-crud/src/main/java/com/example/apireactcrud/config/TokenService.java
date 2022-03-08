package com.example.apireactcrud.config;

import com.example.apireactcrud.model.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TokenService {

    @Value("${produto.jwt.expiration}")
    private Long expiration;

    @Value("${produto.jwt.secret}")
    private String secret;

    public String gerarToken(Authentication authentication){

        User user = (User) authentication.getPrincipal();
        Date hoje = new Date();
        Date expiracao = new Date();
        expiracao.setTime(hoje.getTime()+ expiration);

        return Jwts.builder()
                .setIssuer("API CRUD")
                .setSubject(String.valueOf(user.getId()))
                .setIssuedAt(hoje)
                .setExpiration(expiracao)
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();

    }

    public boolean isTokenValido(String token) {
        try {
            Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Long getIdUsuario(String token) {
        Claims claims = Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token).getBody();
        return Long.parseLong(claims.getSubject());
    }
}
