package com.sainsburys.scraper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.sainsburys.model.Item;
import com.sainsburys.model.Results;
import com.sainsburys.view.ConsoleDisplay;

public class PageScraperSainsburysImpl implements PageScraper {
	
	Results results;
	ConsoleDisplay console;
	
	// Inject dependencies
	public PageScraperSainsburysImpl(Results results, ConsoleDisplay console){
		this.results = results;
		this.console = console;
	}

	public void scrapePage(String url) {

		List<Item> items = new ArrayList<Item>();
		ItemScraper itemScraper = new ItemScraperSainsburysImpl();
		
		try {

			// Get the list of items and loop over
        	Document doc = Jsoup.connect(url).get(); 	
        	Element elements = doc.getElementsByClass("productLister").first();
        	Elements elementsList = elements.getElementsByClass("gridItem");
        	 	
        	for (Element e : elementsList) {
				
        		Element productInfoElement = e.getElementsByClass("productInfo").first();
				Element a = productInfoElement.select("a").first();
				String unformatLink = a.attr("href");
				String link = "https://jsainsburyplc.github.io/serverside-test/site/www.sainsburys.co.uk/" + unformatLink.substring(unformatLink.indexOf('s'));
				// check individual item and add to list
				items.add(itemScraper.scrapeItemDetails(link));
				
			}
        	
    		results.setResults(items);
    		results.setTotal(calculateTotal(items));
    		
        } catch (IOException e) {
			e.printStackTrace();
		}
		
		// display output
		console.displayResultsAsJson(results);
		
	}
	
	public Float calculateTotal(List<Item> items){
		
		Float total = 0.0f;
		
		for (Item item : items) {
			if (item.getUnitPrice() != null){
				total += item.getUnitPrice();
			}
		}
		
		return total;
	}
}
