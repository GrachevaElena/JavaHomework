package com.netcracker.library;
import java.io.*;
import java.util.List;
import java.util.ArrayList;
import com.netcracker.exceptions.*;
import java.util.*;

import javax.swing.table.AbstractTableModel;

public class Library extends AbstractTableModel {
    private File f;
    private List<Book> books;
    private static int n = 0;
    private int nCol = 5;

    public Library() {
        //чтение из файла в список
        books = new ArrayList();
        Author[] a = new Author[1];
        a[0] = new Author("author1");
        books.add(new Book("book1", a, 1995, new Date(), 2));
    }

    void add(Book book) throws ExceptionBookIsExist {
        if (!books.contains(book)) {
            books.add(book);
            //перезаписать в файл
            fireTableDataChanged();
        } else throw new ExceptionBookIsExist();
    }

    void remove(Book book) throws ExceptionBookNotExist {
        if (books.contains(book)) {
            books.remove(book);
            //перезаписать в файл
            fireTableDataChanged();
        } else throw new ExceptionBookNotExist();
    }

    void edit(int num, Book newBook) throws ExceptionBookNotExist {
        if (books.contains(newBook)) {
            books.set(num, newBook);
            //перезаписать в файл
            fireTableDataChanged();
        } else throw new ExceptionBookNotExist();
    }

    Book getBook(int index) throws ExceptionInvalidIndex {
        if (books.size() > index)
            return books.get(index);
        else throw new ExceptionInvalidIndex();
    }

    int size() {
        return books.size();
    }

    Book[] findBookByName(String str) {
        //изменяет список
        List res = new ArrayList();
        for (Book b : books)
            if (b.getName().contains(str))
                res.add(b);
        return (Book[]) res.toArray();
    }

    Book[] findBookByAuthor(String authName) {
        //изменяет список
        List res = new ArrayList();
        for (Book b : books)
            for (Author a : b.getAuthors())
                if (a.getName().contains(authName))
                    res.add(b);
        return (Book[]) res.toArray();
    }

    @Override
    public int getColumnCount() {
        return nCol;
    }

    @Override
    public int getRowCount() {
        return size();
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Название";
            case 1:
                return "Авторы";
            case 2:
                return "Год издания";
            case 3:
                return "Дата поступления";
            case 4:
                return "Количество экземпляров";
            default:
                return "";
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Book b = books.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return b.getName();
            case 1:
                String str = Arrays.toString(b.getAuthors());
                return str.substring(1, str.length() - 1);
            case 2:
                return b.getPublishYear();
            case 3:
                return b.getReceiptDate();
            case 4:
                return b.getNumCopies();
        }
        return null;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return String.class;
            case 1:
                return String.class;
            case 2:
                return Integer.class;
            case 3:
                return Date.class;
            case 4:
                return Integer.class;
        }
        return Object.class;
    }


}
