package uge1.Day2.webscrapprodcon;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class DocumentConsumer implements Runnable {

    LinkedBlockingQueue<Document> producedDocuments;
    Document doc;

//    public DocumentConsumer(BlockingQueue<Document> producedDocuments) {
//        this.producedDocuments = producedDocuments;
//    }
    
    public DocumentConsumer(LinkedBlockingQueue<Document> producedDocuments) {
        this.producedDocuments = producedDocuments;
    }

    @Override
    public void run() {
        boolean moreDocumentsToConsume = true;
        Document doc;
        int totalDivs = 0;
        while (moreDocumentsToConsume) {
            try {
                //TODO: Change this to fetch a new document from the producedDocuments queue or wait if no one is ready
                //Hint: So far you have no way of knowing when all producers are done. For this part you can use a method that
                //WAIT, but only for max 10 seconds and if it times out take that as that all Producers are done
                doc = producedDocuments.take();
                //producedDocuments.wait(10000);

                if (doc != null) {
                    String title = doc.title();
                    Elements divs = doc.select("div");
                    //TODO Update the totalDivs variable and print title and sum for this document
                    totalDivs++;
                    System.out.println("Title " + title);
                    System.out.println("Sum " + totalDivs);
                } else {
                    moreDocumentsToConsume = false;
                }

            } catch (Exception ex) {
                Logger.getLogger(DocumentConsumer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.out.println("Sum of all Divs:" + totalDivs);
    }

}
