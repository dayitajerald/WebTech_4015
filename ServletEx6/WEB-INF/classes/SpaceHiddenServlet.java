import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SpaceHiddenServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Retrieve session information from hidden form fields
        String userLocation = request.getParameter("userLocation");
        String username = request.getParameter("username");
        String active = request.getParameter("userActive");

        // Perform session management actions here...
        // For instance, you can use these values to set or retrieve session attributes
        // HttpSession session = request.getSession();

        out.println("<html><body>");
        out.println("<h2>Space Session Details</h2>");
        out.println("<p>User's Location: " + userLocation + "</p>");
        out.println("<p>Username: " + username + "</p>");
        out.println("<p>Space Station Status: " + active + "</p>");
        out.println("</body></html>");
    }
}
