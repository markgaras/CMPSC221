<%-- 
    Document   : JSP1
    Created on : Apr 3, 2021, 8:50:06 PM
    Author     : mark b garas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Lab 1</title>
    </head>
    <body>
        <h1>First JSP Lab</h1>
        
        <form action="JSP1.jsp" method="get">
            <label for="name">Name: </label><br />
            <input type="text" id="name" name="name" /><br />
            <label for="salary">Yearly Salary: </label><br>
            <input type="text" id="salary" name="salary" /><br /><br />
            <input type="submit" value="Submit">
        </form>
        
        <h1>
            <%
                String name = request.getParameter("name");
                int yearlySalary = 0;
                if (!request.getParameter("salary").equals("")) {
                    yearlySalary = Integer.parseInt(request.getParameter("salary"));
                }
                int monthlySalary = yearlySalary / 12;
                out.println("Hello " + name + ", your calculated monthly salary" +
                         " was $" + monthlySalary + ".");
            %>
        </h1>
        
    </body>
</html>