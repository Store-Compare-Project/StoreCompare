package ie.StoreCompare.store.musicmagpie;

import java.io.IOException;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import ie.StoreCompare.storage.Items;

public class MusicMagPieEbayStore {

	public static void main(String gameName, List<Items> itemList) throws IOException {
		
		String name = null;
		double price = 0;
		double postage = 0;
		String url = "http://www.ebay.ie/sch/i.html?LH_BIN=1&_nkw=";
		
		gameName = gameName.replaceAll(" ", "+");
		url = url + gameName + "&_ssn=musicmagpie";
		
		System.out.println("\nSending request..." + "\"" + url + "\"");
		Document doc = Jsoup.connect(url).userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/535.2 (KHTML, like Gecko) Chrome/15.0.874.120 Safari/535.2").timeout(60000).get();
		
		Elements els  = doc.select("li.sresult.lvresult");
		
		//System.out.println(doc);
		
		for(Element el : els)
		{
			name = (el.getElementsByTag("h3").text()).replaceAll("VideoGames", "");
			price =  Double.parseDouble((el.getElementsByClass("lvprice prc").text()).replaceAll("[^0-9.]", ""));
			postage =  Double.parseDouble((el.getElementsByClass("fee").text()).replaceAll("[^0-9.]", ""));
			
			itemList.add(new Items(name, (price + postage)));
		}
	}
}