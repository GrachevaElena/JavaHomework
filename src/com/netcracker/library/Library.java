package com.netcracker.library;
import java.io.*;
import java.util.List;
import java.util.ArrayList;
import com.netcracker.exceptions.*;
import com.netcracker.fileWorkers.MyFileReader;
import com.netcracker.fileWorkers.MyFileWriter;
import com.netcracker.listeners.MyFileListener;
import javax.swing.table.AbstractTableModel;

public class Library extends AbstractTableModel implements MyFileListener{
    private File f;
    private List<Book> books;
    private int nCol = 5;

    private MyFileWriter fileWriter=new MyFileWriter();
    private MyFileReader fileReader=new MyFileReader();

    @Override
    public void update() {
        if (fileReader.isChanged()) {
            this.books = fileReader.getBooks();
            fireTableDataChanged();
        }
    }

    public Library(MyFileListener l) {
        books = new ArrayList();

        fileReader.addListener(l);
        fileWriter.addListener(l);
        fileReader.addListener(this);

        fileReader.startReading(books);
    }

    public void add(Book book) throws ExceptionBookIsExist {
        if (!books.contains(book)) {
            books.add(book);
            fireTableDataChanged();
        } else throw new ExceptionBookIsExist();
    }

    public void remove(int index) throws ExceptionInvalidIndex {
        if (index>=0 && index<size()) {
            books.remove(index);
            fireTableDataChanged();
        } else throw new ExceptionInvalidIndex();
    }

    public void edit(int index, Book newBook) throws ExceptionInvalidIndex {
        if (index>=0 && index<size()) {
            books.set(index, newBook);
            fireTableDataChanged();
        } else throw new ExceptionInvalidIndex();
    }

    public void save(){
        fileWriter.startWriting(books);
    }

    public Book getBook(int index) throws ExceptionInvalidIndex {
        if (index>=0 && books.size() > index)
            return books.get(index);
        else throw new ExceptionInvalidIndex();
    }

    public int size() {
        return books.size();
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
                return "Автор";
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
                return b.getAuthor();
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
                return MyDate.class;
            case 4:
                return Integer.class;
        }
        return Object.class;
    }

}
