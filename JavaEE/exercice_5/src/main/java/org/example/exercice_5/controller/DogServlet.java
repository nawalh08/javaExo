package org.example.exercice_5.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.exercice_5.model.Dog;
import org.example.exercice_5.service.DogService;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@WebServlet(name = "dogServlet" , value = "/dogs")
public class DogServlet extends HttpServlet {

    private DogService ds;

    @Override
    public void init() throws ServletException {
        ds = new DogService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/dog/addDog.jsp").forward(req, resp);


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // recupere les infos

        String name = req.getParameter("name");
        String breed = req.getParameter("breed");
        LocalDate birthDate = LocalDate.parse(req.getParameter("birthDate"));

        Dog dog = Dog.builder().name(name).breed(breed).birthDate(birthDate).build();


        ds.create(dog);
        resp.sendRedirect("dogs/list");

    }


}
