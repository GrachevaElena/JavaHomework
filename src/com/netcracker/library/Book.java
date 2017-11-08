package com.netcracker.library;
import java.io.Serializable;
import java.util.*;

public class Book implements Serializable{
    private String name;
    private Author author;
    private int publishYear;
    private MyDate receiptDate;
    private int numCopies;

    public Book() {
        name=null;
        author=null;
        publishYear=-1;
        receiptDate=null;
        numCopies=-1;
    }

    public Book(String name, Author author, int publishYear, MyDate receiptDate, int numCopies) {
        this.name = name;
        this.author = author;
        this.publishYear = publishYear;
        this.receiptDate=receiptDate;
        this.numCopies = numCopies;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public int getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(int publishYear) {
        this.publishYear = publishYear;
    }

    public MyDate getReceiptDate() {
        return receiptDate;
    }

    public void setReceiptDate(MyDate receiptDate) {
        this.receiptDate=receiptDate;
    }

    public void setReceiptDate(String line){
        setReceiptDate(new MyDate(line));
    }

    public int getNumCopies() {
        return numCopies;
    }

    public void setNumCopies(int numCopies) {
        this.numCopies = numCopies;
    }

    @Override
    public String toString() {
        return
                name + "\r\n" + author +
                        "\r\n" + publishYear +
                        "\r\n" + receiptDate +
                        "\r\n" + numCopies +
                        "\r\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        if (publishYear != book.publishYear) return false;
        if (!name.equals(book.name)) return false;
        return author.equals(book.author);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + author.hashCode();
        result = 31 * result + publishYear;
        return result;
    }
}
