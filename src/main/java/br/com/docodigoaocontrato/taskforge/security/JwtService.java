package br.com.docodigoaocontrato.taskforge.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;

@Service
public class JwtService {

    private final String segredo;
    private final Long expiracao;
    private final SecretKey chave;

    public JwtService(
            @Value("${JWT_SECRET:do-codigo-ao-contrato-secret-32chars}") String segredo,
            @Value("${jwt.expiracao:3600000}") Long expiracao) {
        this.segredo = segredo;
        this.expiracao = expiracao;
        this.chave = Keys.hmacShaKeyFor(segredo.getBytes(StandardCharsets.UTF_8));
    }

    public String gerarToken(String email, String nome) {
        return Jwts.builder()
                .subject(email)
                .claim("nome", nome)
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + expiracao))
                .signWith(chave)
                .compact();
    }

    public String getEmailFromToken(String token) {
        return Jwts.parser()
                .verifyWith(chave)
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .getSubject();
    }

    public String extrairEmail(String token) {
        return getEmailFromToken(token);
    }

    public boolean tokenValido(String token) {
        try {
            Jwts.parser()
                    .verifyWith(chave)
                    .build()
                    .parseSignedClaims(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}