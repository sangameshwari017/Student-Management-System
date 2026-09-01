package com.student.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.student.dao.FacultyDAO;
import com.student.model.Faculty;

public class AddFacultyServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        int facultyId = Integer.parseInt(request.getParameter("fid"));
        String facultyName = request.getParameter("fname");
        String department = request.getParameter("department");
        String qualification = request.getParameter("qualification");
        int experience = Integer.parseInt(request.getParameter("experience"));
        String mobile = request.getParameter("mobile");
        String email = request.getParameter("email");

        Faculty faculty = new Faculty();

        faculty.setFacultyId(facultyId);
        faculty.setFacultyName(facultyName);
        faculty.setDepartment(department);
        faculty.setQualification(qualification);
        faculty.setExperience(experience);
        faculty.setMobile(mobile);
        faculty.setEmail(email);

        FacultyDAO dao = new FacultyDAO();

        boolean status = dao.addFaculty(faculty);

        if(status) {
        	response.sendRedirect("success.html");

        } else {

            response.sendRedirect("failed.html");
        }
    }
}