package org.example.exercice_3_tableau;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "personnesServlet", value = "/personnes")
public class PersonneServlet extends HttpServlet {

    private List<String> Personnes;



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        List<Personnes> personnes = new ArrayList<>();
        personnes.add(new Personnes("Doe", "John", 25));
        personnes.add(new Personnes("Smith", "Jane", 30));
        personnes.add(new Personnes("Brown", "Charlie", 22));
        req.setAttribute("persons", personnes);
        getServletContext().getRequestDispatcher("personnes.jsp").forward(req, resp);
    }


}
