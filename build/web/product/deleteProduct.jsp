<%-- 
    Document   : deleteProduct
    Created on : Nov 26, 2019, 3:16:56 PM
    Author     : tasos
--%>

<%@page import="service.ProductService"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            String id = request.getParameter("id");
            ProductService service = new ProductService();
            service.deleteProduct(id);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/product/listProduct.jsp");
            request.setAttribute("message", "Product deleted successfully");
            dispatcher.forward(request, response);
            
        %>
    </body>
</html>
