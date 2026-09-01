package com.student.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.student.dao.StudentDAO;
import com.student.model.Student;

public class UpdateStudentServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        int sid = Integer.parseInt(request.getParameter("sid"));
        String sname = request.getParameter("sname");
        int age = Integer.parseInt(request.getParameter("age"));
        String course = request.getParameter("course");
        String city = request.getParameter("city");
        String mobile = request.getParameter("mobile");
        String email = request.getParameter("email");

        Student student = new Student();

        student.setSid(sid);
        student.setSname(sname);
        student.setAge(age);
        student.setCourse(course);
        student.setCity(city);
        student.setMobile(mobile);
        student.setEmail(email);

        StudentDAO dao = new StudentDAO();

        boolean status = dao.updateStudent(student);

        if(status)
        {
            response.sendRedirect("success.html");

        } else {

            response.sendRedirect("failed.html");
        }

    }

}