package com.acme.payments;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ReceiptServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String name = req.getParameter("file");
        File f = new File(Config.UPLOAD_DIR + name);
        try (FileInputStream in = new FileInputStream(f); OutputStream out = resp.getOutputStream()) {
            in.transferTo(out);
        }
    }
}
