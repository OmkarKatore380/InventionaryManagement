package com.example.InventionaryManagement.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class ItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
private long id;
private String name;
private String description;
private double price;
public long getId() {
    return id;
}
public void setId(long id) {
    this.id = id;
}
public String getName() {
    return name;
}
public void setName(String name) {
    this.name = name;
}
public String getDescription() {
    return description;
}
public void setDescription(String description) {
    this.description = description;
}
public double getPrice() {
    return price;
}
public void setPrice(double price) {
    this.price = price;
}

}
/** 1. What is Inventory Management System API? (Simple Explanation)

Imagine you have a shop with 5 lakh products.

Example:

id	  name	      price
1	  Keyboard	  500
2	  Laptop	  55000
3	  Mouse	      300
…	…	…
500000	Charger	700

If a client asks:

“Give me all items”

You CANNOT return 5 Lakh products in one API response.

Why?

It will hang the browser

It will overflow memory

It will slow down backend

It is not user friendly

So we use:

Pagination

Return limited items like:

10 items only

20 items only

start from page 0

sort by price/name

This is what Project 5 is about.

2. Example of Pagination (Simple)

You open Amazon.

You never see:

10,000 products on 1 page

You see:

Page 1 → 10 items
Page 2 → 10 items
Page 3 → 10 items

Same thing we are building.

**3. What is This JSON?

GET /items/list
{ "page": 0, "size": 10, "sortBy": "name" }**

This is a request from frontend:

They send this JSON so backend knows:

page: 0 → show first page

size: 10 → show 10 items

sortBy: "name" → order by name

This is NOT a database.
This is NOT data.
This is instructions for backend.

Like telling:
“Show me page 0, only 10 items, sorted by name.”

**4. What is This Response JSON?

{
"items": [
{ "name": "Keyboard", "price": 500 }
],
"page": 0,
"size": 10,
"totalItems": 35,
"totalPages": 4
}**

This is the backend’s answer.

Let’s break it simple:

"items": [...]

These are 10 items from the database.

"page": 0

You are on page 0.

"size": 10"

You asked for 10 items.

"totalItems": 35

There are total 35 items in database.

"totalPages": 4

If each page has 10 items:

35 total items

10 items per page

total pages = 4

5. Why This Is Required?

Because real-world apps NEVER return all data.

Examples:

Amazon listing → pagination
Flipkart search → pagination
Zomato restaurants → pagination
YouTube videos → pagination

BIG data = MUST use pagination.

6. Why DTO?

Because DTO:

protects your entity

hides your database structure

cleans API

gives frontend-only required fields

Example:

Entity has 15 fields
DTO returns only 4 important fields

7. Why @RequestBody Instead of @RequestParam?

Because you want to send JSON request body:

{
  "page": 0,
  "size": 10,
  "sortBy": "name"
}


This is easier for frontend.

8. What Does Controller Actually Do? (Simple)

Example workflow:

Step 1: Frontend asks

“Give me page 0, size 10, sorted by name”

Step 2: Controller reads that JSON

And gives it to service.

Step 3: Service talks to DB

“Fetch 10 items only.”

Step 4: Service converts Entity → DTO
Step 5: Controller returns JSON response. **/