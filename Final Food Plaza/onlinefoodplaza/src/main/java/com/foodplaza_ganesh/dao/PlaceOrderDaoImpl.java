package com.foodplaza_ganesh.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.foodplaza_ganesh.pojo.PlaceOrder;
import com.foodplaza_ganesh.utility.DbUtility;

public class PlaceOrderDaoImpl implements PlaceOrderDao {
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    String sql;
    int row;

    @Override
    public PlaceOrder placeorder(String email) {
        String date = new Date().toString();
        String totalprice = null;
        PlaceOrder placeorder = null;

        try {
            con = DbUtility.getConnect();
            sql = "select sum(totalprice) as total from placeorder where email=?";
            ps = con.prepareStatement(sql);
            ps.setString(1, email);
            rs = ps.executeQuery();

            if (rs.next()) {
                totalprice = rs.getString("total");
            }

            if (totalprice != null && !totalprice.isEmpty()) { // Check if the totalprice is not null and not empty
                sql = "insert into placeorder(email, date, totalprice) values(?, ?, ?)";
                ps = con.prepareStatement(sql);
                ps.setString(1, email);
                ps.setString(2, date);
                ps.setString(3, totalprice);
                row = ps.executeUpdate();

                if (row > 0) {
                    sql = "select * from placeorder where email=? and date=? ";
                    ps = con.prepareStatement(sql);
                    ps.setString(1, email);
                    ps.setString(2, date);
                    rs = ps.executeQuery();

                    if (rs.next()) {
                        placeorder = new PlaceOrder();
                        placeorder.setId(rs.getInt("id"));
                        placeorder.setEmail(rs.getString("email"));
                        placeorder.setDate(rs.getString("date"));
                        placeorder.setTotalprice(rs.getString("totalprice"));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } 

        return placeorder;
    }

    @Override
    public List<PlaceOrder> showorder() {
        List<PlaceOrder> po = new ArrayList<>();

        try {
            con = DbUtility.getConnect();
            sql = "select * from placeorder;";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                PlaceOrder placeorder = new PlaceOrder();
                placeorder.setId(rs.getInt("id"));
                placeorder.setEmail(rs.getString("email"));
                placeorder.setDate(rs.getString("date"));
                placeorder.setTotalprice(rs.getString("totalprice"));
                po.add(placeorder); // Add the PlaceOrder object to the list
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } 

        return po;
    }

    public static void main(String[] args) {
        PlaceOrderDaoImpl op = new PlaceOrderDaoImpl();
        PlaceOrder po1 = op.placeorder("rugved@gmail.com");
        System.out.println(po1);
    }
}
