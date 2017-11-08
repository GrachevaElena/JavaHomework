package com.netcracker.interfaces;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DialogYesNo {
    JDialog dialog;
    boolean f;

    public DialogYesNo(JFrame frame, String text, boolean modal){
        dialog=new JDialog(frame, modal);
        dialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        dialog.setSize(450, 100);
        dialog.setLocation(350,300);

        JButton b1=new JButton("Да");
        JButton b2=new JButton("Нет");

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f=true;
                dialog.setVisible(false);
            }
        });
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f=false;
                dialog.setVisible(false);
            }
        });

        MyInterface.SetButtonsInCorner(dialog,b1,b2);

        JPanel cp=new JPanel();
        cp.setLayout(new FlowLayout(FlowLayout.CENTER));
        cp.add(new JLabel(text));
        dialog.add(cp);

        dialog.setVisible(true);
    }
}
