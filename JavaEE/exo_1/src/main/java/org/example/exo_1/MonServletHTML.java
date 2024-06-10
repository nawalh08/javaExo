package org.example.exo_1;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "monServletHTML" , value = "/monservlet-html")
public class MonServletHTML extends HttpServlet{

    private String nom ;
    private String prenom ;
    private int age ;

    @Override
    public void init() throws ServletException {
        nom = "Dupont";
        prenom = "Jean";
        age = 45;
    }

    @Override
    protected void doGet(HttpServletRequest req , HttpServletResponse resp) throws ServletException, IOException{
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        writer.println("<h1> Je m'appelle " +  nom +  " "  +  prenom  +  " et j'ai "  +  age);
    }
}
