<%-- 
    Document   : listSalesman
    Created on : Nov 26, 2019, 4:44:06 PM
    Author     : tasos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List Salesman</title>
    </head>
    <body>
        <jsp:include page="/header.jsp"/>
        <h1>List of Salesmen</h1>
        <p>
            <a href="${pageContext.request.getContextPath()}/salesman/create">New Salesman</a>
        </p>
        <p>${message}</p>
        <table border="1">
            <tr>
                <th>Scode</th>
                <th>Name</th>
                <th>City</th>
                <th>Commission</th>
                <th colspan="2">Actions</th>
            </tr>
            <c:forEach  items="${listOfSalesman}" var="salesman">
                <tr>
                    <td>${salesman.scode}</td>
                    <td>${salesman.name}</td>
                    <td>${salesman.city}</td>
                    <td>${salesman.commission}</td>
                    <td>
                        <a href="${pageContext.request.getContextPath()}/salesman/view?id=${salesman.scode}">Details</a>
                    </td>
                    <td>
                        <a href="${pageContext.request.getContextPath()}/salesman/update?id=${salesman.scode}">Update</a>
                    </td>
                    <td>
                        <a href="${pageContext.request.getContextPath()}/salesman/delete?id=${salesman.scode}">Delete</a>
                    </td>
                    
                </tr>
            </c:forEach>
        </table>
        <%@include file="/footer.jsp" %>
    </body>
</html>
