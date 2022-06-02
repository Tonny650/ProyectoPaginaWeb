package com.example.ck_so;

import com.example.modelo.Producto;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;
    conexionP conexionc= new conexionP();
    List<Producto> productoList = new ArrayList<>();



    public void init() {
        message = "Hello World!";
    }
    private String name;

    public String getName() {
        return name;
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        String name = null;
        String acction = request.getParameter("accion");

        switch (acction){
            case "hola":
                name = acction;
                break;
            default:
        }



        List<Producto> productoList1 = Consulta();
        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h2>"+name+"</h2>");
        out.println("<p>" +"Error2: "+ conexionc.getMsj() + "</p>");
        out.println("</body></html>");
    }

    public void destroy() {
    }

    String txts = "";



    private List Consulta(){
        Connection con;
        PreparedStatement ps;
        ResultSet rs;
        String sql="select * from producto";



        try {
            con = conexionc.getConnection();
            ps= con.prepareStatement(sql);
            rs = ps.executeQuery();


            while (rs.next()){

            }

        }catch (Exception e){
            txts = e.toString();
        }

        return productoList;
    }
}