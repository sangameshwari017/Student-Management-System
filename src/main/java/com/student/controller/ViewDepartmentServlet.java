package com.student.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.student.dao.DepartmentDAO;
import com.student.model.Department;

public class ViewDepartmentServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        DepartmentDAO dao = new DepartmentDAO();

        List<Department> list = dao.getAllDepartments();

        out.println("<html>");
        out.println("<head>");
        out.println("<title>View Department</title>");
        out.println("<link rel='stylesheet' href='style.css'>");
        out.println("</head>");
        out.println("<body>");

        out.println("<h2 align='center'>Department Details</h2>");

        out.println("<table border='1' align='center'>");

        out.println("<tr>");
        out.println("<th>ID</th>");
        out.println("<th>Department Name</th>");
        out.println("<th>HOD Name</th>");
        out.println("<th>Total Faculty</th>");
        out.println("<th>Total Students</th>");
        out.println("</tr>");

        for (Department department : list) {

            out.println("<tr>");
            out.println("<td>" + department.getDepartmentId() + "</td>");
            out.println("<td>" + department.getDepartmentName() + "</td>");
            out.println("<td>" + department.getHodName() + "</td>");
            out.println("<td>" + department.getTotalFaculty() + "</td>");
            out.println("<td>" + department.getTotalStudents() + "</td>");
            out.println("</tr>");
        }

        out.println("</table>");

        out.println("<br><br>");

        out.println("<center>");
        out.println("<a href='departmentmenu.html'>");
        out.println("<button>Back to Department Module</button>");
        out.println("</a>");
        out.println("</center>");

        out.println("</body>");
        out.println("</html>");
    }
}