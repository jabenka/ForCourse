package org.zxcjaba;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Date;

import static java.lang.Thread.sleep;

public class Main {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame();
            frame.setSize(Toolkit.getDefaultToolkit().getScreenSize());
            frame.setLocationRelativeTo(null);
            frame.setUndecorated(true);  //outline=0
            frame.setResizable(false);
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            JLabel timeLabel = new JLabel();
            timeLabel.setHorizontalAlignment(SwingConstants.CENTER);
            timeLabel.setFont(new Font("Times New Roman", Font.PLAIN, 50));
            timeLabel.setForeground(Color.WHITE);
            frame.add(timeLabel, BorderLayout.CENTER);


            Timer timer = new Timer(1000, e -> {
                SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
                String currentTime = dateFormat.format(new Date());
                timeLabel.setText(currentTime);
            });
            timer.start();

            frame.addKeyListener(new KeyListener() {
                @Override
                public void keyTyped(KeyEvent e) {

                }

                @Override
                public void keyPressed(KeyEvent e) {
                    try {
                        sleep(400);
                    } catch (InterruptedException ex) {
                        throw new RuntimeException(ex);
                    }
                    frame.dispose();
                }

                @Override
                public void keyReleased(KeyEvent e) {

                }
            });
            frame.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    try {
                        sleep(400);
                    } catch (InterruptedException ex) {
                        throw new RuntimeException(ex);
                    }
                    frame.dispose();
                }

                @Override
                public void mousePressed(MouseEvent e) {
                    try {
                        sleep(400);
                    } catch (InterruptedException ex) {
                        throw new RuntimeException(ex);
                    }
                    frame.dispose();
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    try {
                        sleep(400);
                    } catch (InterruptedException ex) {
                        throw new RuntimeException(ex);
                    }
                    frame.dispose();
                }

                @Override
                public void mouseEntered(MouseEvent e) {

                }

                @Override
                public void mouseExited(MouseEvent e) {


                }
            });
            frame.getContentPane().setBackground(Color.BLACK);
            frame.setVisible(true);


        });


    }
}