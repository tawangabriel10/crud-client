package br.com.crud.web.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;

public class JWTLoginFilter extends AbstractAuthenticationProcessingFilter {

    private final Logger LOG = LoggerFactory.getLogger(this.getClass());

    private ObjectMapper mapper = new ObjectMapper();
    private JWTAuthenticationTokenHelper jwtTokenHelper = new JWTAuthenticationTokenHelper();
    private static final String TOKEN_PREFIX = "Bearer";
    private static final String HEADER_STRING = "Authorization";

    public JWTLoginFilter(String url, AuthenticationManager authManager) {
        super(new AntPathRequestMatcher(url));
        setAuthenticationManager(authManager);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest req,
                                                HttpServletResponse res) throws AuthenticationException, IOException, ServletException {

        try {
            LOG.debug("attemptAuthentication()");
            AccountCredentials credentials = obtainAccountCredentials(req);
            UsernamePasswordAuthenticationToken userCredentials;
            userCredentials = new UsernamePasswordAuthenticationToken(credentials.getUsername(), credentials.getPassword(), Collections.emptyList());

            Authentication authentication = getAuthenticationManager().authenticate(userCredentials);
            UserDetails details = (UserDetails) authentication.getPrincipal();
            return authentication;
        } catch (DisabledException e) {
            LOG.debug("DisabledException: ", e.getMessage());
            handleUsuarioDesabilitado(res);
        } catch (AuthenticationException e) {
            LOG.debug("BadCredentialsException: ", e.getMessage());
            handleBadCredentials(res, e);
        } catch (Exception e) {
            LOG.debug("Error attemptAuthentication(): ", e);
            handleBadRequest(res);
        }
        return null;
    }

    private AccountCredentials obtainAccountCredentials(HttpServletRequest req) throws IOException {
        AccountCredentials credentials = mapper.readValue(req.getInputStream(), AccountCredentials.class);
        LOG.debug("Username {} ", credentials.getUsername());
        return credentials;
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest req,
                                            HttpServletResponse res,
                                            FilterChain chain,
                                            Authentication auth) throws IOException, ServletException {

        LOG.debug("Authenticating user {} ", auth.getName());
        for (GrantedAuthority authority : auth.getAuthorities())
            LOG.debug("authority = {}", authority.getAuthority());

        JwtUserDto jwtUserDto = new JwtUserDto(auth.getName(), auth.getAuthorities());
        String JWTToken = jwtTokenHelper.createToken(jwtUserDto);
        res.addHeader(HEADER_STRING, TOKEN_PREFIX + " " + JWTToken);
        res.addHeader("Access-Control-Expose-Headers", HEADER_STRING);
        res.setContentType("application/json");
    }

    private void handleBadRequest(HttpServletResponse res) throws IOException {
        res.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        res.setContentType("application/json");
        SimpleMessage message = new SimpleMessage("login.invalidrequest", "Invalid request");
        String json = mapper.writeValueAsString(message);
        res.getWriter().write(json);
        res.getWriter().flush();
        res.getWriter().close();
    }

    private void handleBadCredentials(HttpServletResponse res, Exception e) throws IOException {
        res.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        res.setContentType("application/json");
        SimpleMessage message;

        if (e != null && "login.senha.desabilitada".equals(e.getMessage())) {

            message = new SimpleMessage("login.senha.desabilitada", "");
        } else if (e != null && e.getMessage().length() == 36) {

            message = new SimpleMessage(e.getMessage(), "");
        } else {

            message = new SimpleMessage("login.badcredentials", "Usuario ou senha invalidos");
        }

        String json = mapper.writeValueAsString(message);
        res.getWriter().write(json);
        res.getWriter().flush();
        res.getWriter().close();
    }

    private void handleUsuarioDesabilitado(HttpServletResponse res) throws IOException {
        LOG.debug("usuario desabilitado");
        res.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        res.setContentType("application/json");
        SimpleMessage message = new SimpleMessage("login.desabilitado", "Seu usuário está desabilitado.");
        String json = mapper.writeValueAsString(message);
        res.getWriter().write(json);
        res.getWriter().flush();
        res.getWriter().close();
    }

}