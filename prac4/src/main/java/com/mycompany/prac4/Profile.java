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
import java.io.PrintWriter;

public class Profile extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false); // don't create if not exists

        if (session == null || session.getAttribute("username") == null) {
            // Not logged in, redirect to login page
            response.sendRedirect("login.html");
            return;
        }

        String username = (String) session.getAttribute("username");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html><head><title>Profile Page</title></head><body>");
        out.println("<h2>Welcome, " + username + "!</h2>");
        out.println("<p>Get Working!</p>");
        out.println("</body></html>");
    }
}

