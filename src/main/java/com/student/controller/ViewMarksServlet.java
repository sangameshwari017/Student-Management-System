package com.student.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.student.dao.MarksDAO;
import com.student.model.Marks;

public class ViewMarksServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        MarksDAO dao = new MarksDAO();

        List<Marks> list = dao.getAllMarks();

        out.println("<html>");
        out.println("<head>");
        out.println("<title>View Marks</title>");
        out.println("<link rel='stylesheet' href='style.css'>");
        out.println("</head>");
        out.println("<body>");

        out.println("<h2 align='center'>Marks Details</h2>");

        out.println("<table border='1' align='center'>");

        out.println("<tr>");
        out.println("<th>Mark ID</th>");
        out.println("<th>Student ID</th>");
        out.println("<th>Student Name</th>");
        out.println("<th>Subject</th>");
        out.println("<th>Mark</th>");
        out.println("<th>Grade</th>");
        out.println("</tr>");

        for (Marks marks : list) {

            out.println("<tr>");
            out.println("<td>" + marks.getMarkId() + "</td>");
            out.println("<td>" + marks.getStudentId() + "</td>");
            out.println("<td>" + marks.getStudentName() + "</td>");
            out.println("<td>" + marks.getSubject() + "</td>");
            out.println("<td>" + marks.getMark() + "</td>");
            out.println("<td>" + marks.getGrade() + "</td>");
            out.println("</tr>");
        }

        out.println("</table>");

        out.println("<br><br>");
        out.println("<center>");
        out.println("<a href='marksmenu.html'>");
        out.println("<button>Back to Mark Module</button>");
        out.println("</a>");
        out.println("</center>");

        out.println("</body>");
        out.println("</html>");
    }
}