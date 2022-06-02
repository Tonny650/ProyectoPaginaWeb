package com.example.controlador;

import com.example.configuraciones.Conexion;
import com.example.configuraciones.Fecha;
import com.example.modelo.Carrito;
import com.example.modelo.ModeloDao.Cliente;
import com.example.modelo.ModeloDao.Compra;
import com.example.modelo.ModeloDao.CompraDAO;
import com.example.modelo.ModeloDao.Pago;
import com.example.modelo.Producto;
import com.example.modelo.ProductoDAO;
import org.jetbrains.annotations.NotNull;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ServletControlador", value = "/ServletControlador")
public class ServletControlador extends HttpServlet {
    ProductoDAO pdao = new ProductoDAO();
    Producto p = new Producto();
    List<Producto> productos = new ArrayList<>();
    String name;
    List<Carrito> carritoList = new ArrayList<>();
    int item, cantidad = 1;
    double totalPagar = 0.0;
    int idp;
    Carrito car;
    public String getName() {
        return name;
    }

    @Override
    protected void doGet(@NotNull HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String acction = request.getParameter("accion");
        productos = pdao.listar();

        switch (acction){
            case "AgragarCarrito":
                int pos = 0;
                cantidad = 1;
                idp = Integer.parseInt(request.getParameter("id"));
                p = pdao.listarId(idp);


                if (carritoList.size() > 0){
                    for (int i = 0; i < carritoList.size(); i++) {
                        if (idp == carritoList.get(i).getIdProducto()){
                            pos = i;
                        }
                    }
                    if (idp == carritoList.get(pos).getIdProducto()){
                        cantidad= carritoList.get(pos).getCantidad()+cantidad;
                        double subtotal = carritoList.get(pos).getPrecioCompra()*cantidad;
                        carritoList.get(pos).setCantidad(cantidad);
                        carritoList.get(pos).setSubTotal(subtotal);
                    }else {
                        item = item+1;
                        car=new Carrito();
                        car.setItem(item);
                        car.setIdProducto(p.getId());
                        car.setNombres(p.getNombres());
                        car.setDescripcion(p.getDescripcion());
                        car.setPrecioCompra(p.getPrecio());
                        car.setCantidad(cantidad);
                        car.setSubTotal(cantidad*p.getPrecio());
                        carritoList.add(car);
                    }
                }else {
                    item = item+1;
                    car=new Carrito();
                    car.setItem(item);
                    car.setIdProducto(p.getId());
                    car.setNombres(p.getNombres());
                    car.setDescripcion(p.getDescripcion());
                    car.setPrecioCompra(p.getPrecio());
                    car.setCantidad(cantidad);
                    car.setSubTotal(cantidad*p.getPrecio());
                    carritoList.add(car);
                }
                request.setAttribute("contador", carritoList.size());
                request.getRequestDispatcher("ServletControlador?accion=home").forward(request,response);

                break;
            case "Delete":
                totalPagar = 0.0;
                int idProducto = Integer.parseInt(request.getParameter("idProducto"));
                for (int i = 0; i < carritoList.size(); i++) {
                    if (carritoList.get(i).getIdProducto() ==idProducto){
                        carritoList.remove(i);
                    }
                }
                if (true){
                    totalPagar = 0.0;
                    for (int j = 0; j < carritoList.size(); j++) {
                        totalPagar=totalPagar+carritoList.get(j).getSubTotal();
                    }
                    request.setAttribute("totalApagar",totalPagar);
                }
                request.getRequestDispatcher("ServletControlador?accion=Carrito").forward(request,response);
                break;
            case "Carrito":
                request.setAttribute("Carrito",carritoList);
                if (true){
                    totalPagar = 0.0;
                    for (int i = 0; i < carritoList.size(); i++) {
                        totalPagar=totalPagar+carritoList.get(i).getSubTotal();
                    }
                }

                request.setAttribute("img",productos);
                request.setAttribute("totalApagar",totalPagar);
                request.getRequestDispatcher("carrito.jsp").forward(request, response);
                break;
            case "comprar":
                totalPagar = 0.0;
                idp = Integer.parseInt(request.getParameter("id"));
                p = pdao.listarId(idp);
                item = item+1;
                car=new Carrito();
                car.setItem(item);
                car.setIdProducto(p.getId());
                car.setNombres(p.getNombres());
                car.setDescripcion(p.getDescripcion());
                car.setPrecioCompra(p.getPrecio());
                car.setCantidad(cantidad);
                car.setSubTotal(cantidad*p.getPrecio());
                carritoList.add(car);

                if (true){
                    totalPagar = 0.0;
                    for (int i = 0; i < carritoList.size(); i++) {
                        totalPagar=totalPagar+carritoList.get(i).getSubTotal();
                    }
                }

                request.setAttribute("totalApagar",totalPagar);
                request.setAttribute("Carrito",carritoList);
                request.setAttribute("contador", carritoList.size());
                request.getRequestDispatcher("carrito.jsp").forward(request,response);
            case "GenerarCompra":
                String Name_id = (String) request.getSession().getAttribute("id");
                Cliente cliente = new Cliente();
                cliente.setId(Integer.parseInt(Name_id));
                CompraDAO dao = new CompraDAO();
                Compra compra = new Compra(cliente ,1, Fecha.FechaBD(),totalPagar,"Canselado",carritoList);
                int res=dao.GenerarComra(compra);
                if (res!=0&&totalPagar>0){
                    request.getRequestDispatcher("vistas/mensaje.jsp").forward(request, response);
                }else {
                    request.getRequestDispatcher("vistas/error.jsp").forward(request, response);
                }

                break;
            default:
                request.setAttribute("productos",productos);
                request.getRequestDispatcher("Home.jsp").forward(request,response);
        }

        //request.setAttribute("productos",productos);
        //request.getRequestDispatcher("index.jsp").forward(request,response);


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }


}
