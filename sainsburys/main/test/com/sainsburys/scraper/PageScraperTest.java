package com.sainsburys.scraper;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.sainsburys.model.Constants;
import com.sainsburys.model.Results;
import com.sainsburys.view.ConsoleDisplay;

public class PageScraperTest 
{
	private PageScraper pageScraper;
	private Results results;

	@Before
	public void setUp() throws Exception 
	{
		results = new Results();
		pageScraper = new PageScraperSainsburysImpl(results, new ConsoleDisplay());
	}

	@After
	public void tearDown() throws Exception 
	{
		pageScraper = null;
	}
	
	@Test
	public void testTotal()
	{
		pageScraper.scrapePage(Constants.SAINSBURYS_PRODUCTS_URL);
		assertTrue(results.getTotal() > 0.0f);
		assertTrue(results.getResults().size() == 17);
	}	
}
