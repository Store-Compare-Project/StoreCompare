package ie.gmit.proskills.Websites;

import java.io.IOException;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import ie.gmit.proskills.Storage.Items;

public class Ebay {

	public static void run(String searchTerm, List<Items> itemList) throws IOException {
		
		String name = null;
		double price = 0;
		double postage = 0;
		String urlPart1 = "https://www.ebay.ie/sch/i.html?_from=R40&_trksid=p2380057.m570.l1313.TR0.TRC0.H0.X";
		String urlPart2 = ".TRS0&_nkw=";
		String completeUrl;

		searchTerm = searchTerm.replaceAll(" ", "+");
		completeUrl = urlPart1 + searchTerm + urlPart2 + searchTerm;
		
		
		// Debug
		System.out.println(urlPart1);
		System.out.println(urlPart2);
		System.out.println(completeUrl);

		
		System.out.println("\nSending request..." + "\"" + completeUrl + "\"");
		Document doc = Jsoup.connect(completeUrl).userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/535.2 (KHTML, like Gecko) Chrome/15.0.874.120 Safari/535.2").timeout(60000).get();
		
		Elements els  = doc.select("li.sresult.lvresult");
		
		// Debug
		System.out.println(doc);

		
		for(Element el : els)
		{
			name = (el.getElementsByTag("h3").text()).replaceAll("VideoGames", "");
			price =  Double.parseDouble((el.getElementsByClass("lvprice prc").text()).replaceAll("[^0-9.]", ""));
			
			itemList.add(new Items(name, (price + postage)));
		}
	}

	
}
