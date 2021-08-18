package cn.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter("/*")
public class FilterDemo01 implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("FilterDemo01 coming...");
        chain.doFilter(req, resp);
        System.out.println("FilterDemo01 end...");


    }

    public void init(FilterConfig config) throws ServletException {

    }

}
