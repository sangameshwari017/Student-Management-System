package com.student.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.student.model.Course;
import com.student.util.DBConnection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CourseDAO {

    public boolean addCourse(Course course) {

        boolean status = false;

        String sql = "INSERT INTO course(course_id,course_name,duration,trainer,fees) VALUES(?,?,?,?,?)";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, course.getCourseId());
            ps.setString(2, course.getCourseName());
            ps.setString(3, course.getDuration());
            ps.setString(4, course.getTrainer());
            ps.setDouble(5, course.getFees());

            int result = ps.executeUpdate();

            if(result > 0)
            {
                status = true;
            }

            ps.close();
            con.close();

        } catch(Exception e) {
            e.printStackTrace();
        }

        return status;
    }
    public List<Course> getAllCourses() {

        List<Course> list = new ArrayList<>();

        String sql = "SELECT * FROM course";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while(rs.next()) {

                Course course = new Course();

                course.setCourseId(rs.getInt("course_id"));
                course.setCourseName(rs.getString("course_name"));
                course.setDuration(rs.getString("duration"));
                course.setTrainer(rs.getString("trainer"));
                course.setFees(rs.getDouble("fees"));

                list.add(course);
            }

            rs.close();
            ps.close();
            con.close();

        } catch(Exception e) {
            e.printStackTrace();
        }

        return list;
    }
    
    public Course getCourseById(int id) {

        Course course = null;

        String sql = "SELECT * FROM course WHERE course_id=?";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if(rs.next()) {

                course = new Course();

                course.setCourseId(rs.getInt("course_id"));
                course.setCourseName(rs.getString("course_name"));
                course.setDuration(rs.getString("duration"));
                course.setTrainer(rs.getString("trainer"));
                course.setFees(rs.getDouble("fees"));
            }

            rs.close();
            ps.close();
            con.close();

        } catch(Exception e) {
            e.printStackTrace();
        }

        return course;
    }
    
    public boolean updateCourse(Course course) {

        boolean status = false;

        String sql = "UPDATE course SET course_name=?, duration=?, trainer=?, fees=? WHERE course_id=?";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, course.getCourseName());
            ps.setString(2, course.getDuration());
            ps.setString(3, course.getTrainer());
            ps.setDouble(4, course.getFees());
            ps.setInt(5, course.getCourseId());

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
    
    public boolean deleteCourse(int id){

        boolean status=false;

        String sql="DELETE FROM course WHERE course_id=?";

        try{

            Connection con=DBConnection.getConnection();

            PreparedStatement ps=con.prepareStatement(sql);

            ps.setInt(1,id);

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

}