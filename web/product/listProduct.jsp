<%-- 
    Document   : listProduct
    Created on : Nov 26, 2019, 11:47:03 AM
    Author     : tasos
--%>
<%@page import="java.util.List"%>
<%@page import="service.ProductService, entities.Product"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="service" class="service.ProductService" scope="request"/>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div align="center">
            <h1>List of Products</h1>
            <a href="${pageContext.request.getContextPath()}/product/formProduct.jsp">Create Product</a>
            
            <c:if test="${message != null}">
                <p>${message}</p>
            </c:if>
            
            <table border="1">
                <tr>
                    <th>Pcode</th>
                    <th>Description</th>
                    <th>Price</th>
                    <th colspan="2">Actions</th>
                </tr>
                <c:forEach items="${service.fereMyProducts()}" var="product">
                    <tr>
                        <td>${product.pcode}</td>
                        <td>${product.description}</td>
                        <td>${product.price}</td>
                        <td>
                            <a href="#">Update</a>
                        </td>
                        <td>
                            <a href="javascript:confirmDelete(${product.pcode})">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
        <br/>
        <br/>
        <h3>Products with only scriptlets</h3>
        <table border="1">
            <tr>
                <th>Pcode</th>
                <th>Description</th>
                <th>Price</th>
                    <%

                        ProductService serv = new ProductService();
                        List<Product> list = serv.fereMyProducts();
                        for (Product p : list) {
                    %>
            <tr>
                <td><% out.print(p.getPcode());%></td>
                <td><%= p.getDescription()%></td>
                <td><%= p.getPrice()%></td>
            </tr>       
            <%    }
            %>
        </tr>

    </table>
        <script>
            function confirmDelete(productId){
                if(confirm('Are you sure you want to delete the product with ID:'+productId+'?')){
                    window.location = '${pageContext.request.getContextPath()}/product/deleteProduct.jsp?id='+productId;
                }
            }
        </script>
</body>
</html>
