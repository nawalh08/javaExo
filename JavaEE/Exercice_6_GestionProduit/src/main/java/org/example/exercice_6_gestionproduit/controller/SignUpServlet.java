package org.example.exercice_6_gestionproduit.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.exercice_6_gestionproduit.model.Users;
import org.example.exercice_6_gestionproduit.service.UserService;

import java.io.IOException;

@WebServlet(name = "SignInServlet" , value = "/users/SignUp")
public class SignUpServlet extends HttpServlet {

    UserService userService ;

    @Override
    public void init() throws ServletException {
userService = new UserService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/user/signUpForm.jsp").forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("name");
        String password = req.getParameter("password");
        String mail = req.getParameter("email");
        Users o = new Users(username,mail,password);
        userService.create(o);
    }
}
