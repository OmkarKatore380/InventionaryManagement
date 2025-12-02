package com.example.InventionaryManagement.Entities;

public class ItemFilterDto {
private double minPrice;
private double maxPrice;
private int page;
private int size;
private String sortBy;
public double getMinPrice() {
    return minPrice;
}
public void setMinPrice(double minPrice) {
    this.minPrice = minPrice;
}
public double getMaxPrice() {
    return maxPrice;
}
public void setMaxPrice(double maxPrice) {
    this.maxPrice = maxPrice;
}
 public int getPage() {
    return page;
}
public void setPage(int page) {
    this.page = page;
} 
public int getSize() {
    return size;
}
public void setSize(int size) {
    this.size = size;
}
public String getSortBy() {
    return sortBy;
}
public void setSortBy(String sortby) {
    this.sortBy = sortby;
}

}