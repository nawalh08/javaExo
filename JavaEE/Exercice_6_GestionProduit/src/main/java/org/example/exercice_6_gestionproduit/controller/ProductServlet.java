package org.example.exercice_6_gestionproduit.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.exercice_6_gestionproduit.model.Products;
import org.example.exercice_6_gestionproduit.service.ProductService;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "productServlet", value = "/products")
public class ProductServlet extends HttpServlet {

    private ProductService ps;
    public List<Products> productList;


    @Override
    public void init() throws ServletException {
       ps = new ProductService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        boolean logged = (session.getAttribute("isLogged")!= null) ? (boolean) session.getAttribute("isLogged") : false;
        if (logged) {
            productList = ps.findAll();
            req.setAttribute("products", productList);
            getServletContext().getRequestDispatcher("/WEB-INF/product/listProduct.jsp").forward(req, resp);
        }else {
            resp.sendRedirect("login");
        }
    }

}


