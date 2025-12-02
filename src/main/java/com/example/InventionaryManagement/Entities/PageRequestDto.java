package com.example.InventionaryManagement.Entities;

public class PageRequestDto {
private int page;
private int size;
private String sortBy;
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
public void setSortBy(String sortBy) {
    this.sortBy = sortBy;
}

}
