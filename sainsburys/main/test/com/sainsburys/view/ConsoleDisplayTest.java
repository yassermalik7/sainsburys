package com.sainsburys.view;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.sainsburys.model.Item;
import com.sainsburys.model.Results;

public class ConsoleDisplayTest
{
	private ConsoleDisplay consoleDisplay;
	private Results results;
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

	@Before
	public void setUp() throws Exception
	{
		consoleDisplay = new ConsoleDisplay();
		System.setOut(new PrintStream(outContent));
		
        Item i1 = new Item("itemA", 54, 1.1f, "descA");
        List<Item> items = new ArrayList<Item>();
        items.add(i1);
        
        results = new Results();
        results.setResults(items);
        results.setTotal(1.1f);
        
	}

	@After
	public void tearDown() throws Exception 
	{
		consoleDisplay = null;
		results = null;
		System.setOut(null);
	}
	
	@Test
	public void displayResultTest()
	{
		consoleDisplay.displayResultsAsJson(results);
		Assert.assertTrue(outContent.toString().contains("itemA"));
	}
}
