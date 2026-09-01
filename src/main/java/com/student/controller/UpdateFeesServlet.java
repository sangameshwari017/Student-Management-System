package com.student.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.student.dao.FeesDAO;
import com.student.model.Fees;

public class UpdateFeesServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        int feeId = Integer.parseInt(request.getParameter("feeId"));
        int studentId = Integer.parseInt(request.getParameter("studentId"));
        String studentName = request.getParameter("studentName");
        double amount = Double.parseDouble(request.getParameter("amount"));
        String paymentDate = request.getParameter("paymentDate");
        String paymentStatus = request.getParameter("paymentStatus");

        Fees fees = new Fees();

        fees.setFeeId(feeId);
        fees.setStudentId(studentId);
        fees.setStudentName(studentName);
        fees.setAmount(amount);
        fees.setPaymentDate(paymentDate);
        fees.setPaymentStatus(paymentStatus);

        FeesDAO dao = new FeesDAO();

        boolean status = dao.updateFees(fees);

        if (status) {
        	response.sendRedirect("success.html");

        } else {

            response.sendRedirect("failed.html");
        }

        out.println("<br><br>");
        out.println("<a href='feesmenu.html'>Back</a>");
    }
}