package lesson01.servlet;

import lesson01.service.CalcService;
import lesson01.util.Params;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;

public class CalcServlet extends HttpServlet {

    private final CalcService calc;

    public CalcServlet(CalcService calc) {
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

//        Optional<Integer> a = Optional.ofNullable(req.getParameter("a"))
//                .flatMap(this::toInt);
//        Optional<Integer> b = Optional.ofNullable(req.getParameter("b"))
//                .flatMap(this::toInt);
//        Optional<Integer> c = Optional.ofNullable(req.getParameter("c"))
//                .flatMap(this::toInt);

        Optional<Integer> a = Params.getIntParam("a", req);
        Optional<Integer> b = Params.getIntParam("b", req);
        Optional<Integer> c = Params.getIntParam("c", req);

//        Optional<String> ab = a.flatMap(ai ->
//                b.map(bi ->
//                        calc.add(ai, bi)
//                )
//        )
//                .map(String::valueOf);

//        String a = req.getParameter("a");
//        String b = req.getParameter("b");
//        String c = req.getParameter("c");

        try (PrintWriter w = resp.getWriter()) {
            w.println("Calc Servlet GET");
//            w.println(a);
//            w.println(b);
//            w.println(c);
            w.println(calc.add(a, b).map(String::valueOf).orElse("No values"));
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("POST => /calc");
//        Optional<Integer> a = Optional.ofNullable(req.getParameter("a"))
//                .flatMap(this::toInt);
//        Optional<Integer> b = Optional.ofNullable(req.getParameter("b"))
//                .flatMap(this::toInt);

        Optional<Integer> a = Params.getIntParam("a", req);
        Optional<Integer> b = Params.getIntParam("b", req);
        Optional<Integer> c = Params.getIntParam("c", req);

//        Optional<String> ab = a.flatMap(ai ->
//                b.map(bi ->
//                        calc.add(ai, bi)
//                )
//        )
//                .map(String::valueOf);

        try (PrintWriter w = resp.getWriter()) {
            w.println("Calc Servlet POST");
//            w.println(a);
//            w.println(b);
            w.println(calc.add(a, b).map(String::valueOf).orElse("No values"));
        }
    }
}
