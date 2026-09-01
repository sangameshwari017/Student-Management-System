package com.student.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.student.dao.FacultyDAO;
import com.student.model.Faculty;

public class UpdateFacultyServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

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

        boolean status = dao.updateFaculty(faculty);

        if(status){
        	response.sendRedirect("success.html");

        } else {

            response.sendRedirect("failed.html");
        }

        out.println("<br><br>");
        out.println("<a href='facultymenu.html'>Back</a>");

    }
}