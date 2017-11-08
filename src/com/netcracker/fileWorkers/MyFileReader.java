package com.netcracker.fileWorkers;

import com.netcracker.listeners.MyFileListener;
import com.netcracker.listeners.MyFileListeningSubject;
import com.netcracker.library.Author;
import com.netcracker.library.Book;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MyFileReader extends SwingWorker<Boolean, String> implements MyFileListeningSubject {

    private List<Book> books;
    boolean f=false;

    List<MyFileListener> listeners= new ArrayList();


    public List<Book> getBooks(){
        f=false;
        return books;
    }

    public boolean isChanged(){
        return f;
    }

    @Override
    public void addListener(MyFileListener l){
        listeners.add(l);
    }

    @Override
    public void notifyDataUpdated(){
        for (MyFileListener l:listeners)
            l.update();
    }

    protected void read(){
        try (BufferedReader reader = new BufferedReader(new FileReader("myFile.txt"));){
            String line;
            Book book=new Book();
            for(int i=0; (line = reader.readLine()) != null;i++) {
                switch(i%5){
                    case 0:
                        book.setName(line);
                        break;
                    case 1:
                        book.setAuthor(new Author(line));
                        break;
                    case 2:
                        book.setPublishYear(Integer.parseInt(line));
                        break;
                    case 3:
                        book.setReceiptDate(line);
                        break;
                    case 4:
                        book.setNumCopies(Integer.parseInt(line));
                        books.add(book);
                        book=new Book();
                        break;
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void startReading(List<Book> books){
        this.books=books;
        f=doInBackground();
    }

    @Override
    protected Boolean doInBackground(){
        read();
        notifyDataUpdated();
        return true;
    }

}
