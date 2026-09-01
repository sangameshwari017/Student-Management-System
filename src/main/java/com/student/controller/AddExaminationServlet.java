package com.student.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.student.dao.ExaminationDAO;
import com.student.model.Examination;

public class AddExaminationServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        int examId = Integer.parseInt(request.getParameter("examId"));
        int studentId = Integer.parseInt(request.getParameter("studentId"));
        String studentName = request.getParameter("studentName");
        String examName = request.getParameter("examName");
        String examDate = request.getParameter("examDate");
        String examTime = request.getParameter("examTime");

        Examination exam = new Examination();

        exam.setExamId(examId);
        exam.setStudentId(studentId);
        exam.setStudentName(studentName);
        exam.setExamName(examName);
        exam.setExamDate(examDate);
        exam.setExamTime(examTime);

        ExaminationDAO dao = new ExaminationDAO();

        if (dao.addExamination(exam)) {
        	response.sendRedirect("success.html");

        } else {

            response.sendRedirect("failed.html");
        }

        out.println("<br><br>");
        out.println("<a href='examinationmenu.html'>Back</a>");
    }
}