package com.sylim.practice;

public class Book extends TangibleAsset {
    private String isbn;
    
    public Book(String name, int price, String color, String isbn) {
        super(name, price, color);
        this.isbn = isbn;
    }
    
    @Override    
    public String getName() {
        return getName();
    };
    @Override
    public int getPrice() {
        return getPrice();
    };
    @Override
    public String getColor() {
        return getColor();
    };

    public String getIsbn() {
        return getIsbn();
    };
}
