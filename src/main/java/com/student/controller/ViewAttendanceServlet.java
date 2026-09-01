package com.student.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.student.dao.AttendanceDAO;
import com.student.model.Attendance;

public class ViewAttendanceServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        AttendanceDAO dao = new AttendanceDAO();

        List<Attendance> list = dao.getAllAttendance();

        out.println("<html>");
        out.println("<head>");
        out.println("<title>View Attendance</title>");
        out.println("<link rel='stylesheet' href='style.css'>");
        out.println("</head>");
        out.println("<body>");

        out.println("<h2 align='center'>Attendance Details</h2>");

        out.println("<table border='1' align='center'>");

        out.println("<tr>");
        out.println("<th>Attendance ID</th>");
        out.println("<th>Student ID</th>");
        out.println("<th>Student Name</th>");
        out.println("<th>Date</th>");
        out.println("<th>Status</th>");
        out.println("</tr>");

        for (Attendance attendance : list) {

            out.println("<tr>");
            out.println("<td>" + attendance.getAttendanceId() + "</td>");
            out.println("<td>" + attendance.getStudentId() + "</td>");
            out.println("<td>" + attendance.getStudentName() + "</td>");
            out.println("<td>" + attendance.getAttendanceDate() + "</td>");
            out.println("<td>" + attendance.getStatus() + "</td>");
            out.println("</tr>");
        }

        out.println("</table>");

        out.println("<center>");
        out.println("<a href='attendancemenu.html'>");
        out.println("<button>Back to Attendance Module</button>");
        out.println("</a>");
        out.println("</center>");

        out.println("</body>");
        out.println("</html>");
    }
}