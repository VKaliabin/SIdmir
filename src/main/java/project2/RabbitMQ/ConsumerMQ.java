package project2.RabbitMQ;

import com.rabbitmq.client.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;
import java.io.IOException;

@Stateless
public class ConsumerMQ {
    private static final Logger logger = LoggerFactory.getLogger(ConsumerMQ.class);
    private static String receive;
    private final static String QUEUE_NAME = "banner";

    public String run() throws Exception {

        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);

        System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

        Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body)
                    throws IOException {
                String message = new String(body, "UTF-8");
                logger.info("message is arrived from banner -" + message);
                receive = message;
            }
        };
        channel.basicConsume(QUEUE_NAME, true, consumer);
        logger.info("received is arrived from banner(2)-" + receive);

//        channel.close();
//        connection.close();
        return receive;
    }
}