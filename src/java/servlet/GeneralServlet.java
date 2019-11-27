package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GeneralServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        List<String> list = new ArrayList();
        list.add("John");
        list.add("Jack");
        list.add("Mary");
        
        out.print("<html>");
        out.print("<h3>");
        out.print("Name");
        out.print("</h3>");
        String name = "Nick";
        out.print("<p>");
        out.print(name);
        out.print("</p>");
        out.print("<table border='1'>");
        for(String n:list){
            out.print("<tr>");
            out.print("<td>");
            out.print(n);
            out.print("</td>");
            out.print("</tr>");
        }
        out.print("</table>");
        
        out.print("</html>");
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

}
