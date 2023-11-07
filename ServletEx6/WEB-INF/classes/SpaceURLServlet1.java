import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class SpaceURLServlet1 extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            String n = request.getParameter("planet");
            out.print("Do you want to know more about " + n + " click below");
            // appending the username in the query string
            out.print("<a href='https://science.nasa.gov/" + n + "'>Read more on the planet</a>");
            out.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}