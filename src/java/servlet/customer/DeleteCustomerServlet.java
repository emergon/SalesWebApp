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

@WebServlet(name = "DeleteCustomerServlet", urlPatterns = {"/customer/delete"})
public class DeleteCustomerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        CustomerService service = new CustomerService();
        service.deleteCustomer(id);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/listCustomer");
        dispatcher.forward(req, resp);
    }
    
}
