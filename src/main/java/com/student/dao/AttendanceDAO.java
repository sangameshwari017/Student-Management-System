package com.student.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.student.model.Attendance;
import com.student.util.DBConnection;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AttendanceDAO {

    public boolean addAttendance(Attendance attendance) {

        boolean status = false;

        String sql = "INSERT INTO attendance VALUES(?,?,?,?,?)";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, attendance.getAttendanceId());
            ps.setInt(2, attendance.getStudentId());
            ps.setString(3, attendance.getStudentName());
            ps.setString(4, attendance.getAttendanceDate());
            ps.setString(5, attendance.getStatus());

            int i = ps.executeUpdate();

            if (i > 0) {
                status = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }
    
    public List<Attendance> getAllAttendance() {

        List<Attendance> list = new ArrayList<>();

        String sql = "SELECT * FROM attendance";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Attendance attendance = new Attendance();

                attendance.setAttendanceId(rs.getInt("attendance_id"));
                attendance.setStudentId(rs.getInt("student_id"));
                attendance.setStudentName(rs.getString("student_name"));
                attendance.setAttendanceDate(rs.getString("attendance_date"));
                attendance.setStatus(rs.getString("status"));

                list.add(attendance);
            }

            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
    
    public Attendance getAttendanceById(int id) {

        Attendance attendance = null;

        String sql = "SELECT * FROM attendance WHERE attendance_id=?";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                attendance = new Attendance();

                attendance.setAttendanceId(rs.getInt("attendance_id"));
                attendance.setStudentId(rs.getInt("student_id"));
                attendance.setStudentName(rs.getString("student_name"));
                attendance.setAttendanceDate(rs.getString("attendance_date"));
                attendance.setStatus(rs.getString("status"));
            }

            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return attendance;
    }
    
    public boolean updateAttendance(Attendance attendance) {

        boolean status = false;

        String sql = "UPDATE attendance SET student_id=?, student_name=?, attendance_date=?, status=? WHERE attendance_id=?";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, attendance.getStudentId());
            ps.setString(2, attendance.getStudentName());
            ps.setString(3, attendance.getAttendanceDate());
            ps.setString(4, attendance.getStatus());
            ps.setInt(5, attendance.getAttendanceId());

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
    
    public boolean deleteAttendance(int attendanceId) {

        boolean status = false;

        String sql = "DELETE FROM attendance WHERE attendance_id=?";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, attendanceId);

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
}