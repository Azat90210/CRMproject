package filters;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        Integer isLogin = (Integer) request.getSession().getAttribute("isLogin");
        String uri = request.getRequestURI();

        if (isLogin != null && isLogin == 1 && uri.endsWith("/login")) {
            response.sendRedirect("/home");
            return;
        }
        if (isLogin != null && isLogin == 1 && !uri.endsWith("/login")) {
            filterChain.doFilter(servletRequest, servletResponse);
        }
        if (isLogin == null && uri.endsWith("/registration")) {
            filterChain.doFilter(servletRequest, servletResponse);
        }


        if (isLogin == null && !uri.endsWith("/login") && !uri.endsWith("/registration")) {
            response.sendRedirect("/login");
            return;
        }
        if (isLogin == null && uri.endsWith("/login")) {
            filterChain.doFilter(servletRequest, servletResponse);
        }

    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
