package com.ofsystem.Capstone.Config.RequestId;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.UUID;

@Component
@WebFilter("/*")
public class RequestIdResponseFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Inicialización del filtro
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        // Generar un Request-ID único
        String requestId = UUID.randomUUID().toString();

        // Establecer el Request-ID en el ServletResponse
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        httpServletResponse.setHeader("Request-ID", requestId);

        // Envolver la respuesta en HttpServletResponseWrapper
        ResponseWrapper responseWrapper = new ResponseWrapper(httpServletResponse);
        chain.doFilter(request, responseWrapper);

        responseWrapper.sendResponse();
    }

    @Override
    public void destroy() {
        // Lógica de limpieza del filtro
    }

    private static class ResponseWrapper extends HttpServletResponseWrapper {
        private int status;

        public ResponseWrapper(HttpServletResponse response) {
            super(response);
        }

        @Override
        public void setStatus(int sc) {
            this.status = sc;
            super.setStatus(sc);
        }

        @Override
        public void sendError(int sc) throws IOException {
            this.status = sc;
            super.sendError(sc);
        }

        @Override
        public void sendError(int sc, String msg) throws IOException {
            this.status = sc;
            super.sendError(sc, msg);
        }

        @Override
        public void sendRedirect(String location) throws IOException {
            this.status = SC_MOVED_TEMPORARILY;
            super.sendRedirect(location);
        }

        public void sendResponse() throws IOException {
            if (status != SC_OK) {
                super.setStatus(status);
            }
            super.flushBuffer();
        }
    }
}
