<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Salesman</title>
    </head>
    <body>
        <h1>Edit Salesman</h1>
        <form action="${pageContext.request.getContextPath()}/salesman/update" method="post">
            Scode:<input type="text" name="scode" value="${salesman.scode}" readonly>
            <br/>
            Name: <input type="text" name="name" value="${salesman.name}">
            <br/>
            City: <input type="text" name="city" value="${salesman.city}">
            <br/>
            Commission: <input type="number" name="commission" step="0.01" value="${salesman.commission}">
            <br/>
            <input type="submit" value="Save">
        </form>
    </body>
</html>
