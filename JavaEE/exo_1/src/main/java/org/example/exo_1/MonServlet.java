package org.example.exo_1;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "monServlet" , value = "/monServlet")
public class MonServlet extends HttpServlet {

    @Override
    public void init() throws ServletException{
        System.out.println("Mons servlet est lancé ");
    }

    @Override

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        System.out.println("Une requette get a été envoyée à /monServlet");
        resp.setContentType("text/plain");
        PrintWriter writer= resp.getWriter();
        writer.println("<h1> Je renvoie du texte simple </h1>");
    }

    @Override
    public void destroy(){
        System.out.println("monServlet est détruit");
    }
}
