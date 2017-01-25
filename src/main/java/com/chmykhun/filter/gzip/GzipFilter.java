package com.chmykhun.filter.gzip;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GzipFilter implements Filter {
    private static Logger log = LogManager.getLogger(GzipFilter.class);

    @Override
    public void init(FilterConfig config) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        String acceptEncoding = request.getHeader("accept-encoding");
        if (acceptEncoding != null && acceptEncoding.indexOf("gzip") != -1) {
            GzipResponseWrapper responseWrapper = new GzipResponseWrapper(response);
            chain.doFilter(req, responseWrapper);

            log.log(Level.DEBUG, "Compressing " + request.getServletPath() + "... ");

            responseWrapper.finishResponse();
            return;
        }
        chain.doFilter(req, resp);
    }

    @Override
    public void destroy() {
    }

}
