package br.com.crud.web.config;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class JwtUserDto {

    private String username;
    private Collection<? extends GrantedAuthority> authorities;
    private String commaSeparatedAuthorities;

    public JwtUserDto(String username, Collection<? extends GrantedAuthority> authorities) {
        this.username = username;
        this.authorities = authorities;
        commaSeparatedAuthorities = joinAuthorities(authorities);
    }


    public JwtUserDto(String username, String commaSeparatedAuthorities) {
        this.username = username;
        this.commaSeparatedAuthorities = commaSeparatedAuthorities;
        List<GrantedAuthority> authorities = new ArrayList<>();
        String[] roles = commaSeparatedAuthorities.split(",");
        for (String role : roles)
            authorities.add(new SimpleGrantedAuthority(role.trim()));
        this.authorities = authorities;
    }

    public String getUsername() {
        return username;
    }

    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public String getCommaSeparatedAuthorities() {
        return commaSeparatedAuthorities;
    }
    
    private String joinAuthorities(Collection<? extends GrantedAuthority> authorities) {
    	StringBuilder sb = new StringBuilder("");
    	int i = 0;
    	for (GrantedAuthority authority : authorities) {
    		if (i > 0) {
    			sb.append(",");
    		}
    		sb.append(authority);
    		i++;
    	}
    	return sb.toString();
    }

}