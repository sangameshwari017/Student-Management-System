package com.student.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.*;

public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if(username.equals("admin") && password.equals("admin123"))
        {
        	response.sendRedirect("success.html");

        } else {

            response.sendRedirect("failed.html");
        }
    }
}