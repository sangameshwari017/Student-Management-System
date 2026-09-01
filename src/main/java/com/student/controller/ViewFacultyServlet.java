package com.student.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.student.dao.FacultyDAO;
import com.student.model.Faculty;

public class ViewFacultyServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        FacultyDAO dao = new FacultyDAO();

        List<Faculty> list = dao.getAllFaculty();

        out.println("<html>");
        out.println("<head>");
        out.println("<title>View Faculty</title>");
        out.println("<link rel='stylesheet' href='style.css'>");
        out.println("</head>");
        out.println("<body>");

        out.println("<h2 align='center'>Faculty Details</h2>");

        out.println("<table border='1' align='center'>");

        out.println("<tr>");
        out.println("<th>ID</th>");
        out.println("<th>Name</th>");
        out.println("<th>Department</th>");
        out.println("<th>Qualification</th>");
        out.println("<th>Experience</th>");
        out.println("<th>Mobile</th>");
        out.println("<th>Email</th>");
        out.println("</tr>");

        for(Faculty faculty : list){

            out.println("<tr>");

            out.println("<td>"+faculty.getFacultyId()+"</td>");
            out.println("<td>"+faculty.getFacultyName()+"</td>");
            out.println("<td>"+faculty.getDepartment()+"</td>");
            out.println("<td>"+faculty.getQualification()+"</td>");
            out.println("<td>"+faculty.getExperience()+"</td>");
            out.println("<td>"+faculty.getMobile()+"</td>");
            out.println("<td>"+faculty.getEmail()+"</td>");

            out.println("</tr>");
        }

        out.println("</table>");

        out.println("<br><br>");

        out.println("<center>");
        out.println("<a href='facultymenu.html'>");
        out.println("<button>Back to Faculty Module</button>");
        out.println("</a>");
        out.println("</center>");

        out.println("</body>");
        out.println("</html>");
    }
}