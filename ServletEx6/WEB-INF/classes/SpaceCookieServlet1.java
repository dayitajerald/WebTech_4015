import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class SpaceCookieServlet1 extends HttpServlet {
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    try {
      response.setContentType("text/html");

      PrintWriter out = response.getWriter();
      out.println("<html><body>");
      out.println("<h2>Information on Space Station</h2>");

      String in_ustation = request.getParameter("ustation");
      String in_uname = request.getParameter("uname");

      Cookie userStation = new Cookie("UserStation", in_ustation);
      response.addCookie(userStation);
      Cookie userName = new Cookie("UserName", in_uname);
      response.addCookie(userName);

      out.println("<h3>Welcome:</h3>" + in_uname + " to your space station " + in_ustation);
      out.println("<br> Kindly click the following link to see information about your space station");
      out.println("<br> <a href='SpaceCookie2'>INFORMATION</a>");
      out.println("</body></html>");

      out.close();
    } catch (Exception exp) {
      System.out.println(exp);
    }
  }
}