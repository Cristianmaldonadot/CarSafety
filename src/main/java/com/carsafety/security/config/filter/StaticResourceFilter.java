package com.carsafety.security.config.filter;

import java.io.IOException;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class StaticResourceFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String requestUri = request.getRequestURI();
        if (requestUri.equals("/") || requestUri.equals("/index") || requestUri.startsWith("/js/") || requestUri.startsWith("/imagenes/")) {
            // Permitir acceso a recursos estáticos sin autenticación
            filterChain.doFilter(request, response);
        } else {
            // Continuar con la cadena de filtros
            super.doFilter(request, response, filterChain);
        }
    }
}