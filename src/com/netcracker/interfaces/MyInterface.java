package com.netcracker.interfaces;
import com.netcracker.listeners.MyFileListener;
import com.netcracker.library.*;
import com.netcracker.exceptions.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyInterface implements MyFileListener{
    private static JFrame frame;
    private static Library libr;
    private static JTable table;
    private static boolean f=false;

    @Override
    public void update() {
        DialogOk d=new DialogOk("Работа с базой данных успешно завершена", frame);
    }

    private void createAndShowGUI() {

        frame = new JFrame("Библиотека");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setSize(800, 500);
        frame.setLocation(150, 100);

        libr=new Library(this);
        table=new JTable(libr);
        JScrollPane jScrollPane=new JScrollPane(table);
        frame.add(jScrollPane, "Center");

        SetSouthPanel();

        libr.fireTableDataChanged();
        frame.setVisible(true);

    }

    public void SetSouthPanel(){
        JButton bAdd=new JButton("Добавить");
        bAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Add();
            }
        });
        JButton bRem=new JButton("Удалить");
        bRem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DialogYesNo d=new DialogYesNo(frame,"Вы действительно хотите удалить выбранную запись?",true);
                if (d.f) Rem(table.getSelectedRow());
            }
        });
        JButton bEdit=new JButton("Редактировать");
        bEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Edit(table.getSelectedRow());
            }
        });
        JButton bSave=new JButton("Сохранить");
        bSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Save();
            }
        });

        SetButtonsInCorner(frame, bSave, bAdd, bRem, bEdit);
    }


    private void Save(){
        libr.save();
    }

    private void Add() {
        try {
            DialogBook d = new DialogBook(frame, "Новая книга", new Book());
            if (d.f) libr.add(d.book);
        } catch (ExceptionBookIsExist e) {
            new DialogOk(e.toString(), frame);
        }
    }


    private void Rem(int index){
        try{
            libr.remove(index);
        }
        catch (ExceptionInvalidIndex e){
            new DialogOk(e.toString(), frame);
        }
    }
    private void Edit(int index){
        try{
            DialogBook d = new DialogBook(frame, "Редактирование", libr.getBook(index));
            if (d.f) libr.edit(index, d.book);
        } catch (ExceptionInvalidIndex e){
            new DialogOk(e.toString(), frame);
        }
    }

    public static void SetButtonsInCorner(Window d, JButton ... b){
        JPanel dp=new JPanel();
        dp.setLayout(new FlowLayout(FlowLayout.RIGHT));
        JPanel grid=new JPanel();
        grid.setLayout(new GridLayout(1,0,d.getWidth()/40,0));
        for (int i=0; i<b.length; i++)
            grid.add(b[i]);
        dp.add(grid);
        d.add(dp, "South");
    }


    public static void main(String[] args) {
        MyInterface interf=new MyInterface();
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                interf.createAndShowGUI();
            }
        });
    }

}
