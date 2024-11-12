package io.reflectoring.demo.Service;

import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoder;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.Builder;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties;
import org.springframework.stereotype.Service;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class JWTService {
    String secretKey="";
    public JWTService() throws NoSuchAlgorithmException {
        KeyGenerator keyGen=KeyGenerator.getInstance("HmacSHA256");
        SecretKey key= keyGen.generateKey();
        secretKey= Base64.getEncoder().encodeToString(key.getEncoded());
    }

    public String getToken(final String userName){
        Map<String,Object> claims=new HashMap<>();
        return Jwts.builder()
                .claims()
                .add(claims)
                .subject(userName)
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis()+60*60*60*10))
                .and()
                .signWith(getSecretKey())
                .compact();

    }

    private Key getSecretKey() {
        byte[] decodeKey= Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(decodeKey);
    }
}
