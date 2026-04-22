package com.medical.controller;

import java.io.IOException;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.medical.util.DBConnection;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		try {
			Connection con = DBConnection.getConnection();

			PreparedStatement ps = con.prepareStatement("SELECT * FROM users WHERE username=? AND password=?");

			ps.setString(1, username);
			ps.setString(2, password);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {

				HttpSession session = request.getSession();
				session.setAttribute("username", username);

				response.sendRedirect(request.getContextPath() + "/dashboard.jsp");
			} else {
				response.getWriter().println("Invalid Username or Password");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}