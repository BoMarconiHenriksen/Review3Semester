package uge1.Day3.ex20;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.Callable;
//import static uge1.Day3.ex20.SequentialPinger.urlFinal;

/**
 *
 * @author Bo
 */
public class Task implements Callable<String> {

    private final String urlFinal;

    Task(String urlFinal) {
        this.urlFinal = urlFinal;
    }

    @Override
    public String call() throws Exception {

        String result = "Error";
        try {
            URL siteURL = new URL(urlFinal);
            HttpURLConnection connection = (HttpURLConnection) siteURL
                    .openConnection();
            connection.setRequestMethod("GET");
            connection.connect();

            int code = connection.getResponseCode();
            if (code == 200) {
                result = "Green";
            }
            if (code == 301) {
                result = "Redirect";
            }
        } catch (Exception e) {
            result = "->Red<-";
        }
        return result;

    }

    public String getUrlFinal() {
        return urlFinal;
    }
    
    

}
