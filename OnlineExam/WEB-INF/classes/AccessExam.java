import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.Connection;

public class AccessExam extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String candiname = (String) session.getAttribute("candiname");

        if (candiname == null) {
            response.sendRedirect("login.html");
        } else {
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            Connection conn = null;
            Statement stmt = null;

            try {
                Class.forName("com.mysql.jdbc.Driver");
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/onlineexam", "root", "");
                out.println("<html><head>");
                out.println("<link rel='stylesheet' href='styles.css' /> <title>Access Exam</title></head>");
                out.println(
                        "<body class='flex-col'><h1>Welcome " + candiname + " to the Space Exam!</h1>");
                if (conn != null) {
                    out.println("<h2> No issues in Connection</h2>");
                }
                stmt = conn.createStatement();
                String sql;
                // Fetch all the questions
                sql = "SELECT * FROM exam";
                ResultSet rs = stmt.executeQuery(sql);

                out.println("<form class='flex-col' action='evaluationexam' method='post'>");
                // Extract all the questions from the result set
                String[] Qns = new String[5];
                int i = 0;
                while (rs.next()) {
                    Qns[i] = rs.getString("Question");
                    i = i + 1;
                }
                out.println("Question 1: " + Qns[0]);
                out.println("<input type='text' name='answer1'>");
                out.println("Question 2: " + Qns[1]);
                out.println("<input type='text' name='answer2'>");
                out.println("Question 3: " + Qns[2]);
                out.println("<input type='text' name='answer3'>");
                out.println("Question 4: " + Qns[3]);
                out.println("<input type='text' name='answer4'>");
                out.println("Question 5: " + Qns[4]);
                out.println("<input type='text' name='answer5'>");
                out.println("<input type='submit' value='Evaluate'>");
                out.println("</form>");
                out.println("</body></html>");
                // Clean-up environment
                rs.close();
                stmt.close();
                conn.close();
            } catch (Exception e) {
                System.out.print("Could not connect to DB - Error:" + e);
            }
        }
    }
}
