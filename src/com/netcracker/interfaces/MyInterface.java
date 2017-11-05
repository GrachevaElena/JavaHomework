package com.netcracker.interfaces;
import com.netcracker.library.*;
import com.netcracker.exceptions.*;
import javax.swing.*;
import java.awt.*;

public class MyInterface {
    private static void createAndShowGUI() {//Create and set up the window.
        JFrame frame = new JFrame("Библиотека");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setSize(800, 500);
        frame.setLocation(150, 100);

        //frame.setLayout(new BorderLayout());

        Library libr=new Library();
        JTable table=new JTable(libr);
        JScrollPane jScrollPane=new JScrollPane(table);
        frame.add(jScrollPane, "Center");

        JPanel northPanel=new JPanel();
        SetNorthPanel(northPanel, frame.getWidth(), frame.getHeight()/20);
        northPanel.setSize(frame.getWidth(),frame.getHeight());
        frame.add(northPanel,"North");

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
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

}
