package com.kuang.servlet;

import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class TestPanel {
    public static void main(String[] args) {
        //窗口
        Frame frame=new Frame("中秋节快乐");
        //面板
        Panel panel=new Panel(null);
        frame.setLayout(null);//设置窗体的布局
        frame.setBounds(300,500,500,500);
        frame.setBackground(new Color(0,0,255));
        panel.setBounds(50,50,300,300);
        panel.setBackground(new Color(0,255,255));
        frame.add(panel);
        frame.setVisible(true);
        //监听事件，关闭事件
        frame.addWindowListener(new WindowListener() {
            public void windowOpened(WindowEvent e) {
                System.out.println("打开ing");
            }

            public void windowClosing(WindowEvent e) {
                System.out.println("关闭ing");
                System.exit(0);
            }

            public void windowClosed(WindowEvent e) {
                System.out.println("关闭ed");
            }

            public void windowIconified(WindowEvent e) {
                System.out.println("打开");
            }

            public void windowDeiconified(WindowEvent e) {

            }

            public void windowActivated(WindowEvent e) {

            }

            public void windowDeactivated(WindowEvent e) {

            }
        });
    }
}
