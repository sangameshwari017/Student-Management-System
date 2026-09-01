package com.student.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.student.dao.MarksDAO;
import com.student.model.Marks;

public class AddMarksServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        int markId = Integer.parseInt(request.getParameter("markId"));
        int studentId = Integer.parseInt(request.getParameter("studentId"));
        String studentName = request.getParameter("studentName");
        String subject = request.getParameter("subject");
        int mark = Integer.parseInt(request.getParameter("mark"));
        String grade = request.getParameter("grade");

        Marks marks = new Marks();

        marks.setMarkId(markId);
        marks.setStudentId(studentId);
        marks.setStudentName(studentName);
        marks.setSubject(subject);
        marks.setMark(mark);
        marks.setGrade(grade);

        MarksDAO dao = new MarksDAO();

        boolean status = dao.addMarks(marks);

        if (status) {
        	response.sendRedirect("success.html");

        } else {

            response.sendRedirect("failed.html");
        }

        out.println("<br><br>");
        out.println("<a href='marksmenu.html'>Back</a>");
    }
}