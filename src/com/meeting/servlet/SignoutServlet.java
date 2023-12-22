package com.meeting.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;


public class SignoutServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        Cookie expireCookie = new Cookie("JSESSIONID", "");
        expireCookie.setMaxAge(0);
        response.addCookie(expireCookie);
        response.sendRedirect(request.getContextPath() + "/login.jsp");
    }
}
