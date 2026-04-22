package com.medical.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.medical.util.DBConnection;

@WebServlet("/QualityCheckServlet")
public class QualityCheckServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {

        	  String batch_id = request.getParameter("batch");
              String passedStr = request.getParameter("passed");
              String failedStr = request.getParameter("failed");

              int passed = Integer.parseInt(passedStr);
              int failed = Integer.parseInt(failedStr);

              Connection con = DBConnection.getConnection();

              String query = "INSERT INTO quality_check(batch_id, passed, failed) VALUES (?, ?, ?)";

              PreparedStatement ps = con.prepareStatement(query);

              ps.setString(1, batch_id);
              ps.setInt(2, passed);
              ps.setInt(3, failed);

              int result = ps.executeUpdate();

            if (result > 0) {
                out.println("Quality Check Saved Successfully");
            } else {
                out.println("Error Saving Data");
            }

        } catch (Exception e) {
            out.println("Error Occurred: " + e.getMessage());
        }
    }
}