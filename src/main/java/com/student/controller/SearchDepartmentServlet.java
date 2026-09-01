package com.student.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.student.dao.DepartmentDAO;
import com.student.model.Department;

public class SearchDepartmentServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        int departmentId = Integer.parseInt(request.getParameter("did"));

        DepartmentDAO dao = new DepartmentDAO();

        Department department = dao.getDepartmentById(departmentId);

        out.println("<html>");
        out.println("<head>");
        out.println("<title>Search Department</title>");
        out.println("</head>");
        out.println("<body>");

        if (department != null) {

            out.println("<h2>Department Details</h2>");

            out.println("<table border='1'>");

            out.println("<tr>");
            out.println("<th>ID</th>");
            out.println("<th>Department Name</th>");
            out.println("<th>HOD Name</th>");
            out.println("<th>Total Faculty</th>");
            out.println("<th>Total Students</th>");
            out.println("</tr>");

            out.println("<tr>");
            out.println("<td>" + department.getDepartmentId() + "</td>");
            out.println("<td>" + department.getDepartmentName() + "</td>");
            out.println("<td>" + department.getHodName() + "</td>");
            out.println("<td>" + department.getTotalFaculty() + "</td>");
            out.println("<td>" + department.getTotalStudents() + "</td>");
            out.println("</tr>");

            out.println("</table>");

        } else {

            out.println("<h2>Department Not Found</h2>");

        }

        out.println("<br><br>");

        out.println("<center>");
        out.println("<a href='departmentmenu.html'>");
        out.println("<button>Back to Department Module</button>");
        out.println("</a>");
        out.println("</center>");
    }
}