package com.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.UserService;

import java.io.IOException;

@WebServlet("/jdbc/index")
public class IndexServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var users = UserService.listUsers();
        req.setAttribute("users",users);
        req.getRequestDispatcher("/WEB-INF/jsp/index.jsp").forward(req,resp);
    }
}
