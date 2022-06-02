package com.example.controlador;

import com.example.modelo.ProductoDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;

@WebServlet(name = "ServletControlador_Img", value = "/ServletControlador_Img")
public class ServletControlador_Img extends HttpServlet {
    ProductoDAO pdao = new ProductoDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       int id = Integer.parseInt(request.getParameter("id"));
        ProductoDAO productoDAO = new ProductoDAO();
        productoDAO.img(id,response);


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
