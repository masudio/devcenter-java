import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.*;

public class HelloWorld extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException
    {
        resp.getWriter().print("img src=\"http://weknowmemes.com/wp-content/uploads/2012/03/the-good-thing-about-science.jpg\" alt=\"we gotta tough guy here!\"/>");
    }

    public static void main(String[] args) throws Exception
    {
        Server server = new Server(Integer.valueOf(System.getenv("PORT")));
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");
        server.setHandler(context);
        context.addServlet(new ServletHolder(new HelloWorld()),"/*");

        server.start();
        server.join();
    }
}
