package com.example.controlador;

import com.example.Login.Registrar;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ServletRegistrar", value = "/ServletRegistrar")
public class ServletRegistrar extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Registrar registrar = new Registrar();
        String email = request.getParameter("email");
        String pass  = request.getParameter("pass");
        String name = request.getParameter("Name");
        String number = request.getParameter("numero");
        String address = request.getParameter("domicilio");


        if (registrar.verificar(email) == false){
            registrar.setEmail(email);
            registrar.setPassword(pass);
            registrar.setUserName(name);
            registrar.setPhoneNumber(number);
            registrar.setAddress(address);
            registrar.Registrar();
            response.sendRedirect("Login.jsp");
        }

    }
}
