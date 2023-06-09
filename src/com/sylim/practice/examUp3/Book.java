package com.sylim.practice.examUp3;

import java.util.Date;
import java.util.Objects;

public class Book implements Comparable<Book> {
    private String title;
    private Date publishDate;
    private String comment;   
    
    public Book(String title, Date publishDate, String comment) {
        this.title = title;
        this.publishDate = publishDate;
        this.comment = comment;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public Date getPublishDate() {
        return publishDate;
    }
    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }
    public String getComment() {
        return comment;
    }
    public void setComment(String comment) {
        this.comment = comment;
    }
    
    @Override
    public String toString() {
        return "Book [title=" + title + ", publishDate=" + publishDate + ", comment=" + comment
                + "]";
    }
    @Override
    public int hashCode() {
        return Objects.hash(publishDate, title);
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Book other = (Book) obj;
        return Objects.equals(publishDate, other.publishDate) && Objects.equals(title, other.title);
    }
    @Override
    public int compareTo(Book book) {
        return this.publishDate.compareTo(book.publishDate);
    }
    
    // 현재 cloneable이 권장되지 않는 사용 방법으로, 굳이 clone이라는 method를 사용할 필요는 없다.
    // 따라서, copy라는 복사하는 method를 따로 만들어 사용했다.
    public Book copy() {
        Book result = new Book(title, publishDate, comment);
        result.title = this.title;
        result.publishDate = (Date) this.publishDate.clone();
        result.comment = this.comment;
        return result;
    }
}
