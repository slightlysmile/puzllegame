package com.itheima.ui;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class GameJframe extends JFrame implements KeyListener, ActionListener {
    int[][] data = new int[4][4];
    int x;
    int y;
    JMenuItem replayItem = new JMenuItem("重新游戏");
    JMenuItem reLoginItem = new JMenuItem("重新登录");
    JMenuItem closeItem = new JMenuItem("关闭游戏");
    JMenuItem accountItem = new JMenuItem("公众号");
    JMenuItem girl = new JMenuItem("美女");
    JMenuItem animal = new JMenuItem("动物");
    JMenuItem sport = new JMenuItem("运动");
    String choose = "image\\animal\\animal";
    int step = 0;
    int num = getNum(9);

    public GameJframe() {
        initJframe();
        initJmebuBar();
        initData();
        initImage();
        this.setVisible(true);
    }

    private void initData() {
        int[] tempArr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        Random r = new Random();
        for (int i = 0; i < tempArr.length; i++) {
            int index = r.nextInt(tempArr.length);
            int temp;
            temp = tempArr[i];
            tempArr[i] = tempArr[index];
            tempArr[index] = temp;
        }
        for (int i = 0; i < tempArr.length; i++) {
            if (tempArr[i] == 0) {
                x = i / 4;
                y = i % 4;
            }
            data[i / 4][i % 4] = tempArr[i];
        }


    }

    private void initImage() {
        this.getContentPane().removeAll();
        if (isWin()) {
            JLabel jLabel = new JLabel(new ImageIcon("image\\win.png"));
            jLabel.setBounds(203, 283, 197, 73);
            this.getContentPane().add(jLabel);
        }
        JLabel stepJLabel = new JLabel("步数" + step);
        stepJLabel.setBounds(50, 30, 100, 20);
        this.getContentPane().add(stepJLabel);

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                ImageIcon icon = new ImageIcon(choose + num + "\\" + data[i][j] + ".jpg");//image/animal/animal1/1.jpg
                JLabel jLabel = new JLabel(icon);
                jLabel.setBounds(105 * j + 83, 105 * i + 137, 105, 105);
                jLabel.setBorder(new BevelBorder(1));
                this.getContentPane().add(jLabel);
            }
        }

        JLabel background = new JLabel(new ImageIcon("image\\background.png"));
        background.setBounds(40, 40, 508, 560);
        this.getContentPane().add(background);
        this.getContentPane().repaint();
    }

    private int getNum(int i) {
        Random r = new Random();
        return r.nextInt(i) + 1;
    }

    private void initJmebuBar() {
        JMenuBar jMenuBar = new JMenuBar();

        JMenu functionMenu = new JMenu("功能");
        JMenu aboutUsMenu = new JMenu("关于我们");
        JMenu changePicture = new JMenu("更换图片");


        replayItem.addActionListener(this);
        reLoginItem.addActionListener(this);
        closeItem.addActionListener(this);
        accountItem.addActionListener(this);
        girl.addActionListener(this);
        animal.addActionListener(this);
        sport.addActionListener(this);

        changePicture.add(girl);
        changePicture.add(animal);
        changePicture.add(sport);
        functionMenu.add(replayItem);
        functionMenu.add(reLoginItem);
        functionMenu.add(closeItem);
        functionMenu.add(changePicture);

        aboutUsMenu.add(accountItem);

        jMenuBar.add(functionMenu);
        jMenuBar.add(aboutUsMenu);

        this.setJMenuBar(jMenuBar);
    }

    private void initJframe() {
        this.setSize(603, 680);
        this.setTitle("拼图游戏 v1.0");
        this.setAlwaysOnTop(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(3);
        this.setLayout(null);
        this.addKeyListener(this);
    }

    private boolean isWin() {
        int[] temp = new int[16];
        for (int i = 0; i < 16; i++) {
            temp[i] = data[i / 4][i % 4];
        }
        for (int i = 0; i < temp.length - 1; i++) {
            if (temp[i] != i + 1) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == 65) {
            this.getContentPane().removeAll();
            JLabel jLabel = new JLabel(new ImageIcon("image\\animal\\animal3\\all.jpg"));
            jLabel.setBounds(83, 134, 420, 420);
            this.getContentPane().add(jLabel);
            JLabel background = new JLabel(new ImageIcon("image\\background.png"));
            background.setBounds(40, 40, 508, 560);
            this.getContentPane().add(background);
            this.getContentPane().repaint();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int a = e.getKeyCode();
        if (a == 37) {
            if (y == 3) {
                return;
            }
            data[x][y] = data[x][++y];
            data[x][y] = 0;
            step++;
            initImage();
        } else if (a == 38) {
            if (x == 3) {
                return;
            }
            data[x][y] = data[++x][y];
            data[x][y] = 0;
            step++;
            initImage();
        } else if (a == 39) {
            if (y == 0) {
                return;
            }
            data[x][y] = data[x][--y];
            data[x][y] = 0;
            step++;
            initImage();
        } else if (a == 40) {
            if (x == 0) {
                return;
            }
            data[x][y] = data[--x][y];
            data[x][y] = 0;
            step++;
            initImage();
        } else if (a == 65) {
            initImage();
        } else if (a == 87) {
            data = new int[][]{
                    {1, 2, 3, 4},
                    {5, 6, 7, 8},
                    {9, 10, 11, 12},
                    {13, 14, 15, 0}
            };
            x = 3;
            y = 3;
            step++;
            initImage();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object a = e.getSource();
        if (a == replayItem) {
            step = 0;
            initData();
            initImage();
        } else if (a == reLoginItem) {
            this.setVisible(false);
            new LoginJframe();
        } else if (a == closeItem) {
            System.exit(0);
        } else if (a == accountItem) {
            JDialog jDialog = new JDialog();
            JLabel jLabel = new JLabel(new ImageIcon("image\\about.png"));
            jLabel.setBounds(0, 0, 258, 258);
            jDialog.getContentPane().add(jLabel);
            jDialog.setSize(344, 344);
            jDialog.setAlwaysOnTop(true);
            jDialog.setLocationRelativeTo(null);
            jDialog.setModal(true);
            jDialog.setVisible(true);
        } else if (a == girl) {
            choose = "image\\girl\\girl";
            num = getNum(13);
            step = 0;
            initData();
            initImage();
        } else if (a == animal) {
            choose = "image\\animal\\animal";
            num = getNum(8);
            step = 0;
            initData();
            initImage();
        } else if (a == sport) {
            choose = "image\\sport\\sport";
            num = getNum(10);
            step = 0;
            initData();
            initImage();
        }
    }
}
