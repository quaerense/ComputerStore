package com.equrence.servlet.accounting;

import com.equrence.model.entity.Employee;
import com.equrence.model.service.EmployeeService;
import com.equrence.model.service.EmployeeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/accounting")
public class EmployeesServlet extends HttpServlet {
    private EmployeeService service;

    @Override
    public void init() {
        service = new EmployeeServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Employee> employees = service.getAllEmployees();

        req.setAttribute("employees", employees);

        req.getRequestDispatcher("/view/accounting/employees.jsp").forward(req, resp);
    }
}
