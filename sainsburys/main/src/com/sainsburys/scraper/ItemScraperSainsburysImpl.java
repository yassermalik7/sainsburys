package com.sainsburys.scraper;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.sainsburys.model.Item;


public class ItemScraperSainsburysImpl implements ItemScraper 
{
	
	public Item scrapeItemDetails(String url)
	{
		Item i = new Item();
		
    	try 
    	{
    		// Get the document, find the attributes and add to item object 
			Document doc = Jsoup.connect(url).get();
			i.setTitle(scrapeTitle(doc));
			
			int kal = scrapeKcal(doc);
			//check if calories are available. If they arn't, don't set a value meaning the field won't
			//be added to the resulting Json object
			if (kal != 0)
			{
				i.setKcal(scrapeKcal(doc));
			}
			i.setUnitPrice(scrapeUnitPrice(doc));
			i.setDescription(scrapeDescription(doc));
		} 
    	catch (IOException e) 
    	{
			// Just print the stack trace and leave remaining object fields null
			e.printStackTrace();
		}
		return i;
	}
	
	private String scrapeTitle(Document doc) 
	{
		Element element = doc.getElementsByClass("productTitleDescriptionContainer").first();
		Element eHeader = element.getElementsByTag("h1").first();
		
		return eHeader.text();
	}

	private int scrapeKcal(Document doc) 
	{
		Element element = doc.getElementsByClass("nutritionLevel1").first();
		
		// Three types of placeholders for Kcal value
		// If first method fails then attempt to find Kcal by tableRow0
		if (element == null)
		{
			element = doc.getElementsByClass("tableRow0").first();
		}
		// If Kcal is still null, then attempt to find using selector method
		if (element == null)
		{
			Elements td = doc.select("#mainPart > div:nth-child(2) > div > div > div.tableWrapper > table > tbody > tr:nth-child(2)");
			for(Element el : td)
			{
			  element = el.select("td").first();
			  String text = element.text();
			  int kCalPer100 = Integer.valueOf(text);
			  return kCalPer100;
			}
		}
		// If kcal still not found, it is not present, return 0 for value
		if (element == null)
		{
			return 0;
		}

		String text = element.text();
		// only take the number value from the obtained value
		int kCalPer100 = Integer.valueOf(text.substring(0, text.indexOf("kcal")));
	    
		return kCalPer100;
	}

	private Float scrapeUnitPrice(Document doc) 
	{
		Element element = doc.getElementsByClass("pricePerUnit").first();
		
		String text = element.text();
		Float valuePerUnit = Float.valueOf(text.substring(1, text.indexOf("/unit")));
	    
		return valuePerUnit;
	}

	private String scrapeDescription(Document doc) 
	{
		Element element = doc.getElementsByClass("productText").first();

		return element.text();
	}
}
