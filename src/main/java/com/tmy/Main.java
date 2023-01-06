package com.tmy;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

/**
 * Project:MouseMove
 * Powered by tianmingyang on 2023-01-06 11:04:30
 * Created by IntelliJ IDEA
 *
 * @Author:TianMingYang
 */

public class Main implements Runnable {

    public static void main(String[] args) {
        Main main = new Main();
        main.run();
    }

    private final Robot robot;

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
        int x, y;
        Random random = new Random();
        while (!isStop) {
            x = random.nextInt(1000);
            y = random.nextInt(1000);
            robot.mouseMove(x, y);
            robot.delay(10000);
        }
    }

    private class ControllerFrame extends JFrame {

        private static final long serialVersionUID = 1L;

        public ControllerFrame() {
            //设置容器中到组件布局 LEADING 为从左到右依次布局
            setLayout(new FlowLayout(FlowLayout.CENTER));
            //设置容器大小
            setSize(300, 200);

            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            //设置容器在屏幕正中间
            setLocationRelativeTo(null);

            JButton jButton = new JButton(ControllerConstants.STOP_BUTTON);
            //设置组件尺寸
            Dimension dimension = new Dimension(150, 100);
            jButton.setPreferredSize(dimension);
            //设置字体 name为字体的名称、style为字体的风格，官方提供了Font.BOLD(粗体)、PLAIN（普通）、ITALIC(斜体)
            Font font = new Font("粗体", Font.BOLD, 14);
            jButton.setFont(font);
            //设置边框
            jButton.setBorderPainted(true);
            //将组件加入容器中
            add(jButton);

            jButton.addActionListener(e -> {
                isStop = true;
                dispose();
            });
        }
    }
}