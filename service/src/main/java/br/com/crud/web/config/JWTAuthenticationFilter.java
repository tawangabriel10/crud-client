package br.com.crud.web.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.ExpiredJwtException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class JWTAuthenticationFilter extends GenericFilterBean {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    private ObjectMapper mapper = new ObjectMapper();
    private JWTAuthenticationTokenHelper jwtTokenHelper = new JWTAuthenticationTokenHelper();
    private static final String HEADER_STRING = "Authorization";

    @Override
    public void doFilter(ServletRequest request,
                         ServletResponse response,
                         FilterChain filterChain) throws IOException, ServletException {
        try {
            Authentication authentication;
            authentication = getAuthentication((HttpServletRequest) request);

            SecurityContextHolder.getContext().setAuthentication(authentication);
            filterChain.doFilter(request, response);
        } catch (ExpiredJwtException e) {
            expiredTokenResponse((HttpServletResponse) response);
        }
    }

    private Authentication getAuthentication(HttpServletRequest request) {

        log.debug("getAuthentication()");
        String token = request.getHeader(HEADER_STRING);
        if (token == null) {
            log.debug("No JWT on request header");
            return null;
        }

        JwtUserDto jwtUser = jwtTokenHelper.getSubject(token);
        if (jwtUser == null)
            return null;

        log.debug("Subject on request header {} ", jwtUser);
        return new UsernamePasswordAuthenticationToken(jwtUser.getUsername(), null, jwtUser.getAuthorities());
    }

    private void expiredTokenResponse(HttpServletResponse res) throws IOException {
        log.debug("Token expired");
        res.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        res.setContentType("application/json");

        Map<String, String> map = new HashMap<>();
        map.put("code", "token.expired");
        map.put("erro", "Token expired");
        String json = mapper.writeValueAsString(map);

        res.getWriter().write(json);
        res.getWriter().flush();
        res.getWriter().close();
    }

}