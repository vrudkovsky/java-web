package lesson02.servlet;

import lesson02.util.TemplateEngine;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

public class FileServletFreemarker extends HttpServlet {

    /**
     * http://localhost:8080/fm
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TemplateEngine engine = TemplateEngine.folder("content"); //build engine

        HashMap<String, Object> data = new HashMap<>();
        data.put("name", "Jim"); //get data

        engine.render("dynamic1.ftl", data, resp); //redering
    }
}
