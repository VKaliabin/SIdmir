package project2.servlets;

import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import project2.RabbitMQ.ConsumerMQ;
import project2.model.EjbModel;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class Servlet extends HttpServlet {
    private static final Logger logger = LoggerFactory.getLogger(Servlet.class);

    @EJB
    private ConsumerMQ consumerMQ;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            String message = consumerMQ.run();
            if (message != null) {
                logger.info("Message in servlet + " + message);
                Gson gson = new Gson();
                EjbModel ejbModel = gson.fromJson(message, EjbModel.class);
                logger.info("Received model " + ejbModel.toString());
                req.setAttribute("resp", ejbModel.getTariffs());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        req.getRequestDispatcher("index.xhtml").forward(req, resp);
    }


}
