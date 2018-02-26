package ie.StoreCompare.store;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Google {

	public static void main(int amount, String gameName) throws IOException {

		String url = "https://www.google.ie/search?q="+gameName+"&num="+amount;  // or whatever goes here
		Document doc = Jsoup.connect(url).followRedirects(false).userAgent("Mozilla").timeout(60000).get();
		
		System.out.println("Sending request..." + "\"" + url + "\"");
		
		Elements els  = doc.select("div.g");
		
		for(Element el : els)
		{
			if(el.getElementsByTag("h3").text() != " "){
				System.out.println("Title : " + el.getElementsByTag("h3").text());
				System.out.println("Site : " +  el.getElementsByTag("cite").text());
				System.out.println("Abstract : " + el.getElementsByTag("span").text() + "\n");
			}
		}
	}
}