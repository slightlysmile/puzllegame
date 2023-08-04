package com.itheima.test;

import javax.swing.*;
import java.awt.event.*;
import java.util.Random;

public class MyFrame extends JFrame implements ActionListener, MouseListener,KeyListener {
    JButton btn1 = new JButton("btn1");

    public MyFrame() {
        this.setSize(603, 680);
        this.setTitle("拼图游戏 v1.0");
        this.setAlwaysOnTop(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(3);
        this.setLayout(null);
        this.setVisible(true);

        btn1.setBounds(100, 0, 100, 50);
        btn1.addActionListener(this);
        btn1.addMouseListener(this);
        this.getContentPane().add(btn1);
        this.addKeyListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btn1) {
            btn1.setSize(200, 200);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("点击");
    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("按住");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println("松开");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        System.out.println("划入");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        System.out.println("划出");
    }

    @Override
    public void keyTyped(KeyEvent e) {
        System.out.println("按下不松");
    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("按下不松");
    }

    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println("松开按键");
        int code = e.getKeyCode();
        System.out.println((char)(code));
    }
}
