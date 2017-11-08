package com.netcracker.interfaces;

import com.netcracker.exceptions.MyException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DialogOk {
    JDialog dialog;

    public DialogOk(String text, JFrame frame) {
        dialog = new JDialog(frame, true);
        dialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        dialog.setSize(400, 100);
        dialog.setLocation(350, 300);

        setDialog();

        JPanel cp = new JPanel();
        cp.setLayout(new FlowLayout(FlowLayout.CENTER));
        cp.add(new JLabel(text));
        dialog.add(cp);

        dialog.setVisible(true);
    }

    private void setDialog(){
        JButton b1 = new JButton("Ok");
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dialog.setVisible(false);
            }
        });


        MyInterface.SetButtonsInCorner(dialog, b1);
    }

}
