package br.com.crud.web.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
public class JSONAccessDeniedHandler implements AccessDeniedHandler {

    private ObjectMapper mapper = new ObjectMapper();

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException e) throws IOException, ServletException {
        Map<String, String> map = new HashMap<>();
        map.put("code", "login.access.denied");
        map.put("erro", "Acess denied");
        map.put("requestedUrl", request.getRequestURI());
        String json = mapper.writeValueAsString(map);
        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        response.getWriter().write(json);
        response.getWriter().flush();
        response.getWriter().close();
    }


}