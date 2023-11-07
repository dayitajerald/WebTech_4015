import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.*;
import javax.servlet.http.*;


public class SpaceLoginServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String contextPath = request.getContextPath();

        out.println("<html><head><title>Space Mission Assigned</title>");
        out.println("<link rel='stylesheet' type='text/css' href='" + contextPath + "/resources/css/space_login.css'>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h2>Space Mission Assigned</h2>");
        out.println("<form action='SpaceSessionInfoServlet'>");
        out.println("<label for='astronautName'>Enter Astronaut's Name:</label>");
        out.println("<input type='text' id='astronautName' name='astronautName' required><br><br>");
        out.println("<label for='mission'>Enter Mission:</label>");
        out.println("<input type='text' id='mission' name='mission' required><br><br>");
        out.println("<input type='submit' value='Login'>");
        out.println("</form>");
        out.println("</body></html>");
    }
}

