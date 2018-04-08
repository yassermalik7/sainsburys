package com.sainsburys.scraper;

import com.sainsburys.model.Item;

public interface ItemScraper {
	public Item scrapeItemDetails(String url);

}
