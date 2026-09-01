package com.student.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.student.dao.AttendanceDAO;
import com.student.model.Attendance;

public class SearchAttendanceServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        int attendanceId = Integer.parseInt(request.getParameter("attendanceId"));

        AttendanceDAO dao = new AttendanceDAO();

        Attendance attendance = dao.getAttendanceById(attendanceId);

        out.println("<html>");
        out.println("<head>");
        out.println("<title>Search Attendance</title>");
        out.println("<link rel='stylesheet' href='style.css'>");
        out.println("</head>");
        out.println("<body>");

        if (attendance != null) {

            out.println("<h2 align='center'>Attendance Details</h2>");

            out.println("<table border='1' align='center'>");

            out.println("<tr>");
            out.println("<th>Attendance ID</th>");
            out.println("<th>Student ID</th>");
            out.println("<th>Student Name</th>");
            out.println("<th>Date</th>");
            out.println("<th>Status</th>");
            out.println("</tr>");

            out.println("<tr>");
            out.println("<td>" + attendance.getAttendanceId() + "</td>");
            out.println("<td>" + attendance.getStudentId() + "</td>");
            out.println("<td>" + attendance.getStudentName() + "</td>");
            out.println("<td>" + attendance.getAttendanceDate() + "</td>");
            out.println("<td>" + attendance.getStatus() + "</td>");
            out.println("</tr>");

            out.println("</table>");

        } else {

            out.println("<h2 align='center'>Attendance Record Not Found</h2>");

        }

        out.println("<br><br>");

        out.println("<center>");
        out.println("<a href='attendancemenu.html'>");
        out.println("<button>Back to Attendance Module</button>");
        out.println("</a>");
        out.println("</center>");
        out.println("</body>");
        out.println("</html>");
    }
}