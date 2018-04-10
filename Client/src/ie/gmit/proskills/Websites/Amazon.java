package ie.gmit.proskills.Websites;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.util.List;

import org.jsoup.Connection;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.helper.HttpConnection;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import ie.gmit.proskills.Storage.Items;
import sun.rmi.runtime.Log;

public class Amazon {

	// Run this class when we want to search amazon
	public static void run(String searchTerm, List<Items> itemList) throws IOException
	{
		// Varaibles
		String name = null;
		String priceString=null;
		String urlPart1="https://www.amazon.co.uk/s/ref=nb_sb_noss_2?url=search-alias%3Daps&field-keywords=";
		String urlPart2="";
		String completeUrl;
		double price=0.00;
		
		// Replace any spaces with a +
		searchTerm = searchTerm.replaceAll(" ", "+");
		
		// Complete the url with search terms added 
		completeUrl = urlPart1 + searchTerm;

		// Debug
		System.out.println(urlPart1);
		System.out.println(urlPart2);
		System.out.println(completeUrl);
		
		// Tell the user they're request is being sent to the user
		System.out.println("\nSending request..." + "\"" + completeUrl + "\"");
		
		// Create a document of the HTML of the webpage we are searching (In our case ebay)

        Connection.Response response=null;
        Document doc = null;

        try 
        {

            System.out.println(completeUrl);
            response =  Jsoup.
                        connect(completeUrl).
	                    followRedirects(true).
	                    userAgent("Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.87 Safari/537.36").
	                    execute();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        if(response!=null && response.statusCode()==200)
        {

            doc =  response.parse();
        }
        else
        {
        	doc = null;
        }
		
		System.out.println(doc);

		// Selecting the following element of 
		Elements els  = doc.select("s-result-item celwidget");
		
		System.out.println(els);
		
		// For every element of the element we assign above
		for(Element el : els)
		{
					try
					{
						name = (el.getElementsByClass("a-size-medium s-inline  s-access-title  a-text-normal").text()).replaceAll("Name: ", "");
						System.out.println(name);
					} 
					catch (Exception e)
					{
						System.out.println("Name not found.");
					}
					
					
					try
					{
						priceString =  ((el.getElementsByClass("a-size-base a-color-price s-price a-text-bold").text().replaceAll("[^0-9.]", "")));
						System.out.println(priceString);
						price = Double.parseDouble(priceString);
						System.out.println(price);


					} 
					catch (NumberFormatException e) 
					{
						e.printStackTrace();
						System.out.println("Price not found.");
					}
					
					// Add the found stuff to our list
					itemList.add(new Items(name, price));
	}
	}
	
}
