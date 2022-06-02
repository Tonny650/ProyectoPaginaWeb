<%@ page import="com.example.Login.Login" %><%--
  Created by IntelliJ IDEA.
  User: ancud
  Date: 01/06/2022
  Time: 09:12 a. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String Email = request.getParameter("Email");
    String Pass = request.getParameter("Pass");
    Login User = new Login();
    User.setEmail(Email);
    User.setPassword(Pass);
    String mensaje;

    if (User.ValidarUser() == true){
        request.getSession().setAttribute("id",User.getId());
        response.sendRedirect("ServletControlador?accion=home");
        mensaje = "True";
    }else if (User.ValidarUser() == false){
        mensaje = "False";
    }else {
        mensaje = "Error";

    }

%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1><%=mensaje%></h1>

</body>
</html>
