package com.xzymon.maiordomus.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import java.io.IOException;

public class RequestResponseLoggingFilter extends OncePerRequestFilter {

    private static final Logger LOGGER = LoggerFactory.getLogger(RequestResponseLoggingFilter.class);

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        // Wrappowanie request i response, abyśmy mogli go wielokrotnie odczytać
        ContentCachingRequestWrapper wrappedRequest = new ContentCachingRequestWrapper(request);
        ContentCachingResponseWrapper wrappedResponse = new ContentCachingResponseWrapper(response);

        // Przekazanie żądania dalej w łańcuchu filtrowania
        filterChain.doFilter(wrappedRequest, wrappedResponse);

        // Logowanie żądania
        logRequest(wrappedRequest);

        // Logowanie odpowiedzi
        logResponse(wrappedResponse);

        // Uzupełnienie odpowiedzi (konieczne przy użyciu ContentCachingResponseWrapper)
        wrappedResponse.copyBodyToResponse();
    }

    private void logRequest(ContentCachingRequestWrapper request) {
        String requestBody = new String(request.getContentAsByteArray());
        LOGGER.info("REQUEST -> Method: {}, URI: {}, Body: {}", request.getMethod(), request.getRequestURI(), requestBody);
    }

    private void logResponse(ContentCachingResponseWrapper response) {
        String responseBody = new String(response.getContentAsByteArray());
        LOGGER.info("RESPONSE -> Status: {}, Body: {}", response.getStatus(), responseBody);
    }
}