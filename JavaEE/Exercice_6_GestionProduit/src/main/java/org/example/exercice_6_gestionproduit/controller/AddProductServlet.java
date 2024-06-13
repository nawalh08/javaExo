package org.example.exercice_6_gestionproduit.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.exercice_6_gestionproduit.model.Products;
import org.example.exercice_6_gestionproduit.model.Users;
import org.example.exercice_6_gestionproduit.service.ProductService;
import org.example.exercice_6_gestionproduit.service.UserService;

import java.io.IOException;
import java.time.LocalDate;

@WebServlet(name = "addProductServlet", value = "/products/add")
public class AddProductServlet extends HttpServlet {

    private ProductService productService;

    @Override
    public void init() throws ServletException {
        productService = new ProductService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String brand = req.getParameter("brand");
        String reference = req.getParameter("reference");
        LocalDate datePurchase = LocalDate.parse(req.getParameter("datePurchase"));
        Double price = Double.parseDouble(req.getParameter("price"));
        Integer stock = Integer.parseInt(req.getParameter("stock"));
        Products products = Products.builder().brand(brand).reference(reference).datePurchase(datePurchase).price(price).stock(stock).build();

        productService.create(products);

    }
}
