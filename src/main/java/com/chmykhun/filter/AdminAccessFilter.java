package com.chmykhun.filter;

import com.chmykhun.manager.Config;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class AdminAccessFilter implements Filter {
    private static Logger log = LogManager.getLogger(AdminAccessFilter.class);

    private static final String KEY = "admin";

    @Override
    public void init(FilterConfig config) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        if (request.getSession().getAttribute(KEY) != null) {
            chain.doFilter(req, resp);
        } else {
            log.log(Level.DEBUG, "Unauthorized attempt to access admin resources");
            req.getRequestDispatcher(Config.getInstance().getProperty(Config.SIGN_IN_PAGE)).forward(req,
                    resp);
        }
    }

    @Override
    public void destroy() {
    }

}
