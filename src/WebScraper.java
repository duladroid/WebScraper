import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class WebScraper {

    public WebScraper(){
        String html = "https://en.wikipedia.org/wiki/Dog";

        try {
            Document doc = Jsoup.connect(html).get();
            String title = doc.title();
            System.out.println(title);
            // System.out.println(doc); // entire HTML


            /* * Content we can 'get'
             * The more 'general' ones:
             * -> Tags (the things just inside the < > , such as <p> or <li>
             * -> Attributes (special words that customize tags, such as "height", "color", "center"); not very helpful at the moment
             * The more specific ones - better for our purposes here!
             * -> Classes (organize content into major sections ... looks like <tag class = "className">
             * -> ID's (unique labels for sections of the HTML document ... looks like <tage id="IDName"> ** the only option to get a single result**
             *
             * */

            // Get content by tag
            Elements paragraphs = doc.getElementsByTag("p");
            for(Element element: paragraphs){
                System.out.println(element.text());
            }

            Elements lines = doc.getElementsByTag("li");
            for(Element element: lines){
                System.out.println(element.text());
            }

            Elements links = doc.getElementsByTag("a");
            for(Element element: links){
                System.out.println(element.text());
                System.out.println("Link: " + element.attr("href"));
            }

            //Get element by ID
            Element content = doc.getElementById("mw-content-text");
            Elements text = content.getElementsByTag("a");
            for(Element element: text){
                System.out.println(element.text());
            }

            //Get element by Class
            Elements contentClass = doc.getElementsByClass("hcf-rollup hcv-newsRollup");
            System.out.println(contentClass.text());

            Elements subContent = contentClass.first().getElementsByTag("li");
            for (Element element:subContent){
                System.out.println(element.text());
                System.out.println(element.getElementsByTag("a").first().text());
            }



        }catch (IOException e){
            System.out.println(e);
        }

    }

}
