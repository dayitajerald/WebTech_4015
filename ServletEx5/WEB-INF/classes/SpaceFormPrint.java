import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SpaceFormPrint extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Retrieve form data
        String astronautName = request.getParameter("name");
        String missionName = request.getParameter("mission");

        // Generate printable form with typing effect for astronautName and missionName
        out.println("<html><head><style>"
                + "body { background-color: #000; color: #fff; font-family: 'Arial', sans-serif; } "
                + ".typing-effect { display: inline-block; white-space: nowrap; overflow: hidden; border-right: .15em solid white; }"
                + "@keyframes typing { from { width: 0 } to { width: 100% } }"
                + "</style><script>"
                + "document.addEventListener('DOMContentLoaded', function() {"
                + "    typeText('name', '" + astronautName + "');"
                + "    typeText('mission', '" + missionName + "');"
                + "});"
                + "function typeText(id, text) {"
                + "    var element = document.getElementById(id);"
                + "    var i = 0;"
                + "    function type() {"
                + "        if (i < text.length) {"
                + "            element.innerHTML += text.charAt(i);"
                + "            i++;"
                + "            setTimeout(type, 100);"
                + "        }"
                + "    }"
                + "    type();"
                + "}"
                + "</script></head><body>");

        out.println("<h2>Space Mission Details</h2>");
        out.println("<p>Astronaut's Name: <span id='name' class='typing-effect'></span></p>");
        out.println("<p>Mission Name: <span id='mission' class='typing-effect'></span></p>");

        // Rest of the form content...

        out.println("</body></html>");
    }
}
