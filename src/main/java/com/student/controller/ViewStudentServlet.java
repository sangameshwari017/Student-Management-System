package com.student.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.student.dao.StudentDAO;
import com.student.model.Student;

public class ViewStudentServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        StudentDAO dao = new StudentDAO();

        List<Student> list = dao.getAllStudents();

        out.println("<html>");
        out.println("<head>");
        out.println("<title>View Students</title>");
        out.println("<link rel='stylesheet' href='style.css'>");
        out.println("</head>");
        out.println("<body>");

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

        for(Student s : list){

            out.println("<tr>");

            out.println("<td>"+s.getSid()+"</td>");
            out.println("<td>"+s.getSname()+"</td>");
            out.println("<td>"+s.getAge()+"</td>");
            out.println("<td>"+s.getGender()+"</td>");
            out.println("<td>"+s.getDob()+"</td>");
            out.println("<td>"+s.getCourse()+"</td>");
            out.println("<td>"+s.getCity()+"</td>");
            out.println("<td>"+s.getMobile()+"</td>");
            out.println("<td>"+s.getEmail()+"</td>");
            out.println("<td>"+s.getBloodgroup()+"</td>");
            out.println("<td>"+s.getParentname()+"</td>");
            out.println("<td>"+s.getParentmobile()+"</td>");
            out.println("<td>"+s.getAddress()+"</td>");

            out.println("</tr>");
        }

        out.println("</table>");
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