package servlet.salesman;

import entities.Salesman;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.SalesmanService;

@WebServlet(name = "ListSalesmanServlet", urlPatterns = {"/listSalesman"})
public class ListSalesmanServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        SalesmanService service = new SalesmanService();
        List<Salesman> listOfSalesman = service.getSalesmen();
        request.setAttribute("listOfSalesman", listOfSalesman);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/salesman/listSalesman.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //doGet(request, response);
        response.sendRedirect(request.getContextPath()+"/listSalesman");
    }

    
}
