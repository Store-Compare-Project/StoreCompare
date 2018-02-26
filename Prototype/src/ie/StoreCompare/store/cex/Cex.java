package ie.StoreCompare.store.cex;

import java.io.IOException;
import java.util.List;

import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import ie.StoreCompare.storage.Items;

public class Cex {
	
	public static void main(String gameName, List<Items> itemList) throws IOException {
		
		String name;
		String gameType;
		double price;
		double postage = 1.50;
		String url = "https://ie.webuy.com/search?stext=";
		
		gameName = gameName.replaceAll(" ", "%20");
		url = url + gameName;
		
		System.out.println("\nSending request..." + "\"" + url + "\"\n");
		Document doc = Jsoup.connect(url).userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/535.2 (KHTML, like Gecko) Chrome/15.0.874.120 Safari/535.2").followRedirects(true).referrer("http://www.google.ie").timeout(60000).get();
		
		Elements els  = doc.select("div.searchRecord");
		
		for(Element el : els)
		{
			name = (el.getElementsByTag("h1").text()).replaceAll("\\(.*?\\) ?", "");
			price =  Double.parseDouble((el.select("div.priceTxt").get(0).text()).replaceAll("[^0-9.]", ""));
			gameType = ((el.getElementsByTag("p").text().substring(el.getElementsByTag("p").text().indexOf("/")+1, el.getElementsByTag("p").text().length())).replaceAll("Games", "")).replaceAll(" ", "");  
			
			System.out.println(name + " " + price + " " + gameType);
			
			itemList.add(new Items((name + "(" + gameType + ")"), (price + postage)));
		}
	}
}