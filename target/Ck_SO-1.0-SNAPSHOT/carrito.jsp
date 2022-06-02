<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ancud
  Date: 29/05/2022
  Time: 02:04 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
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
                <a class="nav-link" href="ServletControlador?accion=home" tabindex="-1" aria-disabled="true">
                    <i class="fas fa-shopping-cart"><label style="color: red">${contador}</label></i>Seguir Comprando
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
                    <i class="fas fa-user-alt"> <%="Antonio"%></i>
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
<div class="container mt-4">
    <h3>Carrito-Cookies</h3>
    <br>
    <div class="row">
        <div style="margin-right: 20px">
            <div class="col-sm-8">
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th>Item</th>
                        <th>Nombre</th>
                        <th>Descripcion</th>
                        <th>Precio</th>
                        <th>Cantidad</th>
                        <th>SubTotal</th>
                        <th>Actiones</th>

                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="car" items="${Carrito}">
                        <tr>
                            <td>${car.getItem()}</td>
                            <td>${car.getNombres()}</td>
                            <td>${car.getDescripcion()}</td>
                            <td>${car.getPrecioCompra()}</td>
                            <td>${car.getCantidad()}</td>
                            <td>${car.getSubTotal()}</td>
                            <td>
                                <input type="hidden" id="idp" value="${car.getIdProducto()}">
                                <a href="ServletControlador?accion=Delete&idProducto=${car.getIdProducto()}" id="btnDelete">eliminar</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
        </div>
        <div style="margin-left: 20px">
            <div class="col-sm-4" >
            <div class="card">
                <div class="card-header">
                    <h3>Generar compra</h3>
                </div>
                <div class="card-body">
                    <label>SubTotal:</label>
                    <input type="text" value="$.${totalApagar}.0 " readonly class="from-control">
                    <label>Descuento:</label>
                    <input type="text" value="$.0.00" readonly class="from-control">
                    <label>Total a pagar:</label>
                    <input type="text" value="${totalApagar}" readonly class="from-control">
                </div>
                <div class="card-footer">
                    <a href="#" class="btn btn-info btn-block">Realizar Pago</a>
                    <a href="ServletControlador?accion=GenerarCompra" class="btn btn-danger btn-block">Generar compra</a>
                </div>
            </div>
        </div>
        </div>
    </div>
</div>
</body>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
    <script src="Recursos_Jsp/js/funciones.js" type="application/javascript"></script>
</html>
