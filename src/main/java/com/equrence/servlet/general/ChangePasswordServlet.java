package com.equrence.servlet.general;

import com.equrence.model.entity.Employee;
import com.equrence.model.service.EmployeeService;
import com.equrence.model.service.EmployeeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/change_password")
public class ChangePasswordServlet extends HttpServlet {
    private EmployeeService service;

    @Override
    public void init() {
        service = new EmployeeServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/view/general/change_password.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Employee employee = (Employee) req.getSession().getAttribute("employee");

        int id = employee.getEmployeeId();
        String oldPassword = req.getParameter("oldPassword");
        String newPassword1 = req.getParameter("newPassword1");
        String newPassword2 = req.getParameter("newPassword2");

        boolean success = service.updateEmployeePassword(id, oldPassword, newPassword1, newPassword2);

        if (success) {
            resp.sendRedirect(req.getContextPath() + "/my_info");
        } else {
            resp.sendRedirect(req.getContextPath() + "/view/general/change_password.jsp");
        }
    }
}
