package com.student.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.student.dao.DepartmentDAO;
import com.student.model.Department;

public class AddDepartmentServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        int departmentId = Integer.parseInt(request.getParameter("did"));
        String departmentName = request.getParameter("dname");
        String hodName = request.getParameter("hod");
        int totalFaculty = Integer.parseInt(request.getParameter("faculty"));
        int totalStudents = Integer.parseInt(request.getParameter("students"));

        Department department = new Department();

        department.setDepartmentId(departmentId);
        department.setDepartmentName(departmentName);
        department.setHodName(hodName);
        department.setTotalFaculty(totalFaculty);
        department.setTotalStudents(totalStudents);

        DepartmentDAO dao = new DepartmentDAO();

        boolean status = dao.addDepartment(department);

        if(status){

        	response.sendRedirect("success.html");

        } else {

            response.sendRedirect("failed.html");
        }

        out.println("<br><br>");
        out.println("<a href='departmentmenu.html'>Back</a>");
    }
}