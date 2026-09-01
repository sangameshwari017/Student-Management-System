package com.student.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.student.model.Marks;
import com.student.util.DBConnection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MarksDAO {

    public boolean addMarks(Marks marks) {

        boolean status = false;

        String sql = "INSERT INTO marks VALUES(?,?,?,?,?,?)";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, marks.getMarkId());
            ps.setInt(2, marks.getStudentId());
            ps.setString(3, marks.getStudentName());
            ps.setString(4, marks.getSubject());
            ps.setInt(5, marks.getMark());
            ps.setString(6, marks.getGrade());

            int result = ps.executeUpdate();

            if(result > 0) {
                status = true;
            }

            ps.close();
            con.close();

        } catch(Exception e) {
            e.printStackTrace();
        }

        return status;
    }
    public List<Marks> getAllMarks() {

        List<Marks> list = new ArrayList<>();

        String sql = "SELECT * FROM marks";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Marks marks = new Marks();

                marks.setMarkId(rs.getInt("mark_id"));
                marks.setStudentId(rs.getInt("student_id"));
                marks.setStudentName(rs.getString("student_name"));
                marks.setSubject(rs.getString("subject"));
                marks.setMark(rs.getInt("mark"));
                marks.setGrade(rs.getString("grade"));

                list.add(marks);
            }

            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
    
    public Marks getMarksById(int markId) {

        Marks marks = null;

        String sql = "SELECT * FROM marks WHERE mark_id=?";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, markId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                marks = new Marks();

                marks.setMarkId(rs.getInt("mark_id"));
                marks.setStudentId(rs.getInt("student_id"));
                marks.setStudentName(rs.getString("student_name"));
                marks.setSubject(rs.getString("subject"));
                marks.setMark(rs.getInt("mark"));
                marks.setGrade(rs.getString("grade"));
            }

            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return marks;
    }
    
    public boolean updateMarks(Marks marks) {

        boolean status = false;

        String sql = "UPDATE marks SET student_id=?, student_name=?, subject=?, mark=?, grade=? WHERE mark_id=?";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, marks.getStudentId());
            ps.setString(2, marks.getStudentName());
            ps.setString(3, marks.getSubject());
            ps.setInt(4, marks.getMark());
            ps.setString(5, marks.getGrade());
            ps.setInt(6, marks.getMarkId());

            int result = ps.executeUpdate();

            if(result > 0){
                status = true;
            }

            ps.close();
            con.close();

        } catch(Exception e){
            e.printStackTrace();
        }

        return status;
    }
    
    public boolean deleteMarks(int markId) {

        boolean status = false;

        String sql = "DELETE FROM marks WHERE mark_id=?";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, markId);

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