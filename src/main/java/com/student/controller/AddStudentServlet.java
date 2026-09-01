package com.student.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.student.dao.StudentDAO;
import com.student.model.Student;

public class AddStudentServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        int student_id = Integer.parseInt(request.getParameter("sid"));
        String student_name = request.getParameter("sname");
        int age = Integer.parseInt(request.getParameter("age"));
        String course = request.getParameter("course");
        String city = request.getParameter("city");
        String mobile = request.getParameter("mobile");
        String email = request.getParameter("email");
        String gender = request.getParameter("gender");

        String dob = request.getParameter("dob");

        String bloodgroup = request.getParameter("bloodgroup");

        String parentname = request.getParameter("parentname");

        String parentmobile = request.getParameter("parentmobile");

        String address = request.getParameter("address");

        Student student = new Student();

        student.setSid(student_id);
        student.setSname(student_name);
        student.setAge(age);
        student.setCourse(course);
        student.setCity(city);
        student.setMobile(mobile);
        student.setEmail(email);
        student.setGender(gender);

        student.setDob(dob);

        student.setBloodgroup(bloodgroup);

        student.setParentname(parentname);

        student.setParentmobile(parentmobile);

        student.setAddress(address);

        StudentDAO dao = new StudentDAO();

        boolean result = dao.addStudent(student);

        if (result) {

            response.sendRedirect("success.html");

        } else {

            response.sendRedirect("failed.html");

        }
    }
}