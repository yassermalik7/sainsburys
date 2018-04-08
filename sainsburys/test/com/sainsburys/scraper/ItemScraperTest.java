package com.sainsburys.scraper;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.sainsburys.model.Item;

public class ItemScraperTest 
{

	private ItemScraper itemScraper;

	@Before
	public void setUp() throws Exception 
	{
		itemScraper = new ItemScraperSainsburysImpl();
	}

	@After
	public void tearDown() throws Exception 
	{
		itemScraper = null;
	}

	@Test
	public void basicTests() 
	{
		Item item = itemScraper.scrapeItemDetails("https://jsainsburyplc.github.io/serverside-test/site/www.sainsburys.co.uk/shop/gb/groceries/berries-cherries-currants/sainsburys-blueberries--so-organic-150g.html");
		assertNotNull(item);
		assertTrue(item.getUnitPrice() == 2.00f);
	}
}
