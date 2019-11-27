package servlet.customer;

import entities.Customer;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.CustomerService;

public class ListCustomerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        CustomerService service = new CustomerService();
        List<Customer> list = service.getCustomers();
        String path = req.getContextPath();
        StringBuilder builder = new StringBuilder();
        builder.append("<html>")
                .append("<h3>List of Customer</h3>")
                .append("<a href='"+path+"/customer/create'>Create Customer</a>")
                .append("<table border='1'>")
                .append("<tr>")
                .append("<th>Ccode</th>").append("<th>Cname</th>")
                .append("<th colspan='2'>Actions</th>")
                .append("</tr>");
        for (Customer c : list) {
            builder.append("<tr>")
                    .append("<td>").append(c.getCcode()).append("</td>")
                    .append("<td>").append(c.getCname()).append("</td>")
                    .append("<td>").append("<a href='"+path+"/customer/update?id="+c.getCcode()+"'>Update</a>").append("</td>")
                    .append("<td>").append("<a href='"+path+"/customer/delete?id="+c.getCcode()+"'>Delete</a>").append("</td>")
                    .append("</tr>");
        }
        builder.append("</table>")
                .append("</html>");
        out.print(builder);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
    
    

}
