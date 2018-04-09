package com.sainsburys.model;

import java.util.List;

public class Results  
{
	private List<Item> results;
	private Float total;
	
	public List<Item> getResults() 
	{
		return results;
	}
	public void setResults(List<Item> results) 
	{
		this.results = results;
	}
	public Float getTotal() 
	{
		return total; 
	}
	public void setTotal(Float total) 
	{
		this.total = total;
	}
	
	@Override
	public String toString() 
	{
		return "Results [results=" + results + ", total=" + total + "]";
	}
}
