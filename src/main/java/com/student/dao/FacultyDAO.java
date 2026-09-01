package com.student.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.student.model.Faculty;
import com.student.util.DBConnection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class FacultyDAO {

    public boolean addFaculty(Faculty faculty) {

        boolean status = false;

        String sql = "INSERT INTO faculty(faculty_id,faculty_name,department,qualification,experience,mobile,email) VALUES(?,?,?,?,?,?,?)";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, faculty.getFacultyId());
            ps.setString(2, faculty.getFacultyName());
            ps.setString(3, faculty.getDepartment());
            ps.setString(4, faculty.getQualification());
            ps.setInt(5, faculty.getExperience());
            ps.setString(6, faculty.getMobile());
            ps.setString(7, faculty.getEmail());

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
    
    public List<Faculty> getAllFaculty() {

        List<Faculty> list = new ArrayList<>();

        String sql = "SELECT * FROM faculty";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while(rs.next()){

                Faculty faculty = new Faculty();

                faculty.setFacultyId(rs.getInt("faculty_id"));
                faculty.setFacultyName(rs.getString("faculty_name"));
                faculty.setDepartment(rs.getString("department"));
                faculty.setQualification(rs.getString("qualification"));
                faculty.setExperience(rs.getInt("experience"));
                faculty.setMobile(rs.getString("mobile"));
                faculty.setEmail(rs.getString("email"));

                list.add(faculty);
            }

            rs.close();
            ps.close();
            con.close();

        }catch(Exception e){
            e.printStackTrace();
        }

        return list;
    }
    
    public Faculty getFacultyById(int id){

        Faculty faculty=null;

        String sql="SELECT * FROM faculty WHERE faculty_id=?";

        try{

            Connection con=DBConnection.getConnection();

            PreparedStatement ps=con.prepareStatement(sql);

            ps.setInt(1,id);

            ResultSet rs=ps.executeQuery();

            if(rs.next()){

                faculty=new Faculty();

                faculty.setFacultyId(rs.getInt("faculty_id"));
                faculty.setFacultyName(rs.getString("faculty_name"));
                faculty.setDepartment(rs.getString("department"));
                faculty.setQualification(rs.getString("qualification"));
                faculty.setExperience(rs.getInt("experience"));
                faculty.setMobile(rs.getString("mobile"));
                faculty.setEmail(rs.getString("email"));
            }

            rs.close();
            ps.close();
            con.close();

        }catch(Exception e){
            e.printStackTrace();
        }

        return faculty;
    }

    
    public boolean updateFaculty(Faculty faculty){

        boolean status=false;

        String sql="UPDATE faculty SET faculty_name=?, department=?, qualification=?, experience=?, mobile=?, email=? WHERE faculty_id=?";

        try{

            Connection con=DBConnection.getConnection();

            PreparedStatement ps=con.prepareStatement(sql);

            ps.setString(1, faculty.getFacultyName());
            ps.setString(2, faculty.getDepartment());
            ps.setString(3, faculty.getQualification());
            ps.setInt(4, faculty.getExperience());
            ps.setString(5, faculty.getMobile());
            ps.setString(6, faculty.getEmail());
            ps.setInt(7, faculty.getFacultyId());

            int result=ps.executeUpdate();

            if(result>0){
                status=true;
            }

            ps.close();
            con.close();

        }catch(Exception e){
            e.printStackTrace();
        }

        return status;
    }
    
    public boolean deleteFaculty(int id){

        boolean status = false;

        String sql = "DELETE FROM faculty WHERE faculty_id=?";

        try{

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, id);

            int result = ps.executeUpdate();

            if(result > 0){
                status = true;
            }

            ps.close();
            con.close();

        }catch(Exception e){
            e.printStackTrace();
        }

        return status;
    }
}