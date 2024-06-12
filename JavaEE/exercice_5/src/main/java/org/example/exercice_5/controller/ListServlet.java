package org.example.exercice_5.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.exercice_5.model.Dog;
import org.example.exercice_5.service.DogService;

import java.io.IOException;
import java.util.List;

@WebServlet(name="listServlet" , value = "/dogs/list")
public class ListServlet extends HttpServlet {

    private DogService ds;
    public List<Dog> dogList;

    @Override
    public void init() throws ServletException {
        ds = new DogService();

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        dogList = ds.findAll();
       req.setAttribute("dogs",dogList);
       getServletContext().getRequestDispatcher("/WEB-INF/dog/listDog.jsp").forward(req,resp);
    }
}
