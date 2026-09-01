package com.student.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.student.dao.FacultyDAO;
import com.student.model.Faculty;

public class SearchFacultyServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        int facultyId = Integer.parseInt(request.getParameter("fid"));

        FacultyDAO dao = new FacultyDAO();

        Faculty faculty = dao.getFacultyById(facultyId);

        out.println("<html>");
        out.println("<head>");
        out.println("<title>Search Faculty</title>");
        out.println("</head>");
        out.println("<body>");

        if(faculty != null){

            out.println("<h2>Faculty Details</h2>");

            out.println("<table border='1'>");

            out.println("<tr>");
            out.println("<th>ID</th>");
            out.println("<th>Name</th>");
            out.println("<th>Department</th>");
            out.println("<th>Qualification</th>");
            out.println("<th>Experience</th>");
            out.println("<th>Mobile</th>");
            out.println("<th>Email</th>");
            out.println("</tr>");

            out.println("<tr>");
            out.println("<td>"+faculty.getFacultyId()+"</td>");
            out.println("<td>"+faculty.getFacultyName()+"</td>");
            out.println("<td>"+faculty.getDepartment()+"</td>");
            out.println("<td>"+faculty.getQualification()+"</td>");
            out.println("<td>"+faculty.getExperience()+"</td>");
            out.println("<td>"+faculty.getMobile()+"</td>");
            out.println("<td>"+faculty.getEmail()+"</td>");
            out.println("</tr>");

            out.println("</table>");

        } else {

            out.println("<h2>Faculty Not Found</h2>");

        }

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