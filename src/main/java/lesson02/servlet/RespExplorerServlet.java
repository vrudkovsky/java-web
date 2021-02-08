package lesson02.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class RespExplorerServlet extends HttpServlet {

    /**
     * http://localhost:8080/file
     */

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse rs) throws ServletException, IOException {
        PrintWriter w = rs.getWriter();
        ServletOutputStream os = rs.getOutputStream();
        rs.sendRedirect("/abc2");
        rs.addCookie(new Cookie("a", "5"));
        rs.setStatus(301);
    }
}
