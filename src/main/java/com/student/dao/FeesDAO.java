package com.student.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.student.model.Fees;
import com.student.util.DBConnection;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
public class FeesDAO {

    public boolean addFees(Fees fees) {

        boolean status = false;

        String sql = "INSERT INTO fees VALUES(?,?,?,?,?,?)";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, fees.getFeeId());
            ps.setInt(2, fees.getStudentId());
            ps.setString(3, fees.getStudentName());
            ps.setDouble(4, fees.getAmount());
            ps.setString(5, fees.getPaymentDate());
            ps.setString(6, fees.getPaymentStatus());

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
    
    public List<Fees> getAllFees() {

        List<Fees> list = new ArrayList<>();

        String sql = "SELECT * FROM fees";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Fees fees = new Fees();

                fees.setFeeId(rs.getInt("fee_id"));
                fees.setStudentId(rs.getInt("student_id"));
                fees.setStudentName(rs.getString("student_name"));
                fees.setAmount(rs.getDouble("amount"));
                fees.setPaymentDate(rs.getString("payment_date"));
                fees.setPaymentStatus(rs.getString("payment_status"));

                list.add(fees);
            }

            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
    
    public Fees getFeesById(int feeId) {

        Fees fees = null;

        String sql = "SELECT * FROM fees WHERE fee_id=?";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, feeId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                fees = new Fees();

                fees.setFeeId(rs.getInt("fee_id"));
                fees.setStudentId(rs.getInt("student_id"));
                fees.setStudentName(rs.getString("student_name"));
                fees.setAmount(rs.getDouble("amount"));
                fees.setPaymentDate(rs.getString("payment_date"));
                fees.setPaymentStatus(rs.getString("payment_status"));
            }

            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return fees;
    }
    
    public boolean updateFees(Fees fees) {

        boolean status = false;

        String sql = "UPDATE fees SET student_id=?, student_name=?, amount=?, payment_date=?, payment_status=? WHERE fee_id=?";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, fees.getStudentId());
            ps.setString(2, fees.getStudentName());
            ps.setDouble(3, fees.getAmount());
            ps.setString(4, fees.getPaymentDate());
            ps.setString(5, fees.getPaymentStatus());
            ps.setInt(6, fees.getFeeId());

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
    
    
    public boolean deleteFees(int feeId) {

        boolean status = false;

        String sql = "DELETE FROM fees WHERE fee_id=?";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, feeId);

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
