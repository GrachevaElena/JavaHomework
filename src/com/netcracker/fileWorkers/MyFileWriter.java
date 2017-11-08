package com.netcracker.fileWorkers;

import com.netcracker.listeners.MyFileListener;
import com.netcracker.listeners.MyFileListeningSubject;
import com.netcracker.library.Book;

import javax.swing.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MyFileWriter extends SwingWorker<Boolean, String> implements MyFileListeningSubject {

    private List<Book> books;

    List<MyFileListener> listeners= new ArrayList();

    @Override
    public void addListener(MyFileListener l){
        listeners.add(l);
    }

    @Override
    public void notifyDataUpdated(){
        for (MyFileListener l:listeners)
            l.update();
    }


    public Boolean startWriting(List<Book> books){
        this.books=books;
        return doInBackground();
    }

    public void write(){
        File file = new File("myFile.txt");
        try (FileWriter fr = new FileWriter(file)){
            for (Book b:books) {
                fr.write(b.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected Boolean doInBackground() {
        write();
        notifyDataUpdated();
        return true;
    }
}
