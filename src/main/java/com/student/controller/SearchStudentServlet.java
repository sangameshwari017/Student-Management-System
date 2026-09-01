package com.student.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.student.dao.StudentDAO;
import com.student.model.Student;

public class SearchStudentServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        int sid = Integer.parseInt(request.getParameter("sid"));

        StudentDAO dao = new StudentDAO();

        Student student = dao.getStudentById(sid);

        out.println("<html>");
        out.println("<head>");
        out.println("<title>Search Student</title>");
        out.println("<link rel='stylesheet' href='style.css'>");
        out.println("</head>");
        out.println("<body>");

        if(student != null)
        {
            out.println("<h2 align='center'>Student Details</h2>");

            out.println("<table border='1' align='center'>");

            out.println("<tr>");
            out.println("<th>ID</th>");
            out.println("<th>Name</th>");
            out.println("<th>Age</th>");
            out.println("<th>Gender</th>");
            out.println("<th>DOB</th>");
            out.println("<th>Course</th>");
            out.println("<th>City</th>");
            out.println("<th>Mobile</th>");
            out.println("<th>Email</th>");
            out.println("<th>Blood Group</th>");
            out.println("<th>Parent Name</th>");
            out.println("<th>Parent Mobile</th>");
            out.println("<th>Address</th>");
            out.println("</tr>");

            out.println("<tr>");
            out.println("<td>"+student.getSid()+"</td>");
            out.println("<td>"+student.getSname()+"</td>");
            out.println("<td>"+student.getAge()+"</td>");
            out.println("<td>"+student.getGender()+"</td>");
            out.println("<td>"+student.getDob()+"</td>");
            out.println("<td>"+student.getCourse()+"</td>");
            out.println("<td>"+student.getCity()+"</td>");
            out.println("<td>"+student.getMobile()+"</td>");
            out.println("<td>"+student.getEmail()+"</td>");
            out.println("<td>"+student.getBloodgroup()+"</td>");
            out.println("<td>"+student.getParentname()+"</td>");
            out.println("<td>"+student.getParentmobile()+"</td>");
            out.println("<td>"+student.getAddress()+"</td>");
            out.println("</tr>");

            out.println("</table>");
        }
        else
        {
            out.println("<h2 align='center'>Student Not Found</h2>");
        }

        out.println("<br><br>");

        out.println("<center>");
        out.println("<a href='studentmenu.html'>");
        out.println("<button>Back to Student Module</button>");
        out.println("</a>");
        out.println("</center>");
        out.println("</body>");
        out.println("</html>");
    }
}