package com.sainsburys.app;

import com.sainsburys.model.Constants;
import com.sainsburys.model.Results;
import com.sainsburys.scraper.PageScraper;
import com.sainsburys.scraper.PageScraperSainsburysImpl;
import com.sainsburys.view.ConsoleDisplay;

/**
 * Application to scrape Sainsburys product pages
 *
 */
public class App 
{
	
    public static void main( String[] args )
    {
        // Starts the application.
    	System.out.println("Starting Application!");
        
        ConsoleDisplay console = new ConsoleDisplay();
        Results results = new Results();
        PageScraper scraper = new PageScraperSainsburysImpl(results, console);
        
        // Hard coded URL (but we could just alter this to args[0] and expect URL to be passed in). 
        scraper.scrapePage(Constants.SAINSBURYS_PRODUCTS_URL);
        
        System.out.println("Ending Application!");
        
    }
}
