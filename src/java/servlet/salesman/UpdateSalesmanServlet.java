package servlet.salesman;

import entities.Salesman;
import java.io.IOException;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.SalesmanService;

@WebServlet(name = "UpdateSalesmanServlet", urlPatterns = {"/salesman/update"})
public class UpdateSalesmanServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("id");
        SalesmanService service = new SalesmanService();
        Salesman s = service.getSalesman(id);
        request.setAttribute("salesman", s);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/salesman/formSalesman2.jsp");
        dispatcher.forward(request, response);
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Map<String, String[]> map = request.getParameterMap();
        SalesmanService service = new SalesmanService();
        service.updateSalesman(map);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/listSalesman");
        dispatcher.forward(request, response);
    }

}
