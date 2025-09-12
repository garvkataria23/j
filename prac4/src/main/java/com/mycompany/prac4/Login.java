/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.prac4;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

public class Login extends HttpServlet {

    // For demo, hardcoded username and password
    private static final String USERNAME = "Zen Wisteria";
    private static final String PASSWORD = "password123";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Redirect to login page if accessed directly
        response.sendRedirect("login.html");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (USERNAME.equals(username) && PASSWORD.equals(password)) {
            // Valid login, create session and store username
            HttpSession session = request.getSession();
            session.setAttribute("username", username);

            // Redirect to profile page
            response.sendRedirect("Profile");
        } else {
            // Invalid login, redirect back to login page with error message
            response.sendRedirect("login.html?error=Invalid+username+or+password");
        }
    }
}

