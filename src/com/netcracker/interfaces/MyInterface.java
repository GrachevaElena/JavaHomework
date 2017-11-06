package com.netcracker.interfaces;
import com.netcracker.library.*;
import com.netcracker.exceptions.*;
import com.sun.xml.internal.ws.message.jaxb.JAXBMessage;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyInterface {
    private static JFrame frame;
    private static Library libr;
    private static JTable table;
    private static boolean f=false;

    private static void createAndShowGUI() {//Create and set up the window.
        frame = new JFrame("Библиотека");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setSize(800, 500);
        frame.setLocation(150, 100);

        //frame.setLayout(new BorderLayout());

        libr=new Library();
        table=new JTable(libr);
        JScrollPane jScrollPane=new JScrollPane(table);
        frame.add(jScrollPane, "Center");

        JPanel northPanel=new JPanel(), southPanel=new JPanel();
        SetNorthPanel(northPanel, frame.getWidth(), frame.getHeight()/20);
        SetSouthPanel(southPanel, frame.getWidth(), frame.getHeight()/20);
        frame.add(northPanel,"North");
        frame.add(southPanel, "South");

        frame.setVisible(true);
    }

    private static void SetNorthPanel(JPanel panel, int w, int h){

        JTextField tN=new JTextField();
        JTextField tA=new JTextField();
        JLabel l=new JLabel("Поиск:");
        JLabel lN=new JLabel("  название");
        JLabel lA=new JLabel("       авторы");

        JPanel grid=new JPanel();
        grid.setLayout(new GridLayout(1,5,w/80, h/20));
        grid.add(l);
        grid.add(lN);
        grid.add(tN);
        grid.add(lA);
        grid.add(tA);

        panel.setLayout(new FlowLayout(FlowLayout.CENTER));
        panel.add(grid);
    }

    public static void SetSouthPanel(JPanel panel, int w, int h){
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
                f=false;
                CreateDialog("Вы действительно хотите удалить выбранную запись?",true);
                if (f) Rem(table.getSelectedRow());
            }
        });
        JButton bEdit=new JButton("Редактировать");
        bEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Edit(table.getSelectedRow());
            }
        });

        JPanel grid=new JPanel();
        grid.setLayout(new GridLayout(1,3,w/80, h/20));
        grid.add(bAdd);
        grid.add(bRem);
        grid.add(bEdit);

        panel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        panel.add(grid);

    }

    private static void Add(){
         JTextField[] arrf=new JTextField[5];
         for (int i=0; i<5; i++)
             arrf[i]=new JTextField();

         JFormattedTextField date=new JFormattedTextField();
         try {
             MaskFormatter mf = new MaskFormatter("##.##.####");
             mf.setPlaceholderCharacter('_');
             date = new JFormattedTextField(mf);
         } catch (java.text.ParseException e) {
             CreateDialogError(new MyException());
         }

         f=false;
         CreateDialogBook( "Добавление книги",arrf, date);
         if (f) {
             try {
                 libr.add(CreateBook(arrf, date));
             }catch (ExceptionBookIsExist e){
                 CreateDialogError(e);
             }
         }
    }
    private static void Rem(int index){
        try{
            libr.remove(index);
        }
        catch (ExceptionInvalidIndex e){
            CreateDialogError(e);
        }
    }
    private static void Edit(int index){

    }

    private static void CreateDialogBook(String title, JTextField[] arrf, JFormattedTextField date) {

        JDialog d = new JDialog(frame,title);
        int w=400, h=300;
        d.setLocation(300,100);
        d.setSize(w,h);

        JButton b1 = new JButton("Ok");
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f=true;
                d.setVisible(false);
            }
        });

        JButton b2 = new JButton("Отмена");
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f=false;
                d.setVisible(false);
            }
        });

        SetTwoButtonsInCorner(d,b1,b2);

        JPanel p=new JPanel();
        SetCentralPanelForDialogAdd(p, arrf, date);

        d.add(p);

        d.setVisible(true);
    }
    private static Book CreateBook(JTextField[] arrf, JFormattedTextField date){
        return new Book();
    }
    private static void SetCentralPanelForDialogAdd(JPanel p,JTextField[] arrf, JFormattedTextField date){
        JPanel[] arrp=new JPanel[5];
        JLabel[] arrl=new JLabel[5];
        String[] text={"Название книги:", "Авторы:", "Год издания:", "Дата поступления:", "Количество экземпляров:"};
        p.setLayout(new GridLayout(5,2,frame.getWidth()/20,frame.getHeight()/20));
        for (int i=0; i<5; i++) {
            arrp[i]=new JPanel();
            arrp[i].setLayout(new FlowLayout(FlowLayout.RIGHT));
            arrl[i]=new JLabel(text[i]);
            arrp[i].add(arrl[i]);
            p.add(arrp[i]);
            if (i!=3) {
                p.add(arrf[i]);
            }
            else {
                p.add(date);

            }
        }

    }


    private static void CreateDialog(String text, boolean modal){
        JDialog d=new JDialog(frame, modal);
        d.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        int w=300, h=100;
        d.setSize(w, h);
        d.setLocation(350,300);

        JButton b1=new JButton("Да");
        JButton b2=new JButton("Нет");

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f=true;
                d.setVisible(false);
            }
        });

        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f=false;
                d.setVisible(false);
            }
        });


        SetTwoButtonsInCorner(d,b1,b2);

        JPanel cp=new JPanel();
        cp.setLayout(new FlowLayout(FlowLayout.CENTER));
        cp.add(new JLabel("Удалить выделенную запись?"));
        d.add(cp);

        d.setVisible(true);
    }

    private static void CreateDialogError(MyException e){
        JDialog d=new JDialog(frame, true);
        d.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        int w=300, h=100;
        d.setSize(w, h);
        d.setLocation(350,300);

        JButton b1=new JButton("Ok");

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                d.setVisible(false);
            }
        });

        JPanel cp=new JPanel();
        cp.setLayout(new FlowLayout(FlowLayout.CENTER));
        cp.add(new JLabel(e.toString()));
        d.add(cp);

        SetOneButtonInCorner(d,b1);

        d.setVisible(true);
    }

    private static void SetTwoButtonsInCorner(JDialog d, JButton b1, JButton b2){
        JPanel dp=new JPanel();
        dp.setLayout(new FlowLayout(FlowLayout.RIGHT));
        JPanel grid=new JPanel();
        grid.setLayout(new GridLayout(1,2,d.getWidth()/40,0));
        grid.add(b1);
        grid.add(b2);
        dp.add(grid);
        d.add(dp, "South");
    }
    private static void SetOneButtonInCorner(JDialog d, JButton b){
        JPanel dp=new JPanel();
        dp.setLayout(new FlowLayout(FlowLayout.RIGHT));
        JPanel grid=new JPanel();
        grid.setLayout(new GridLayout(1,2,d.getWidth()/40,0));
        grid.add(b);
        dp.add(grid);
        d.add(dp, "South");
    }


    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

}
