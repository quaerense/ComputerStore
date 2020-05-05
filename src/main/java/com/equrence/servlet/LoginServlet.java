package com.equrence.servlet;

import com.equrence.model.entity.Employee;
import com.equrence.model.service.EmployeeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private EmployeeService service;

    @Override
    public void init() {
        service = new EmployeeService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(req.getContextPath() + "/view/general/index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int employeeId = Integer.parseInt(req.getParameter("id"));
        String employeePassword = req.getParameter("password");
        String contextPath = req.getContextPath();

        if (service.employeeIsExist(employeeId, employeePassword)) {
            Employee employee = service.getEmployeeById(employeeId);

            req.getSession().setAttribute("employee", employee);

            switch (employee.getEmployeePosition()) {
                case ADMINISTRATOR:
                case DIRECTOR:
                case MANAGER:
                    resp.sendRedirect(contextPath + "/administration");
                    break;
                case ACCOUNTANT:
                    resp.sendRedirect(contextPath + "/suppliers");
                    break;
                case SELLER:
                    resp.sendRedirect(contextPath + "/products");
                    break;
            }
        } else {
            resp.sendRedirect(contextPath + "/login");
        }
    }
}
