<%-- 
    Document   : page
    Created on : Nov 26, 2019, 10:11:02 AM
    Author     : tasos
--%>
<%@page import="java.io.IOException"%>
<%@page import="java.time.LocalDate"%>
<%-- This is my comments --%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        
        <%= getAge()%>
        <%
            out.print("<br>Hello today");
        %>
        <br/>
        
        <%
            String name="Nick";
            age = 10;
            out.print("Hello "+ name+ ". My age is "+ age);
            printTime(out);
        %>
        <%! 
            private int age;
            public void printTime(JspWriter out) throws IOException{
                out.println("<br/>Date = "+LocalDate.now());
            }

            public int getAge(){
                return this.age;
            }
        %>
    </body>
</html>
