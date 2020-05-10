package com.equrence.servlet.accounting;

import com.equrence.model.entity.Employee;
import com.equrence.model.entity.enumeration.EmployeePosition;
import com.equrence.model.service.EmployeeService;
import com.equrence.model.service.EmployeeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Date;

@WebServlet("/accounting/employee_edit")
public class EmployeeEditServlet extends HttpServlet {
    private EmployeeService service;

    @Override
    public void init() {
        service = new EmployeeServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));

        Employee employee = service.getEmployeeById(id);

        req.setAttribute("employee", employee);

        req.getRequestDispatcher("/view/accounting/employee_edit.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Employee employee = new Employee();

        int id = Integer.parseInt(req.getParameter("id"));

        employee.setEmployeeId(id);
        employee.setEmployeeName(req.getParameter("name"));
        employee.setEmployeeBirth(Date.valueOf(req.getParameter("birth")));
        employee.setEmployeePosition(EmployeePosition.valueOf(req.getParameter("position")));
        employee.setEmployeeAddress(req.getParameter("address"));
        employee.setPhoneNumber(req.getParameter("phone_number"));
        employee.setEmployeeSalary(new BigDecimal(req.getParameter("salary")));

        service.updateEmployeeInfo(id, employee);

        resp.sendRedirect(req.getContextPath() + "/accounting");
    }
}
