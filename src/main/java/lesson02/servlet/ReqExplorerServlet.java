package lesson02.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.*;
import java.io.*;
import java.util.Collection;
import java.util.Map;
import java.util.stream.Collectors;

public class ReqExplorerServlet extends HttpServlet {

    /**
     * http://localhost:8080/file
     */

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse rs) throws ServletException, IOException {
        String a = req.getParameter("a");
        Map<String, String[]> parameterMap = req.getParameterMap();
        String authentication = req.getHeader("Authentication");
        Cookie[] cookies = req.getCookies();
        String method = req.getMethod();
        Collection<Part> parts = req.getParts();
        for (Part p: parts) {
            p.getContentType();
            p.getInputStream();
            p.getSubmittedFileName();
        }
        String pathInfo = req.getPathInfo();
        String queryString = req.getQueryString();
        String contextPath = req.getContextPath();

        //body for PUT, POST, etc.
        ServletInputStream inputStream = req.getInputStream();
    }
}
