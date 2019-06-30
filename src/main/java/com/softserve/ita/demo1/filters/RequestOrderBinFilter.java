package com.softserve.ita.demo1.filters;

import com.softserve.ita.demo1.util.OrderBin;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = "/*")
public class RequestOrderBinFilter implements Filter {

    private ServletContext context;

    public void init(FilterConfig fConfig) throws ServletException {
        this.context = fConfig.getServletContext();
        this.context.log("AuthenticationFilter initialized");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpSession session = request.getSession(true);
        OrderBin orderBin = new OrderBin(session);
        request.setAttribute("orderBin", orderBin);

        filterChain.doFilter(servletRequest, servletResponse);
    }

    public void destroy() {
        //close any resources here
    }
}
