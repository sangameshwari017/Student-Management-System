package com.student.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.student.model.Department;
import com.student.util.DBConnection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDAO {

    public boolean addDepartment(Department department) {

        boolean status = false;

        String sql = "INSERT INTO department VALUES(?,?,?,?,?)";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, department.getDepartmentId());
            ps.setString(2, department.getDepartmentName());
            ps.setString(3, department.getHodName());
            ps.setInt(4, department.getTotalFaculty());
            ps.setInt(5, department.getTotalStudents());

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
    
    public List<Department> getAllDepartments() {

        List<Department> list = new ArrayList<>();

        String sql = "SELECT * FROM department";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Department department = new Department();

                department.setDepartmentId(rs.getInt("department_id"));
                department.setDepartmentName(rs.getString("department_name"));
                department.setHodName(rs.getString("hod_name"));
                department.setTotalFaculty(rs.getInt("total_faculty"));
                department.setTotalStudents(rs.getInt("total_students"));

                list.add(department);
            }

            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
    
    public Department getDepartmentById(int id){

        Department department = null;

        String sql = "SELECT * FROM department WHERE department_id=?";

        try{

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if(rs.next()){

                department = new Department();

                department.setDepartmentId(rs.getInt("department_id"));
                department.setDepartmentName(rs.getString("department_name"));
                department.setHodName(rs.getString("hod_name"));
                department.setTotalFaculty(rs.getInt("total_faculty"));
                department.setTotalStudents(rs.getInt("total_students"));

            }

            rs.close();
            ps.close();
            con.close();

        }catch(Exception e){
            e.printStackTrace();
        }

        return department;
    }
    
    public boolean updateDepartment(Department department){

        boolean status = false;

        String sql = "UPDATE department SET department_name=?, hod_name=?, total_faculty=?, total_students=? WHERE department_id=?";

        try{

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, department.getDepartmentName());
            ps.setString(2, department.getHodName());
            ps.setInt(3, department.getTotalFaculty());
            ps.setInt(4, department.getTotalStudents());
            ps.setInt(5, department.getDepartmentId());

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
    
    public boolean deleteDepartment(int id){

        boolean status = false;

        String sql = "DELETE FROM department WHERE department_id=?";

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