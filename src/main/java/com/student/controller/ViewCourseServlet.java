package com.student.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.student.dao.CourseDAO;
import com.student.model.Course;

public class ViewCourseServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        CourseDAO dao = new CourseDAO();

        List<Course> list = dao.getAllCourses();

        out.println("<html>");
        out.println("<head>");
        out.println("<title>View Courses</title>");
        out.println("<link rel='stylesheet' href='style.css'>");
        out.println("</head>");
        out.println("<body>");

        out.println("<h2 align='center'>Course Details</h2>");

        out.println("<table border='1' align='center'>");

        out.println("<tr>");
        out.println("<th>Course ID</th>");
        out.println("<th>Course Name</th>");
        out.println("<th>Duration</th>");
        out.println("<th>Trainer</th>");
        out.println("<th>Fees</th>");
        out.println("</tr>");

        for(Course c : list)
        {
            out.println("<tr>");

            out.println("<td>"+c.getCourseId()+"</td>");
            out.println("<td>"+c.getCourseName()+"</td>");
            out.println("<td>"+c.getDuration()+"</td>");
            out.println("<td>"+c.getTrainer()+"</td>");
            out.println("<td>"+c.getFees()+"</td>");

            out.println("</tr>");
        }

        out.println("</table>");
        
        out.println("<br><br>");

        out.println("<center>");
        out.println("<a href='coursemenu.html'>");
        out.println("<button>Back to Course Module</button>");
        out.println("</a>");
        out.println("</center>");
        out.println("</body>");
        out.println("</html>");

    }

}