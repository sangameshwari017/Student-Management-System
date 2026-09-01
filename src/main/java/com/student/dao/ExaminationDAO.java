package com.student.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.student.model.Examination;
import com.student.util.DBConnection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ExaminationDAO {

    public boolean addExamination(Examination exam) {

        boolean status = false;

        String sql = "INSERT INTO examination VALUES(?,?,?,?,?,?)";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, exam.getExamId());
            ps.setInt(2, exam.getStudentId());
            ps.setString(3, exam.getStudentName());
            ps.setString(4, exam.getExamName());
            ps.setString(5, exam.getExamDate());
            ps.setString(6, exam.getExamTime());

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
    
    public List<Examination> getAllExaminations() {

        List<Examination> list = new ArrayList<>();

        String sql = "SELECT * FROM examination";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Examination exam = new Examination();

                exam.setExamId(rs.getInt("exam_id"));
                exam.setStudentId(rs.getInt("student_id"));
                exam.setStudentName(rs.getString("student_name"));
                exam.setExamName(rs.getString("exam_name"));
                exam.setExamDate(rs.getString("exam_date"));
                exam.setExamTime(rs.getString("exam_time"));

                list.add(exam);
            }

            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
    
    public Examination getExaminationById(int examId) {

        Examination exam = null;

        String sql = "SELECT * FROM examination WHERE exam_id=?";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, examId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                exam = new Examination();

                exam.setExamId(rs.getInt("exam_id"));
                exam.setStudentId(rs.getInt("student_id"));
                exam.setStudentName(rs.getString("student_name"));
                exam.setExamName(rs.getString("exam_name"));
                exam.setExamDate(rs.getString("exam_date"));
                exam.setExamTime(rs.getString("exam_time"));
            }

            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return exam;
    }
    public boolean updateExamination(Examination exam) {

        boolean status = false;

        String sql = "UPDATE examination SET student_id=?, student_name=?, exam_name=?, exam_date=?, exam_time=? WHERE exam_id=?";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, exam.getStudentId());
            ps.setString(2, exam.getStudentName());
            ps.setString(3, exam.getExamName());
            ps.setString(4, exam.getExamDate());
            ps.setString(5, exam.getExamTime());
            ps.setInt(6, exam.getExamId());

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
    
    public boolean deleteExamination(int examId) {

        boolean status = false;

        String sql = "DELETE FROM examination WHERE exam_id=?";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, examId);

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