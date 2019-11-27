package servlet.customer;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.CustomerService;

@WebServlet(name = "CreateCustomerServlet", urlPatterns = {"/customer/create"})
public class CreateCustomerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        StringBuilder builder = new  StringBuilder();
        String path = req.getContextPath();
        builder.append("<html>")
                .append("<h3>New Customer</h3>")
                .append("<form action='"+path+"/customer/create' method='post'>")
                .append("Name:").append("<input type='text' name='cname'>")
                .append("<br/>")
                .append("<input type='submit' value='Submit'>")
                .append("</form>")
                .append("</html>");
        out.print(builder);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String cname = req.getParameter("cname");
        CustomerService service = new CustomerService();
        boolean result = service.createCustomer(cname);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/listCustomer");
        dispatcher.forward(req, resp);
    }
    
    

    

}
