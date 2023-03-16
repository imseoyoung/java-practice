package com.sylim.practice.examUp3;

import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) throws ParseException {
        List<Book> books = new ArrayList<>();
        SimpleDateFormat format = new SimpleDateFormat("yyyy/mm/dd");
        
        books.add(new Book("오준석의 생존코딩", format.parse("2021/05/28"), "플러터"));
        books.add(new Book("이펙티브 자바", format.parse("2018/11/01"), "자바"));
        books.add(new Book("오준석의 안드로이드 생존코딩", format.parse("2021/12/17"), "코틀린"));
        
        Collections.sort(books);
        System.out.println(books);
        
        Book book = new Book("서영", format.parse("1999/01/28"), "생일");
        Book bookCopy = book.clone();
       
        System.out.println(book);
        System.out.println(bookCopy);
    }
}