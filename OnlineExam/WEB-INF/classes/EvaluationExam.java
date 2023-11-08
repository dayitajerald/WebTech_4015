import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class EvaluationExam extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String answer1 = request.getParameter("answer1");
        String answer2 = request.getParameter("answer2");
        String answer3 = request.getParameter("answer3");
        String answer4 = request.getParameter("answer4");
        String answer5 = request.getParameter("answer5");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/onlineexam", "root", "");
            if (conn != null) {
                out.println("<h2> No issues in Connection</h2>");
            }
            stmt = conn.createStatement();
            String sql;
            // Fetch all the answers
            sql = "SELECT * FROM exam";
            ResultSet rs = stmt.executeQuery(sql);
            // Extract all the answers from the result set
            String[] ans = new String[5];
            int i = 0;
            while (rs.next()) {
                ans[i] = rs.getString("Answer");
                i = i + 1;
            }

            String correctAnswer1 = ans[0];
            String correctAnswer2 = ans[1];
            String correctAnswer3 = ans[2];
            String correctAnswer4 = ans[3];
            String correctAnswer5 = ans[4];

            int score = 0;
            if (answer1.equals(correctAnswer1)) {
                score += 20;
            }
            if (answer2.equals(correctAnswer2)) {
                score += 20;
            }
            if (answer3.equals(correctAnswer3)) {
                score += 20;
            }
            if (answer4.equals(correctAnswer4)) {
                score += 20;
            }
            if (answer5.equals(correctAnswer5)) {
                score += 20;
            }

            // Store the total score in the session for display
            HttpSession session = request.getSession();
            session.setAttribute("score", score);

            // Display the total score
            out.println("<html><head>");
            out.println("<link rel='stylesheet' href='style.css' /> <title>Exam Results</title></head>");
            out.println("<body class='flex-col'><h1>Space Exam Results</h1><h2>Your Score: " + score + "</h2>");
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
