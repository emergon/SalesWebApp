<%-- 
    Document   : createProduct
    Created on : Nov 26, 2019, 1:49:02 PM
    Author     : tasos
--%>

<%@page import="service.ProductService"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create Product</title>
    </head>
    <body>
        <%
            String descr = request.getParameter("description");
            String price = request.getParameter("price");
            ProductService service = new ProductService();
            service.createProduct(descr, price);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/product/listProduct.jsp");
            request.setAttribute("message", "Product created successfully");
            dispatcher.forward(request, response);
            
        %>
    </body>
</html>
