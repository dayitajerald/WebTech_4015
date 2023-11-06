import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SpaceFactsServlet extends HttpServlet {
    private static final String[] spaceFacts = {
            "The Sun is so large that approximately 1.3 million Earths could fit inside it.",
            "There might be a giant diamond in space named 'Lucy' that is an estimated 10 billion trillion carats.",
            "The International Space Station travels at an average speed of 28,000 kilometers per hour.",
            "Venus is the hottest planet in our solar system with surface temperatures reaching about 462°C (864°F)."
    };

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h2>Space Facts</h2>");
        out.println("<p>" + getRandomSpaceFact() + "</p>");
        out.println("</body></html>");
    }

    private String getRandomSpaceFact() {
        int randomIndex = (int) (Math.random() * spaceFacts.length);
        return spaceFacts[randomIndex];
    }
}
