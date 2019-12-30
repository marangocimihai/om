package spring.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class EmployeeFilter implements Filter {
    private static final Logger LOG = LoggerFactory.getLogger(EmployeeFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        LOG.info("Initializing filter {}", this);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        LOG.info("Logging request {} : {}", req.getMethod(), req.getRequestURI());
        chain.doFilter(request, response);
        LOG.info("Logging response {} : {}", res.getStatus(), res.getContentType());
    }

    @Override
    public void destroy() {
        LOG.info("Destroying filter {}", this);
    }
}
