package project2.servlets;


import project2.RabbitMQ.ProducerMQ;

import javax.ejb.EJB;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ServletListener implements ServletContextListener {
    @EJB
    private ProducerMQ producerMQ;


    public void contextInitialized(ServletContextEvent servletContextEvent) {
        try {
            producerMQ.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
