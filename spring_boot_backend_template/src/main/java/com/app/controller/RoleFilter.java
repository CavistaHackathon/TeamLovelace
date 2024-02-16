package com.app.controller;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.*;
import java.io.IOException;

@WebFilter("/user/*") // Define the URL pattern you want to filter
public class RoleFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        // Check user role here using the session
         HttpServletRequest httpRequest = (HttpServletRequest) request;
        String requestURI = httpRequest.getRequestURI();
        if (requestURI.endsWith("/login")) {
            chain.doFilter(request, response);
            System.out.println("forrrrrrrrrrrrrrrrr login page ");
            return;
        }
        HttpSession session = ((HttpServletRequest) request).getSession(false);

        if (session != null && session.getAttribute("name") != null) {
            System.out.println("checkinggggggggggggggg role");
            String userRole = (String) session.getAttribute("name");
           System.out.println("Welcomeeeeeee   "+userRole);
                chain.doFilter(request, response);
            } else {
                // User doesn't have the required role, handle accordingly (e.g., redirect to an error page)
                HttpServletResponse httpResponse = (HttpServletResponse) response;
            httpResponse.sendRedirect("/login");
            }
        
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Initialization code if needed
    }

    @Override
    public void destroy() {
        // Cleanup code if needed
    }
}
