<%-- 
    Document   : login
    Created on : Nov 27, 2019, 1:33:45 PM
    Author     : tasos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <div align="center">
            <c:if test="${username != null}">
                <ul>
                    <li>Username:${username}</li>
                    <li>Password:${password}</li>
                </ul>
            </c:if>
            <br/>
            <form action="${pageContext.request.getContextPath()}/login" method="post">
                <table>
                    <tr>
                        <td>Username:</td>
                        <td>
                            <input type="text" name="username">
                        </td>
                    </tr>
                    <tr>
                        <td>Password:</td>
                        <td>
                            <input type="password" name="password">
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <input type="submit" value="Login">
                        </td>
                    </tr>
                </table>
            </form>
        </div>
    </body>
</html>
