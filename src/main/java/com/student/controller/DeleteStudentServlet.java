package com.student.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.student.dao.StudentDAO;

public class DeleteStudentServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        int sid = Integer.parseInt(request.getParameter("sid"));

        StudentDAO dao = new StudentDAO();

        boolean status = dao.deleteStudent(sid);

        if(status)
        {
        	response.sendRedirect("success.html");

        } else {

            response.sendRedirect("failed.html");
        }

    }

}