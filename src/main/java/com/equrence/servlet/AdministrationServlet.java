package com.equrence.servlet;

import com.equrence.model.entity.Employee;
import com.equrence.model.service.EmployeeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/administration")
public class AdministrationServlet extends HttpServlet {
    private EmployeeService service;

    @Override
    public void init() {
        service = new EmployeeService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Employee> employees = service.getAllEmployees();

        req.setAttribute("employees", employees);

        req.getRequestDispatcher(req.getContextPath() + "/view/administration/employees.jsp").forward(req, resp);
    }
}
