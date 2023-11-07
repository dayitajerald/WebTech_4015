import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.*;
import javax.servlet.http.*;


public class SpaceSessionInfoServlet2 extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String contextPath = request.getContextPath();

        HttpSession session=request.getSession(false);  
        String astronaut_name = (String)session.getAttribute("astronautName"); 
        String mission_name =  (String)session.getAttribute("missionName");
        
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
