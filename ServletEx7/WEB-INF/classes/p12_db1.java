import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

public class p12_db1 extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        Connection conn = null;
        Statement stmt = null;
        PrintWriter out = response.getWriter();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            // out.println("<h1> into class</h1>");
            // create a database connection using jdbc , port no used here is 3306
            // database name is college and username is root , there is no password
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/space_details", "root", "");
            if (conn != null) {
                System.out.print("Connection Successful");
            }
            stmt = conn.createStatement();
            String sql;
            // display all the students' marks
            sql = "SELECT * FROM mission_details";
            ResultSet rs = stmt.executeQuery(sql);
            // Extract data from result set
            while (rs.next()) {
                // out.println("<h1> into while loop</h1>");
                // Retrieve by column name
                int m_id = rs.getInt("mission_id");
                String m_name = rs.getString("mission_name");
                String m_purpose = rs.getString("mission_purpose");
                String m_leader = rs.getString("mission_leader");
                String m_details = rs.getString("mission_details");
                String m_date = rs.getString("mission_date");

                // Display values
                out.println("<p> Mission ID: " + m_id + "<br>");
                out.println("Mission Name: " + m_name + "<br>");
                out.println("Mission Purpose: " + m_purpose + "<br>");
                out.println("Mission Leader: " + m_leader + "<br>");
                out.println("Mission Details: " + m_details + "<br></p>");
                out.println("Mission Date: " + m_date + "<br></p>");

            }
            out.println("</body></html>");
            // Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            System.out.print("Do not connect to DB - Error:" + e);
        }
    }
}
