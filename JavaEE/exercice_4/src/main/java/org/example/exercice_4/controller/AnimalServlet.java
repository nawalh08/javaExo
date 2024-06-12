package org.example.exercice_4;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class AnimalServlet extends HttpServlet {
    private String InitParam;

    @Override
    public void init() throws ServletException {

    }


    @Override
    public void doGet(HttpServletRequest req , HttpServletResponse resp) throws ServletException, IOException {


        getServletContext().getRequestDispatcher("/WEB-INF/formAnimals.jsp").forward(req , resp);
    }
}
