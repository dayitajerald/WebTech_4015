import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class p12_db3 extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        Connection conn = null;
        Statement stmt = null;
        PrintWriter out = response.getWriter();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            // create a database connection using jdbc , port no used here is 3306
            // database name is college and username is root , there is no password
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/space_details", "root", "");
            stmt = conn.createStatement();
            PreparedStatement pstmt = conn.prepareStatement("insert into mission_details values(?, ?, ?,?,?,?)");
            pstmt.setInt(1, Integer.valueOf(request.getParameter("m_id")));
            pstmt.setString(2, request.getParameter("m_name"));
            pstmt.setString(3, request.getParameter("m_purpose"));
            pstmt.setString(4, request.getParameter("m_leader"));
            pstmt.setString(5, request.getParameter("m_details"));
            pstmt.setString(6, request.getParameter("m_date"));

            pstmt.executeUpdate();
            out.println("<html><body><p> Database Updated</p>");
            // select data from table where dept matches the value given by user in form
            String sql = "SELECT * FROM mission_details";
            pstmt = conn.prepareStatement(sql);
            // pstmt.setString(1, department);
            ResultSet rs = pstmt.executeQuery();
            // Extract data from result set
            while (rs.next()) {
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