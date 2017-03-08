import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * Created by jonesdc on 3/7/17.
 */
public class Crawler {

    public String[][] grabText() throws IOException {
        int row = 0;
        int column = 0;

        Document doc = Jsoup.connect("<URL TO READ GOES HERE>").get();
        Elements users = doc.select("div.commentarea").select("p.tagline").select(".author");
        Elements comments = doc.select("div.commentarea").select("div.md");
        String[][] stringToBeReturned = new String[2][comments.size()];

        for(Element user : users) {
            String userString = user.text();
            stringToBeReturned[row][column] = userString;
            column++;
        }

        row = 1;
        column = 0;

        for(Element comment : comments) {
            String commentString = comment.text();
            stringToBeReturned[row][column] = commentString;
            column++;
        }
        return stringToBeReturned;
    }
}