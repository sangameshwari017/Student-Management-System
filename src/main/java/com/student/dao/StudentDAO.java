package com.student.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.student.model.Student;
import com.student.util.DBConnection;

public class StudentDAO {

    // 1. Add Student
	public boolean addStudent(Student student) {

		String sql = "INSERT INTO studentmanagement "
		        + "(sid,sname,age,gender,dob,course,city,mobile,email,bloodgroup,parentname,parentmobile,address) "
		        + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
	    try {

	        Connection con = DBConnection.getConnection();

	        if (con == null) {
	            System.out.println("Database connection failed");
	            return false;
	        }

	        PreparedStatement ps = con.prepareStatement(sql);

	        ps.setInt(1, student.getSid());
	        ps.setString(2, student.getSname());
	        ps.setInt(3, student.getAge());
	        ps.setString(4, student.getGender());
	        ps.setString(5, student.getDob());
	        ps.setString(6, student.getCourse());
	        ps.setString(7, student.getCity());
	        ps.setString(8, student.getMobile());
	        ps.setString(9, student.getEmail());
	        ps.setString(10, student.getBloodgroup());
	        ps.setString(11, student.getParentname());
	        ps.setString(12, student.getParentmobile());
	        ps.setString(13, student.getAddress());

	        int result = ps.executeUpdate();

	        ps.close();
	        con.close();

	        if (result > 0) {
	            System.out.println("Student inserted successfully");
	            return true;
	        }

	    } catch (Exception e) {

	        System.out.println("Error while inserting student:");
	        e.printStackTrace();
	    }

	    return false;
	}

    // 2. Get Student By ID
    public Student getStudentById(int id) {

        Student student = null;

        String sql = "SELECT * FROM studentmanagement WHERE sid = ?";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                student = new Student();

                student.setSid(rs.getInt("sid"));
                student.setSname(rs.getString("sname"));
                student.setAge(rs.getInt("age"));
                student.setCourse(rs.getString("course"));
                student.setCity(rs.getString("city"));
                student.setMobile(rs.getString("mobile"));
                student.setEmail(rs.getString("email"));
                student.setGender(rs.getString("gender"));
                student.setDob(rs.getString("dob"));
                student.setBloodgroup(rs.getString("bloodgroup"));
                student.setParentname(rs.getString("parentname"));
                student.setParentmobile(rs.getString("parentmobile"));
                student.setAddress(rs.getString("address"));
            }

            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return student;
    }


    // 3. Get All Students
    public List<Student> getAllStudents() {

        List<Student> list = new ArrayList<>();

        String sql = "SELECT * FROM studentmanagement";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Student student = new Student();

                student.setSid(rs.getInt("sid"));
                student.setSname(rs.getString("sname"));
                student.setAge(rs.getInt("age"));
                student.setCourse(rs.getString("course"));
                student.setCity(rs.getString("city"));
                student.setMobile(rs.getString("mobile"));
                student.setEmail(rs.getString("email"));
                student.setGender(rs.getString("gender"));
                student.setDob(rs.getString("dob"));
                student.setBloodgroup(rs.getString("bloodgroup"));
                student.setParentname(rs.getString("parentname"));
                student.setParentmobile(rs.getString("parentmobile"));
                student.setAddress(rs.getString("address"));

                list.add(student);
            }

            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }


    // 4. Update Student
    public boolean updateStudent(Student student) {

        boolean status = false;

        String sql = "UPDATE studentmanagement SET "
                + "sname=?, age=?, gender=?, dob=?, course=?, city=?, mobile=?, email=?, bloodgroup=?, parentname=?, parentmobile=?, address=? "
                + "WHERE sid=?";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, student.getSname());
            ps.setInt(2, student.getAge());
            ps.setString(3, student.getGender());
            ps.setString(4, student.getDob());
            ps.setString(5, student.getCourse());
            ps.setString(6, student.getCity());
            ps.setString(7, student.getMobile());
            ps.setString(8, student.getEmail());
            ps.setString(9, student.getBloodgroup());
            ps.setString(10, student.getParentname());
            ps.setString(11, student.getParentmobile());
            ps.setString(12, student.getAddress());
            ps.setInt(13, student.getSid());

            int result = ps.executeUpdate();

            if (result > 0) {
                status = true;
            }

            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }


    // 5. Delete Student
    public boolean deleteStudent(int id) {

        boolean status = false;

        String sql = "DELETE FROM studentmanagement WHERE sid = ?";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, id);

            int result = ps.executeUpdate();

            if (result > 0) {
                status = true;
            }

            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }
}