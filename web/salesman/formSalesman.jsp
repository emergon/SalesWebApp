<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create Salesman</title>
    </head>
    <body>
        <jsp:include page="/header.jsp"/>
        
        <h1>New Salesman</h1>
        <form action="${pageContext.request.getContextPath()}/salesman/create" method="post">
            Name: <input type="text" name="name">
            <br/>
            City: <input type="text" name="city">
            <br/>
            Commission: <input type="number" name="commission" step="0.01">
            <br/>
            <input type="submit" value="Save">
        </form>
            <%@include file="/footer.jsp" %>
    </body>
</html>
