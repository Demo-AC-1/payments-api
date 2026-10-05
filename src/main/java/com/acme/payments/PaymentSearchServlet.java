package com.acme.payments;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PaymentSearchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String term = req.getParameter("q");
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<html><body><h2>Results for " + term + "</h2></body></html>");
    }
}
