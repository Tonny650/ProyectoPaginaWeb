<%--
  Created by IntelliJ IDEA.
  User: ancud
  Date: 01/06/2022
  Time: 08:20 a. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Ck-SO - Login</title>
    <meta name="viewport" content="width=device-width, user-scalable=yes, initial-scale=1.0, maximum-scale=3.0, minimum-scale=1.0">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css" >
    <link rel="stylesheet" href="Recursos_Jsp/css/estilos.css">


</head>
<body>
<form class="formulario" action="ServletLogin" method="post">

    <h1>Login</h1>
    <div class="contenedor">



        <div class="input-contenedor">
            <i class="fas fa-envelope icon"></i>
            <input type="text" placeholder="Correo Electronico" name="Email">

        </div>

        <div class="input-contenedor">
            <i class="fas fa-key icon"></i>
            <input type="password" placeholder="Contraseña" name="Pass">

        </div>
        <input type="submit" value="Login" class="button">
        <p>Al registrarte, aceptas nuestras Condiciones de uso y Política de privacidad.</p>
        <p>¿No tienes una cuenta? <a class="link" href="Registrar.jsp">Registrate </a></p>
    </div>
</form>
</body>
</html>
