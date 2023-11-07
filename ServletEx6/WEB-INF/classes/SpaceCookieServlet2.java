/* TO RECEIVE COOKIES THAT IS ALREADY SET*/
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class SpaceCookieServlet2 extends HttpServlet {
   public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
   {
     try{
        response.setContentType("text/html");
        PrintWriter pwriter = response.getWriter();
        Cookie[] ck=request.getCookies();
        int len=ck.length;
        String value;      
        pwriter.println("<h3>Hello - </h3>");
        for(int i=0;i<len;i++)
        {
            value=ck[i].getValue();
            if(i==1){pwriter.println("Space Station:" + value);}
            else{pwriter.println("<br> UserName:"+value);}
        }
        pwriter.print("<h3>Important Information</h3>");
        pwriter.print("<h4>Dont forget your username and station</h4>");
        pwriter.print("<h4>Get a change of station every 3 months</h4>");
        pwriter.print("<h4>Dont share personal information about your station</h4>");
        pwriter.close();
    }
     catch(Exception exp){
       System.out.println(exp);
     }
  }
}