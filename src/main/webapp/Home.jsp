<%@ page import="com.example.modelo.UserData" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    UserData user = new UserData();
    if (request.getSession().getAttribute("id") == null){
        response.sendRedirect("Login.jsp");
    }
    String Name_id = (String) request.getSession().getAttribute("id");
    String Name = user.getNameIcon(Name_id);
%>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css" >
    <link href="Recursos_Jsp/css/Style.css" rel="stylesheet" type="text/css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <a class="navbar-brand" href="#" style="color: white">This.Name<span style="color: #D3B717FF;">(Ck-SO);</span></a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="ServletControlador?accion=home" methods="doGet">Home <span class="sr-only">(current)</span></a>
            </li>

            <li class="nav-item">
                <a class="nav-link" href="ServletControlador?accion=Carrito" tabindex="-1" aria-disabled="true">
                    <i class="fas fa-shopping-cart"><label style="color: red">${contador}</label></i>
                </a>
            </li>
        </ul>
        <form class="navbar-nav mr-auto">
            <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
        </form>
        <ul class="navbar-nav">
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    <i class="fas fa-user-alt"> <%=Name%></i>
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                    <a class="dropdown-item" href="#"><i class="fas fa-user-lock"> </i>  User</a>
                    <a class="dropdown-item" href="#"><i class="fas fa-cart-plus"> </i>  My shopping</a>
                    <div class="dropdown-divider"></div>
                    <a class="dropdown-item" href="#"><i class="fas fa-lock-open"> </i>  Login</a>
                    <div class="dropdown-divider"></div>
                    <a class="dropdown-item" href="Login.jsp"><i class="fas fa-lock"> </i>  Sign off</a>
                </div>
            </li>
        </ul>
    </div>
</nav>
<div class="container mt-2">
    <div class="row">
        <c:forEach var="p" items="${productos}">
            <br><br>
            <div class="col-sm-4">
                <div class="card">
                    <div class="card-header">
                        <label>${p.getNombres()}</label>
                    </div>
                    <div class="card-body">

                        <img src="${p.getFoto()}"  style="width:200px; height: auto" >
                        <br>
                        <i>Precio: ${p.getPrecio()}</i>
                        <br>
                        <i>Cantidad: ${p.getStock()}</i>
                    </div>
                    <div class="card-footer text-center">
                        <label>Descripcion:${p.getDescripcion()}</label>
                        <div>
                            <a href="ServletControlador?accion=AgragarCarrito&id=${p.getId()}"  class="btn btn-outline-info">Agregar</a>
                            <a href="ServletControlador?accion=comprar&id=${p.getId()}" class=" btn btn-danger">Comprar</a>
                        </div>
                    </div>
                </div>
                <br><br>
            </div>
        </c:forEach>

    </div>
</div>


<!--<a href="hello-servlet?accion=hola">Hello Servlet</a>-->
</body>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</html>
