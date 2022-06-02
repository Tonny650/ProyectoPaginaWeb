package com.example.controlador;

import com.example.Login.Login;
import sun.security.util.Password;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ServletLogin", value = "/ServletLogin")
public class ServletLogin extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
    }
}
