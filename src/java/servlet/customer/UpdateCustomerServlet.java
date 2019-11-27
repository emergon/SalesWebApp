package servlet.customer;

import entities.Customer;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.CustomerService;

@WebServlet(name = "UpdateCustomerServlet", urlPatterns = {"/customer/update"})
public class UpdateCustomerServlet extends HttpServlet {

    
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int ccode = Integer.parseInt(req.getParameter("id"));
        CustomerService service = new CustomerService();
        Customer c = service.getCustomer(ccode);
        PrintWriter out = resp.getWriter();
        StringBuilder builder = new  StringBuilder();
        String path = req.getContextPath();
        builder.append("<html>")
                .append("<h3>Update Customer</h3>")
                .append("<form action='"+path+"/customer/update' method='post'>")
                .append("Ccode:").append("<input type='text' name='ccode' value='"+c.getCcode()+"' readonly>")
                .append("<br/>")
                .append("Name:").append("<input type='text' name='cname' value='"+c.getCname()+"'>")
                .append("<br/>")
                .append("<input type='submit' value='Submit'>")
                .append("</form>")
                .append("</html>");
        out.print(builder);
        
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int code = Integer.parseInt(req.getParameter("ccode"));
        String cname = req.getParameter("cname");
        CustomerService service = new CustomerService();
        service.updateCustomer(code, cname);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/listCustomer");
        dispatcher.forward(req, resp);
    }
    
}
