import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
public abstract class Trainer {
    public static String  Parsowanie (String adres) throws Exception
    {
        Document doc = Jsoup.connect(adres).get();
        String text;
        text = doc.body().text().toLowerCase();
        //System.out.println(text);
        int text_length = text.length();
        return text;

    }
}
