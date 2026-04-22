package com.medical.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.medical.util.DBConnection;

@WebServlet("/ReportServlet")
public class ReportServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        try {

            Connection con = DBConnection.getConnection();
            Statement st = con.createStatement();

            // Total Production
            ResultSet rs1 = st.executeQuery("SELECT SUM(quantity) FROM production");
            rs1.next();
            int totalProduction = rs1.getInt(1);

            ResultSet rs2 = st.executeQuery("SELECT COUNT(*) FROM defect_tracking");
            rs2.next();
            int totalDefects = rs2.getInt(1);

            int passedUnits = totalProduction - totalDefects;

            double defectPercentage = 0;

            if (totalProduction > 0) {
                defectPercentage = ((double) totalDefects / totalProduction) * 100;
            }

            // HTML Output
            out.println("<html>");
            out.println("<head><title>Production Report</title></head>");
            out.println("<body>");

            out.println("<h2>Production Quality Report</h2>");

            out.println("<table border='1' cellpadding='10'>");

            out.println("<tr><th>Total Production</th><td>" + totalProduction + "</td></tr>");
            out.println("<tr><th>Total Passed Units</th><td>" + passedUnits + "</td></tr>");
            out.println("<tr><th>Total Defects</th><td>" + totalDefects + "</td></tr>");
            out.println("<tr><th>Defect Percentage</th><td>" + defectPercentage + "%</td></tr>");

            out.println("</table>");

            out.println("<br><a href='dashboard.jsp'>Back to Dashboard</a>");

            out.println("</body>");
            out.println("</html>");

        } catch (Exception e) {

            e.printStackTrace();
            out.println("<h3>Error generating report</h3>");

        }
    }
}