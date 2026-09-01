package com.student.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.student.dao.AttendanceDAO;

public class DeleteAttendanceServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        int attendanceId = Integer.parseInt(request.getParameter("attendanceId"));

        AttendanceDAO dao = new AttendanceDAO();

        boolean status = dao.deleteAttendance(attendanceId);

        if (status) {

        	response.sendRedirect("success.html");

        } else {

            response.sendRedirect("failed.html");

        }

        out.println("<br><br>");
        out.println("<a href='attendancemenu.html'>Back</a>");
    }
}