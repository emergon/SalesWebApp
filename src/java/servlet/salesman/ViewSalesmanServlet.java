package servlet.salesman;

import entities.Family;
import entities.Salesman;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.SalesmanService;

@WebServlet(name = "ViewSalesmanServlet", urlPatterns = {"/salesman/view"})
public class ViewSalesmanServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            SalesmanService service = new SalesmanService();
            String scode = request.getParameter("id");
            Salesman s = service.getSalesman(scode);
            List<Family> listOfFamily = service.getFamilyBySalesman(scode);
            request.setAttribute("salesman", s);
            request.setAttribute("listOfFamily", listOfFamily);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/salesman/viewSalesman.jsp");
            dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.getWriter().print("Hello from doPost viewSalesmanServlet");
    }
}
