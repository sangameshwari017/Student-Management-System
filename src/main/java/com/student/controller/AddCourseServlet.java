package com.student.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.student.dao.CourseDAO;
import com.student.model.Course;

public class AddCourseServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        int courseId = Integer.parseInt(request.getParameter("courseid"));
        String courseName = request.getParameter("coursename");
        String duration = request.getParameter("duration");
        String trainer = request.getParameter("trainer");
        double fees = Double.parseDouble(request.getParameter("fees"));

        Course course = new Course();

        course.setCourseId(courseId);
        course.setCourseName(courseName);
        course.setDuration(duration);
        course.setTrainer(trainer);
        course.setFees(fees);

        CourseDAO dao = new CourseDAO();

        boolean status = dao.addCourse(course);

        if(status) {
        	response.sendRedirect("success.html");

        } else {

            response.sendRedirect("failed.html");
        }
    }
}