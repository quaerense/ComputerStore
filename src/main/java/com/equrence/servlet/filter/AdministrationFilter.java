package com.equrence.servlet.filter;

import com.equrence.model.entity.Employee;
import com.equrence.model.entity.enumeration.EmployeePosition;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AdministrationFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        HttpSession session = req.getSession();
        Employee employee = (Employee) session.getAttribute("employee");

        if (employee.getEmployeePosition() == EmployeePosition.ADMINISTRATOR) {
            chain.doFilter(req, resp);
        } else {
            resp.getWriter().println("Access Error");
        }
    }
}
