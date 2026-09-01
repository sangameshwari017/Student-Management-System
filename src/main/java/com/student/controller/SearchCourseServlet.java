package com.student.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.student.dao.CourseDAO;
import com.student.model.Course;

public class SearchCourseServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        int courseId = Integer.parseInt(request.getParameter("courseid"));

        CourseDAO dao = new CourseDAO();

        Course course = dao.getCourseById(courseId);

        out.println("<html><head><title>Search Course</title></head><body>");

        if(course != null){

            out.println("<h2>Course Details</h2>");

            out.println("<table border='1'>");

            out.println("<tr>");
            out.println("<th>Course ID</th>");
            out.println("<th>Course Name</th>");
            out.println("<th>Duration</th>");
            out.println("<th>Trainer</th>");
            out.println("<th>Fees</th>");
            out.println("</tr>");

            out.println("<tr>");
            out.println("<td>"+course.getCourseId()+"</td>");
            out.println("<td>"+course.getCourseName()+"</td>");
            out.println("<td>"+course.getDuration()+"</td>");
            out.println("<td>"+course.getTrainer()+"</td>");
            out.println("<td>"+course.getFees()+"</td>");
            out.println("</tr>");
            out.println("<link rel='stylesheet' href='style.css'>");

            out.println("</table>");

        } else {

            out.println("<h2>Course Not Found</h2>");

        }
        out.println("<br><br>");

        out.println("<center>");
        out.println("<a href='coursemenu.html>");
        out.println("<button>Back to Course Module</button>");
        out.println("</a>");
        out.println("</center>");

        out.println("</body></html>");
    }
}