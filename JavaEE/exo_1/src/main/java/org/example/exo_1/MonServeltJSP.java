package org.example.exo_1;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
@WebServlet(name = "monServletJSP",value = "/monservlet-jsp")
public class MonServeltJSP extends HttpServlet {
    private String nom ;
    private String prenom ;
    private int age;

    @Override
    public void init() throws ServletException{
        nom = "dupont";
        prenom = "jean";
        age = 33;
    }

    @Override
    protected void doGet(HttpServletRequest req , HttpServletResponse resp) throws ServletException,IOException{
        req.setAttribute("nom", nom);
        req.setAttribute("prenom", prenom);
        req.setAttribute("age",age);
        getServletContext().getRequestDispatcher("/test.jsp").forward(req, resp);
    }
}
