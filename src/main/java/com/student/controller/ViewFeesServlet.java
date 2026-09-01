package com.student.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.student.dao.FeesDAO;
import com.student.model.Fees;

public class ViewFeesServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        FeesDAO dao = new FeesDAO();

        List<Fees> list = dao.getAllFees();

        out.println("<html>");
        out.println("<head>");
        out.println("<title>View Fees</title>");
        out.println("<link rel='stylesheet' href='style.css'>");
        out.println("</head>");
        out.println("<body>");

        out.println("<h2 align='center'>Fees Details</h2>");

        out.println("<table border='1' align='center'>");

        out.println("<tr>");
        out.println("<th>Fee ID</th>");
        out.println("<th>Student ID</th>");
        out.println("<th>Student Name</th>");
        out.println("<th>Amount</th>");
        out.println("<th>Payment Date</th>");
        out.println("<th>Payment Status</th>");
        out.println("</tr>");

        for (Fees fees : list) {

            out.println("<tr>");
            out.println("<td>" + fees.getFeeId() + "</td>");
            out.println("<td>" + fees.getStudentId() + "</td>");
            out.println("<td>" + fees.getStudentName() + "</td>");
            out.println("<td>" + fees.getAmount() + "</td>");
            out.println("<td>" + fees.getPaymentDate() + "</td>");
            out.println("<td>" + fees.getPaymentStatus() + "</td>");
            out.println("</tr>");
        }

        out.println("</table>");

        out.println("<br><br>");

        out.println("<center>");
        out.println("<a href='feesmenu.html'>");
        out.println("<button>Back to Fees Module</button>");
        out.println("</a>");
        out.println("</center>");

        out.println("</body>");
        out.println("</html>");
    }
}