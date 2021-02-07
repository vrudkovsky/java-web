import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import service.Calculator;
import servlet.CalcServlet;
import servlet.HelloServlet;

public class App {
    public static void main(String[] args) throws Exception {
        Server server = new Server(8080);

        ServletContextHandler handler = new ServletContextHandler();
        handler.addServlet(HelloServlet.class, "/");
        handler.addServlet(new ServletHolder(new CalcServlet(new Calculator())), "/calc");

        server.setHandler(handler);
        server.start();
        server.join();
    }
}
