package uge1.Day3.ex20;

/*
 * Code taken from 
 * http://crunchify.com/how-to-get-ping-status-of-any-http-end-point-in-java/
 */
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import uge1.Day3.ex20.Task;

//ca 7 sekunder når der ikke er gjordt noget ved programmet.
public class SequentialPinger {

//    static String urlFinal = null;
    static int numberThreads = 10;

    public static void main(String args[]) throws Exception {

        ExecutorService es = Executors.newFixedThreadPool(numberThreads);

//         es.execute(command);
//        List<Future<String>> futures;
//        Callable MyTask = (() -> {
//            
//            Hvordan får jeg en konstruktør ind her???
//
//            String result = "Error";
//            try {
//                URL siteURL = new URL(urlFinal);
//                HttpURLConnection connection = (HttpURLConnection) siteURL
//                        .openConnection();
//                connection.setRequestMethod("GET");
//                connection.connect();
//
//                int code = connection.getResponseCode();
//                if (code == 200) {
//                    result = "Green";
//                }
//                if (code == 301) {
//                    result = "Redirect";
//                }
//            } catch (Exception e) {
//                result = "->Red<-";
//            }
//            return result;
//
//        });
        String[] hostList = {"http://crunchify.com", "http://yahoo.com",
            "http://www.ebay.com", "http://google.com",
            "http://www.example.co", "https://paypal.com",
            "http://bing.com/", "http://techcrunch.com/",
            "http://mashable.com/", "http://thenextweb.com/",
            "http://wordpress.com/", "http://cphbusiness.dk/",
            "http://example.com/", "http://sjsu.edu/",
            "http://ebay.co.uk/", "http://google.co.uk/",
            "http://www.wikipedia.org/",
            "http://dr.dk", "http://pol.dk", "https://www.google.dk",
            "http://phoronix.com", "http://www.webupd8.org/",
            "https://studypoint-plaul.rhcloud.com/", "http://stackoverflow.com",
            "http://docs.oracle.com", "https://fronter.com",
            "http://imgur.com/", "http://www.imagemagick.org"
        };

        List<Callable<String>> callable = new ArrayList<>();
        for (int i = 0; i < hostList.length; i++) {
            String urlFinal = hostList[i];
//            String status = getStatus(urlFinal);
            callable.add(new Task(urlFinal));
//            callable.add(new Task(status));

        }

        List<Future<String>> resultList = es.invokeAll(callable);
        for (Future<String> result : resultList) {
//            for (int i = 0; i < hostList.length; i++) {
//                String url = hostList[i];
//            }
            System.out.println(" Status: " + result.get());
            es.shutdown();
        }

//        for (int i = 0; i < hostList.length; i++) {
//
//            String url = hostList[i];
//            String status = getStatus(url);
//
//            System.out.println(url + "\t\tStatus:" + status);
//
//            es.shutdown();
//        }
    }

//    public SequentialPinger() {
//    }
//    public static String getStatus(String url) throws IOException {
//
//        String result = "Error";
//        try {
//            URL siteURL = new URL(url);
//            HttpURLConnection connection = (HttpURLConnection) siteURL
//                    .openConnection();
//            connection.setRequestMethod("GET");
//            connection.connect();
//
//            int code = connection.getResponseCode();
//            if (code == 200) {
//                result = "Green";
//            }
//            if (code == 301) {
//                result = "Redirect";
//            }
//        } catch (Exception e) {
//            result = "->Red<-";
//        }
//        return result;
//    }
}
