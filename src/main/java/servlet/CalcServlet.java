package servlet;

import service.Calculator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Optional;

public class CalcServlet extends HttpServlet {

    private final Calculator calc;

    private Optional<Integer> toInt(String s) {
        try {
            return Optional.of(Integer.parseInt(s));
        } catch (NumberFormatException e) {
            return Optional.empty();
        }
    }

    public CalcServlet(Calculator calc) {
        this.calc = calc;
    }
    /**
     * http://localhost:8080/calc?a=5&b=6
     * Map<String, String[]> parameterMap = req.getParameterMap();
     */

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        Integer a = Optional.ofNullable(req.getParameter("a"))
//                .map(Integer::parseInt)
//                .orElse(0);
//
//        Integer b = Optional.ofNullable(req.getParameter("b"))
//                .map(Integer::parseInt)
//                .orElseThrow(() -> new RuntimeException());

        Optional<Integer> a = Optional.ofNullable(req.getParameter("a"))
                .flatMap(this::toInt);
        Optional<Integer> b = Optional.ofNullable(req.getParameter("b"))
                .flatMap(this::toInt);
        Optional<Integer> c = Optional.ofNullable(req.getParameter("c"))
                .flatMap(this::toInt);

        Optional<String> ab = a.flatMap((Integer ai) -> b.map((Integer bi) -> calc.add(ai, bi)))
                .map(String::valueOf);

//        String a = req.getParameter("a");
//        String b = req.getParameter("b");
//        String c = req.getParameter("c");

        try (PrintWriter w = resp.getWriter()) {
            w.println("Calc Servlet");
//            w.println(a);
//            w.println(b);
//            w.println(c);
            w.println(ab.orElse("No values"));
        }
    }
}
