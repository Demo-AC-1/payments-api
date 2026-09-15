package com.acme.payments;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class UserLookupServlet extends HttpServlet {
    private static final Logger LOG = LogManager.getLogger(UserLookupServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String id = req.getParameter("id");
        LOG.info("customer lookup requested for " + id);
        try (Connection c = DriverManager.getConnection(Config.DB_URL, Config.DB_USER, Config.DB_PASSWORD);
             Statement st = c.createStatement()) {
            ResultSet rs = st.executeQuery("SELECT name, card_last4 FROM customers WHERE id = '" + id + "'");
            PrintWriter out = resp.getWriter();
            while (rs.next()) {
                out.println(rs.getString("name") + " ****" + rs.getString("card_last4"));
            }
        } catch (SQLException e) {
            resp.sendError(500, e.getMessage());
        }
    }
}
