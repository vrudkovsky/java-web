package lesson01;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import lesson01.service.CalcService;
import lesson01.servlet.CalcServlet;
import lesson01.servlet.HelloServlet;

public class App1 {
    public static void main(String[] args) throws Exception {
        Server server = new Server(8080);

        ServletContextHandler handler = new ServletContextHandler();
        handler.addServlet(HelloServlet.class, "/");
        handler.addServlet(new ServletHolder(new CalcServlet(new CalcService())), "/calc");

        server.setHandler(handler);
        server.start();
        server.join();
    }
}
