/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.prac3;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

public class UserPreference extends HttpServlet {

    private static final String COOKIE_NAME = "fontStyle";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fontStyle = null;

        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie c : cookies) {
                if (COOKIE_NAME.equals(c.getName())) {
                    fontStyle = URLDecoder.decode(c.getValue(), StandardCharsets.UTF_8.toString());
                    break;
                }
            }
        }

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String style = (fontStyle != null) ? fontStyle : "Arial";

        out.println("<html><head><title>User Font Preference</title></head>");
        out.println("<body style='font-family:" + style + ";'>");

        out.println("<h2>Your preferred font style is: " + style + "</h2>");

        out.println("<form method='POST'>");
        out.println("Select font style: ");
        out.println("<select name='font'>");
        out.println("<option value='Arial'" + ("Arial".equals(style) ? " selected" : "") + ">Arial</option>");
        out.println("<option value='Courier New'" + ("Courier New".equals(style) ? " selected" : "") + ">Courier New</option>");
        out.println("<option value='Times New Roman'" + ("Times New Roman".equals(style) ? " selected" : "") + ">Times New Roman</option>");
        out.println("<option value='Georgia'" + ("Georgia".equals(style) ? " selected" : "") + ">Georgia</option>");
        out.println("<option value='Verdana'" + ("Verdana".equals(style) ? " selected" : "") + ">Verdana</option>");
        out.println("</select>");
        out.println("<input type='submit' value='Save Preference' />");
        out.println("</form>");

        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String selectedFont = request.getParameter("font");

        if (selectedFont != null && !selectedFont.trim().isEmpty()) {
            String encodedFont = URLEncoder.encode(selectedFont, StandardCharsets.UTF_8.toString());

            Cookie fontCookie = new Cookie(COOKIE_NAME, encodedFont);
            fontCookie.setMaxAge(7 * 24 * 60 * 60); // 7 days
            response.addCookie(fontCookie);
        }

        response.sendRedirect(request.getContextPath() + "/UserPreference");
    }
}
