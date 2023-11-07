import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.*;
import javax.servlet.http.*;


public class SpaceSessionInfoServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String contextPath = request.getContextPath();

        String astronaut_name = request.getParameter("astronautName");
        String mission_name = request.getParameter("mission");

        HttpSession session = request.getSession();  
        session.setAttribute("astronautName",astronaut_name);  
        session.setAttribute("missionName",mission_name);

        out.println("<html><head><title>Space Mission Details</title>");
        out.println("<link rel='stylesheet' type='text/css' href='" + contextPath + "/resources/css/space_session_info.css'>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h2>Space Mission Details</h2>");
        out.println("<p>Information about the space mission will appear here.</p>");
        out.println("<p>"+ astronaut_name +" is on the mission "+ mission_name+"</p>");
        out.println("</body></html>");
    }
}
