package online;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameWindow extends JFrame {
    private static final int WINDOW_HEIGHT = 555;
    private static final int WINDOW_WIDTH = 507;
    private static final int WINDOW_POSX = 800;
    private static final int WINDOW_POSY = 300;

    JButton btnStart = new JButton("New Game");
    JButton btnExit = new JButton("Exit");
    Map map;
    SettingsWindow settings;

    public GameWindow() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocation(WINDOW_POSX, WINDOW_POSY);
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setTitle("TicTacToe");
        this.setResizable(false);

        this.map = new Map();
        this.settings = new SettingsWindow(this);

        JPanel panBottom = new JPanel(new GridLayout(1, 2));
        panBottom.add(btnStart);
        panBottom.add(btnExit);
        this.add(panBottom, BorderLayout.SOUTH);
        this.add(map, BorderLayout.CENTER);

        this.setVisible(true);

        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                settings.setVisible(true);
            }
        });


    }

    public void startNewGame(int mode, int fSzx, int fSzY, int wLen) {
        this.map.startNewGame(mode, fSzx, fSzY, wLen);
    }
}
