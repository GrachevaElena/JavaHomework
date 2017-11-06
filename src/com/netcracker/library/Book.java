package com.netcracker.library;
import java.util.*;

public class Book {
    private String name;
    private Author[] authors;
    private int publishYear;
    private Date receiptDate;
    private int numCopies;

    public Book() {
    }

    public Book(String name, Author[] authors, int publishYear, Date receiptDate, int numCopies) {
        this.name = name;
        this.authors = authors;
        this.publishYear = publishYear;
        this.receiptDate = receiptDate;
        this.numCopies = numCopies;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        name = name;
    }

    public Author[] getAuthors() {
        return authors;
    }

    public void setAuthors(Author[] authors) {
        this.authors = authors;
    }

    public int getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(int publishYear) {
        this.publishYear = publishYear;
    }

    public Date getReceiptDate() {
        return receiptDate;
    }

    public void setReceiptDate(Date receiptDate) {
        this.receiptDate = receiptDate;
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
                "Название: \"" + name + '\"' +
                "\n Авторы: " + Arrays.toString(authors) +
                "\n Год публикации: " + publishYear +
                "\n Дата поступления: " + receiptDate +
                "\n Число экземпляров: " + numCopies +
                '\n';
    }
}
