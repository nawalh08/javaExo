package org.example.exercice_6_gestionproduit.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.exercice_6_gestionproduit.model.Users;
import org.example.exercice_6_gestionproduit.service.UserService;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "loginServlet" , value = "/users/login")
public class LoginServlet extends HttpServlet {
        UserService userService ;
        List<Users> usersList;

    @Override
    public void init() throws ServletException {
        userService = new UserService();

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/user/loginForm.jsp").forward(req,resp);

    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        boolean f = false;

        Users users = userService.getByparams(req.getParameter("name"), req.getParameter("email"), req.getParameter("password"));
        if (users!=null){
            f=true;
            HttpSession session = req.getSession();
            session.setAttribute("isLogged",true);
            resp.sendRedirect("products");
        }else {
            resp.sendRedirect("login");
        }
    }
}
