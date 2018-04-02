package project2;

import com.google.gson.Gson;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Stateless
public class EjbModelModelImpl implements EjbModelService {

    private static final Logger logger = LoggerFactory.getLogger(EjbModelModelImpl.class);


    public EjbModel getModel() {
        EjbModel model = null;
        String url = "http://localhost:8081/getAllparams";
        String str = "";
        try {
            HttpClient client = new DefaultHttpClient();
            HttpGet request = new HttpGet(url);
//            HttpPost request = new HttpPost(url);
            HttpResponse response = client.execute(request);
            BufferedReader rd = new BufferedReader(
                    new InputStreamReader(response.getEntity().getContent()));
            String line = "";
            while ((line = rd.readLine()) != null) {
                str = str + line;
            }
            Gson gson = new Gson();
            model = gson.fromJson(str, EjbModel.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return model;

//
//        ////////////////////////////
////        HttpClient httpClient = HttpClientBuilder.create().build();
//        HttpClient client = new DefaultHttpClient();
//        HttpPost post = new HttpPost(url);
////         response = null;
//
//        try {
//            List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
//            urlParameters.add(new BasicNameValuePair("postParam", "true"));
//            post.setEntity(new UrlEncodedFormEntity(urlParameters));
//            HttpResponse response = client.execute(post);
//            BufferedReader rd = new BufferedReader(
//                    new InputStreamReader(response.getEntity().getContent()));
//
//            String line = "";
//            while ((line = rd.readLine()) != null) {
//                str = str+ line;
//            }
//
//            logger.info("json = {}", str);
//            Gson gson = new Gson();
//            model = gson.fromJson(str, project2.EjbModel.class);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        return model;
//    }
    }}


