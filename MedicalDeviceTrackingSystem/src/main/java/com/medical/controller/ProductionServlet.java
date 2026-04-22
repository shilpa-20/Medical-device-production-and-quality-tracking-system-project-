package com.medical.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.medical.util.DBConnection;

@WebServlet("/ProductionServlet")
public class ProductionServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String productName = request.getParameter("productName");
        String batchNumber = request.getParameter("batchNumber");
        String productionDate = request.getParameter("productionDate");
        int quantity = Integer.parseInt(request.getParameter("quantity"));

        try {

            Connection con = DBConnection.getConnection();

            String query = "INSERT INTO production(product_name, batch_number, production_date, quantity) VALUES (?, ?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, productName);
            ps.setString(2, batchNumber);
            ps.setString(3, productionDate);
            ps.setInt(4, quantity);

            ps.executeUpdate();

            response.sendRedirect("production.jsp");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}