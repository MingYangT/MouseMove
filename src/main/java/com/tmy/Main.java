package com.tmy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Main implements Runnable{

    private Robot robot;

    private boolean isStop = false;

    public Main() {
        ControllerFrame controllerFrame = new ControllerFrame();
        controllerFrame.setVisible(true);
        try {
            robot = new Robot();
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void run() {
        int x,y;
        Random random = new Random();
        while (!isStop) {
            x = random.nextInt(1000);
            y = random.nextInt(1000);
            robot.mouseMove(x,y);
            robot.delay(10000);
        }
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.run();
    }

    private class ControllerFrame extends JFrame {

        private static final long serialVersionUID = 1L;

        private JButton jButton = new JButton("停止");

        public ControllerFrame(String title){
            this();
            setTitle(title);
        }

        public ControllerFrame() {
            setLayout(new FlowLayout(FlowLayout.LEADING));
            setSize(100,100);
            setResizable(false);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLocationRelativeTo(null);
            Dimension dimension = new Dimension(100, 60);
            Font font = new Font("", Font.BOLD, 14);
            jButton.setPreferredSize(dimension);
            jButton.setFont(font);
            jButton.setBorderPainted(false);
            jButton.setFocusPainted(false);

            add(jButton);

            jButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    isStop = true;
                    dispose();
                }
            });
        }
    }
}