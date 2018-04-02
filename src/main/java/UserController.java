import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@ManagedBean(name = "UserController")
@RequestScoped
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    private User user = new User();

    public User getUser() {
        logger.info("eeee");

        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
