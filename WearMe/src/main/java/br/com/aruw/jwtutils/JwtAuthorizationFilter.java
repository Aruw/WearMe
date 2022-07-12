package br.com.aruw.jwtutils;

import java.util.List;
import io.jsonwebtoken.*;
import java.io.IOException;
import javax.servlet.FilterChain;
import java.util.stream.Collectors;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class JwtAuthorizationFilter extends OncePerRequestFilter {

    private final String PREFIX = "Bearer ";
    private final String HEADER = "Autorization";
    private final String SECRET = "qwertyuiopasdfghjklzxcvbnm123456";

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        try{

            if(checkJWTToken(request, response)){
                Claims claims = validateToken(request);
                System.out.println(claims);
                if(claims != null){
                    setUpSpringAuthentication(claims);
                }else{
                    SecurityContextHolder.clearContext();
                }
            }else{
                SecurityContextHolder.clearContext();
            }
            filterChain.doFilter(request, response);

        }catch (ExpiredJwtException | UnsupportedJwtException | MalformedJwtException e){
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            ((HttpServletResponse) response).sendError(HttpServletResponse.SC_FORBIDDEN, e.getMessage());
            return;
        }
    }

    private Claims validateToken(HttpServletRequest request){
        String jwtToken = request.getHeader(HEADER).replace(PREFIX, "");
        return Jwts.parser().setSigningKey(SECRET).parseClaimsJws(jwtToken).getBody();
    }

    private void setUpSpringAuthentication(Claims claims){
        @SuppressWarnings("unchecked")
        List<String> authorities = (List<String>) claims.get("authorities");

        UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(claims.getSubject(),
                null, authorities.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList()));

        SecurityContextHolder.getContext().setAuthentication(auth);
    }

    private boolean checkJWTToken(HttpServletRequest request, HttpServletResponse res){
        String authenticationHeader = request.getHeader(HEADER);

        if(authenticationHeader == null || !authenticationHeader.startsWith(PREFIX)){
            return true;
        }
        return false;
    }

}