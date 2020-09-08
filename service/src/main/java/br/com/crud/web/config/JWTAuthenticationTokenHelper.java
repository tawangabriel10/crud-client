package br.com.crud.web.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

class JWTAuthenticationTokenHelper {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    private static final long EXPIRATION_TIME = (1000 * 60 * 60 * 4); //4 horas
    private static final String SECRET = "lsiddHJDsddudklqauoNmHJ";
    private static final String TOKEN_PREFIX = "Bearer";

    String createToken(JwtUserDto jwtUser) {

        Claims claims = Jwts.claims().setSubject(jwtUser.getUsername());
        claims.put("roles", jwtUser.getCommaSeparatedAuthorities());

        String JWT = Jwts.builder()
                .setClaims(claims)
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS512, SECRET)
                .compact();
        log.debug("addJWTOnResponseHeader() token {} ", JWT);
        return JWT;
    }

    JwtUserDto getSubject(String token) {
        Claims body = Jwts.parser()
                .setSigningKey(SECRET)
                .parseClaimsJws(token.replace(TOKEN_PREFIX, ""))
                .getBody();

        JwtUserDto jwtUser = new JwtUserDto(body.getSubject(), (String) body.get("roles"));
        log.debug("Parsed token username: {}", jwtUser.getUsername());
        log.debug("Parsed token roles: {}", jwtUser.getCommaSeparatedAuthorities());
        return jwtUser;
    }
}