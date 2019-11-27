package servlet.salesman;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.SalesmanService;

@WebServlet(name = "DeleteSalesmanServlet", urlPatterns = {"/salesman/delete"})
public class DeleteSalesmanServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String scode = request.getParameter("id");
        SalesmanService service = new SalesmanService();
        boolean result = service.deleteSalesman(scode);
        if (result == true) {
            request.setAttribute("message", "Salesman deleted successfully");
        } else {
            request.setAttribute("message", "Salesman not deleted");
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("/listSalesman");
        dispatcher.forward(request, response);

    }

}
