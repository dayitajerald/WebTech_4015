import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class p12_db2 extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        Connection conn = null;
        Statement stmt = null;
        PrintWriter out = response.getWriter();
        String purpose = request.getParameter("purpose");
        try {
            Class.forName("com.mysql.jdbc.Driver");
            // create a database connection using jdbc , port no used here is 3306
            // database name is college and username is root , there is no password
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/space_details", "root", "");
            stmt = conn.createStatement();
            String sql;
            // select data from table where dept matches the value given by user in form
            sql = "SELECT * FROM mission_details where mission_purpose = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, purpose);
            ResultSet rs = pstmt.executeQuery();
            out.println("<h3> Mission Details for the purpose:" + purpose + "</h3>");
            // Extract data from result set
            while (rs.next()) {
                // Retrieve by column name
                int m_id = rs.getInt("mission_id");
                String m_name = rs.getString("mission_name");
                String m_leader = rs.getString("mission_leader");
                String m_details = rs.getString("mission_details");
                String m_date = rs.getString("mission_date");

                // Display values
                out.println("<p> Mission ID: " + m_id + "<br>");
                out.println("Mission Name: " + m_name + "<br>");
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