import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class LoginExam extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String candiname = request.getParameter("candiname");
        String password = request.getParameter("password");

        if (candiname.equals("student") && password.equals("12345")) {
            HttpSession session = request.getSession();
            session.setAttribute("candiname", candiname);
            response.sendRedirect("accessexam");
        } else {
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<html><head>");
            out.println("<link rel='stylesheet' href='styles.css' /> <title>Login Failed</title></head>");
            out.println("<body class='flex-col'><h2>Login Failed. Please try again.</h2>");
            out.println("<a href='index.html'>Back to Login</a>");
            out.println("</body></html>");
        }
    }
}
