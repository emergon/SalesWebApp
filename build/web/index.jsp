<%-- 
    Document   : index
    Created on : Nov 27, 2019, 2:49:33 PM
    Author     : tasos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:include page="/header.jsp"/>
        <div align="center">
            <h3>Web App</h3>
            <a href="general">Generic Servlet</a>
            <br/>
            <a href="listCustomer">Customer</a>
            <br/>
            <a href="jsp/page.jsp">Jsp page</a>
            <br/>
            <a href="product/listProduct.jsp">Products</a>
            <br/>
            <a href="listSalesman">Salesmen</a>
        </div>
        <jsp:include page="/footer.jsp"/>
    </body>
</html>
