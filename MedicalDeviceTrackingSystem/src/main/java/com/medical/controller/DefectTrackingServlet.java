package com.medical.controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import com.medical.util.DBConnection;
import java.sql.*;

@WebServlet("/DefectTrackingServlet")
public class DefectTrackingServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String batchId = request.getParameter("batchId");
		String defectType = request.getParameter("defectType");
		String rootCause = request.getParameter("rootCause");
		String actionTaken = request.getParameter("actionTaken");

		try {

			Connection con = DBConnection.getConnection();

			PreparedStatement ps = con.prepareStatement(
			"INSERT INTO defect_tracking(batch_id, defect_type, root_cause, action_taken) VALUES(?,?,?,?)");

			ps.setString(1, batchId);
			ps.setString(2, defectType);
			ps.setString(3, rootCause);
			ps.setString(4, actionTaken);

			int result = ps.executeUpdate();

			if(result > 0){
				response.sendRedirect("dashboard.jsp");
			}else{
				response.getWriter().println("Error saving defect data");
			}

		} catch (Exception e) {
			response.getWriter().println("Error: " + e.getMessage());
		}
	}
}