package ie.StoreCompare.store.gamestop;

import java.io.IOException;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import ie.StoreCompare.storage.Items;

public class Gamestop {
	
	public static void main(String gameName, List<Items> itemList) throws IOException {
		
		String name;
		String gameType;
		double price;
		double postage = 1.50;
		String url = "https://www.gamestop.ie/SearchResult/QuickSearch?q=";
		
		gameName = gameName.replaceAll(" ", "+");
		url = url + gameName;
		
		System.out.println("\nSending request..." + "\"" + url + "\"\n");
		Document doc = Jsoup.connect(url).userAgent("Mozilla/5.0").followRedirects(true).timeout(60000).get();
		
		Elements els  = doc.select("div.singleProduct");
		
		System.out.println(doc);
		
		for(Element el : els)
		{
			name = el.getElementsByTag("h3").text();
			
			System.out.println(el);
			
			//price =  Double.parseDouble((el.select("div.priceTxt").get(0).text()).replaceAll("[^0-9.]", ""));
			//gameType = ((el.getElementsByTag("p").text().substring(el.getElementsByTag("p").text().indexOf("/")+1, el.getElementsByTag("p").text().length())).replaceAll("Games", "")).replaceAll(" ", "");  
			
			
			
			
			//System.out.println(name + " " + price + " " + gameType);
			
			//itemList.add(new Items((name + "(" + gameType + ")"), (price + postage)));
		}
	}
}