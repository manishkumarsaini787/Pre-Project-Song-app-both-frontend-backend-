package com.example.SpotifyApplication.filter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SongsFilter extends GenericFilterBean
{

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException
    {
        HttpServletRequest httpServletRequest=(HttpServletRequest)servletRequest;
        HttpServletResponse httpServletResponse=(HttpServletResponse)servletResponse;
        String authHeader= httpServletRequest.getHeader("Authorization");
        if(authHeader==null || !authHeader.startsWith("Bearer"))
        {
            throw  new ServletException("Token is Missing");
        }
        else
        {
            String token=authHeader.substring(7);
            //  eyJhbGciOiJIUzUxMiJ9.eyJVc2VyUm9sZSI6IlVzZXItUm9sZSIsInVzZXJFbWFpbCI6ImZpdmVAZ21haWwu
            // Y29tIiwiaWF0IjoxNjgxMTkxMzA1fQ.yNwcGWP5BlBePVRIAzl36fTlmmNM8NIIk9
            // Esh8Vk4yKp2sIy7CG9co0-Yqh_WUYt4Dnn5gkb1CSebU8c9v3HYA
            Claims claims= Jwts.parser().setSigningKey("secretKeyForWave46").parseClaimsJws(token).getBody();
            System.out.println("Retrived Claims : "+claims);
            httpServletRequest.setAttribute("attr1",claims.get("userEmail"));
        }

        filterChain.doFilter(httpServletRequest,httpServletResponse);
    }
}

