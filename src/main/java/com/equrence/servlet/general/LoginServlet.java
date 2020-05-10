package com.equrence.servlet.general;

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

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private EmployeeService service;

    @Override
    public void init() {
        service = new EmployeeServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/view/general/index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int employeeId = Integer.parseInt(req.getParameter("id"));
        String employeePassword = req.getParameter("password");
        String contextPath = req.getContextPath();

        if (service.employeeIsExist(employeeId, employeePassword)) {
            Employee employee = service.getEmployeeById(employeeId);
            EmployeePosition position = employee.getEmployeePosition();

            req.getSession().setAttribute("employee", employee);

            switch (position) {
                case ADMINISTRATOR:
                case DIRECTOR:
                case ACCOUNTANT:
                    resp.sendRedirect(contextPath + "/accounting");
                    break;
                case MANAGER:
                    resp.sendRedirect(contextPath + "/management");
                    break;
                case SELLER:
                    resp.sendRedirect(contextPath + "/selling");
                    break;
            }
        } else {
            resp.sendRedirect(contextPath + "/login");
        }
    }
}
