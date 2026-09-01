package com.student.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.student.dao.AttendanceDAO;
import com.student.model.Attendance;

public class UpdateAttendanceServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        int attendanceId = Integer.parseInt(request.getParameter("attendanceId"));
        int studentId = Integer.parseInt(request.getParameter("studentId"));
        String studentName = request.getParameter("studentName");
        String attendanceDate = request.getParameter("attendanceDate");
        String status = request.getParameter("status");

        Attendance attendance = new Attendance();

        attendance.setAttendanceId(attendanceId);
        attendance.setStudentId(studentId);
        attendance.setStudentName(studentName);
        attendance.setAttendanceDate(attendanceDate);
        attendance.setStatus(status);

        AttendanceDAO dao = new AttendanceDAO();

        boolean result = dao.updateAttendance(attendance);

        if(result) {
        	response.sendRedirect("success.html");

        } else {

            response.sendRedirect("failed.html");
        }

        out.println("<br><br>");
        out.println("<a href='attendancemenu.html'>Back</a>");
    }
}