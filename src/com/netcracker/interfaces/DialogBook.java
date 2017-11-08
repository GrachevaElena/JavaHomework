package com.netcracker.interfaces;

import com.netcracker.exceptions.ExceptionIncorrectTextFields;
import com.netcracker.exceptions.MyException;
import com.netcracker.library.Author;
import com.netcracker.library.Book;
import com.netcracker.library.MyDate;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class DialogBook {
    JDialog dialog;
    JFormattedTextField[] arrTextFields;
    boolean f=false;
    Book book;
    JFrame frame;
    String[] text={"Название книги:", "Авторы:", "Год издания:", "Дата поступления:", "Количество экземпляров:"};

    public DialogBook(JFrame frame, String title, Book book) {
        this.frame=frame;
        this.book=book;
        dialog = new JDialog(frame,title, true);
        dialog.setLocation(300,100);
        dialog.setSize(500,250);

        JButton b1 = new JButton("Ok");
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    CreateBook();
                    f = true;
                    dialog.setVisible(false);
                } catch (ExceptionIncorrectTextFields exc){
                    new DialogOk(exc.toString(), frame);
                }
            }
        });

        JButton b2 = new JButton("Отмена");
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f=false;
                dialog.setVisible(false);
            }
        });

        MyInterface.SetButtonsInCorner(dialog,b1,b2);

        JPanel p=new JPanel();
        SetCentralPanelForDialogAdd(p,frame);

        dialog.add(p);

        dialog.setVisible(true);
    }

    private void SetCentralPanelForDialogAdd(JPanel p, JFrame frame){
        arrTextFields=new JFormattedTextField[5];

        JPanel[] arrPanels=new JPanel[5];
        JLabel[] arrLabels=new JLabel[5];

        p.setLayout(new GridLayout(5,2,dialog.getWidth()/20,dialog.getHeight()/20));

        for (int i=0; i<5; i++) {
            arrPanels[i]=new JPanel();
            arrPanels[i].setLayout(new FlowLayout(FlowLayout.RIGHT));

            arrLabels[i]=new JLabel(text[i]);
            arrPanels[i].add(arrLabels[i]);
            p.add(arrPanels[i]);

            switch (i) {
                case 0:
                    arrTextFields[i] = new JFormattedTextField();
                    if (book.getName()!=null) arrTextFields[i].setText(book.getName());
                    break;
                case 1:
                    arrTextFields[i] = new JFormattedTextField();
                    if (book.getAuthor()!=null) arrTextFields[i].setText(book.getAuthor().toString());
                    break;
                case 4:
                    arrTextFields[i] = new JFormattedTextField();
                    if (book.getNumCopies()!=-1) arrTextFields[i].setText((new Integer(book.getNumCopies())).toString());
                    break;
                case 3:
                    try {
                        MaskFormatter mf = new MaskFormatter("##.##.####");
                        mf.setPlaceholderCharacter('_');
                        arrTextFields[i] = new JFormattedTextField(mf);
                        if (book.getReceiptDate()!=null) arrTextFields[i].setText(book.getReceiptDate().toString());
                    }catch(java.text.ParseException e){
                        new DialogOk(new MyException().toString(), frame);
                    }
                    break;
                case 2:
                    try {
                        MaskFormatter mf = new MaskFormatter("####");
                        mf.setPlaceholderCharacter('_');
                        arrTextFields[i] = new JFormattedTextField(mf);
                        if (book.getPublishYear()!=-1) arrTextFields[i].setText((new Integer(book.getPublishYear())).toString());
                    }catch(java.text.ParseException e){
                        new DialogOk(new MyException().toString(), frame);
                    }
                    break;

            }

            p.add(arrTextFields[i]);
        }

    }

    private void CreateBook() throws ExceptionIncorrectTextFields{
            SetName();
            SetAuthor();
            SetPublishYear();
            SetReceiptDate();
            SetNumCopies();
    }

    private void SetName() throws ExceptionIncorrectTextFields {
        String s=arrTextFields[0].getText();
        if (!arrTextFields[0].getText().equals(""))
            book.setName(arrTextFields[0].getText());
        else throw new ExceptionIncorrectTextFields(text[0]);
    }

    private void SetAuthor() throws ExceptionIncorrectTextFields {
        if (!arrTextFields[1].getText().equals(""))
            book.setAuthor(new Author(arrTextFields[1].getText()));
        else throw new ExceptionIncorrectTextFields(text[1]);
    }

    private void SetPublishYear() throws ExceptionIncorrectTextFields{
        try {
            int year = Integer.parseInt(arrTextFields[2].getText());
            GregorianCalendar d=new GregorianCalendar();
            if (year>d.get(GregorianCalendar.YEAR)|| year<1000) throw new ExceptionIncorrectTextFields(text[2]);
            book.setPublishYear(year);
        }catch (NumberFormatException e) {
            throw new ExceptionIncorrectTextFields(text[2]);
        }

    }

    private void SetReceiptDate() throws ExceptionIncorrectTextFields{
        try {
            int day, month, year;
            String str = arrTextFields[3].getText();
            day = Integer.parseInt(str.substring(0, 2));
            month = Integer.parseInt(str.substring(3, 5))-1;
            year = Integer.parseInt(str.substring(6, 10));
            MyDate d= new MyDate(str);
            if (d.get(Calendar.YEAR)!=year || d.get(Calendar.MONTH)!=month || d.get(Calendar.DATE)!=day)
                throw new ExceptionIncorrectTextFields(text[3]);
            if (d.after(new MyDate())) throw new ExceptionIncorrectTextFields(text[3]);
            book.setReceiptDate(new MyDate(year,month,day));
        } catch (NumberFormatException e) {
            throw new ExceptionIncorrectTextFields(text[3]);
        }
    }

    private void SetNumCopies() throws ExceptionIncorrectTextFields{
        try {
            int n=Integer.parseInt(arrTextFields[4].getText());
            if (n<=0) throw new ExceptionIncorrectTextFields(text[4]);
            book.setNumCopies(n);
        } catch (NumberFormatException e) {
            throw new ExceptionIncorrectTextFields(text[4]);
        }
    }
}
