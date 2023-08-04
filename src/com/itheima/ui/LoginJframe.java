package com.itheima.ui;

import javax.swing.*;

public class LoginJframe extends JFrame {

    public LoginJframe(){
        initJFrame();
        this.setVisible(true);
    }

    public void initJFrame() {
        this.setSize(488, 430);//设置宽高
        this.setTitle("拼图游戏 V1.0登录");//设置标题
        this.setDefaultCloseOperation(3);//设置关闭模式
        this.setLocationRelativeTo(null);//居中
        this.setAlwaysOnTop(true);//置顶
        this.setLayout(null);//取消内部默认布局
    }

    public void initView(){

    }

}
