<%-- 
    Document   : formProduct
    Created on : Nov 26, 2019, 1:10:03 PM
    Author     : tasos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Form Product</title>
    </head>
    <body>
        <h1>New Product</h1>
        <form action="${pageContext.request.getContextPath()}/product/createProduct.jsp" method="post">
            Description: <input type="text" name="description">
            <br/>
            Price: <input type="text" name="price">
            <br/>
            <input type="submit" value="Submit">
        </form>
    </body>
</html>
