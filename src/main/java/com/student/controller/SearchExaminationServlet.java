package com.student.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.student.dao.ExaminationDAO;
import com.student.model.Examination;

public class SearchExaminationServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        int examId = Integer.parseInt(request.getParameter("examId"));

        ExaminationDAO dao = new ExaminationDAO();

        Examination exam = dao.getExaminationById(examId);

        out.println("<html>");
        out.println("<head>");
        out.println("<title>Search Examination</title>");
        out.println("<link rel='stylesheet' href='style.css'>");
        out.println("</head>");
        out.println("<body>");

        if (exam != null) {

            out.println("<h2 align='center'>Examination Details</h2>");

            out.println("<table border='1' align='center'>");

            out.println("<tr>");
            out.println("<th>Exam ID</th>");
            out.println("<th>Student ID</th>");
            out.println("<th>Student Name</th>");
            out.println("<th>Exam Name</th>");
            out.println("<th>Exam Date</th>");
            out.println("<th>Exam Time</th>");
            out.println("</tr>");

            out.println("<tr>");
            out.println("<td>" + exam.getExamId() + "</td>");
            out.println("<td>" + exam.getStudentId() + "</td>");
            out.println("<td>" + exam.getStudentName() + "</td>");
            out.println("<td>" + exam.getExamName() + "</td>");
            out.println("<td>" + exam.getExamDate() + "</td>");
            out.println("<td>" + exam.getExamTime() + "</td>");
            out.println("</tr>");

            out.println("</table>");

        } else {

            out.println("<h2 align='center'>Examination Record Not Found</h2>");

        }

        out.println("<br><br>");
        out.println("<center>");
        out.println("<a href='examinationmenu.html'>");
        out.println("<button>Back to Examination Module</button>");
        out.println("</a>");
        out.println("</center>");

        out.println("</body>");
        out.println("</html>");
    }
}