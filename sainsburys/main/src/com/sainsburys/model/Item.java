package com.sainsburys.model; 
 
public class Item {
	private String title;
	private int kcal_per_100g;
	private Float unitPrice;
	private String description;
	
	public Item(){
	}
	
	public Item(String title, int kcal, Float unitPrice, String description) {
		super();
		this.title = title;
		this.kcal_per_100g = kcal;
		this.unitPrice = unitPrice;
		this.description = description;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getKcal() {
		return kcal_per_100g;
	}
	public void setKcal(int kcal) {
		this.kcal_per_100g = kcal;
	}
	public Float getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(Float unitPrice) {
		this.unitPrice = unitPrice;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String toString() {
		return "Item [title=" + title + ", kcal_per_100g=" + kcal_per_100g + ", unitPrice="
				+ unitPrice + ", description=" + description + "]";
	}
	
}
