package online;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

public class ChatWindow extends JFrame {
    private static final int WINDOW_HEIGHT = 555;
    private static final int WINDOW_WIDTH = 507;
    private static final int WINDOW_POSX = 800;
    private static final int WINDOW_POSY = 300;

    JButton btnConnect = new JButton("Connect");
    JButton btnExit = new JButton("Exit");


    public ChatWindow() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocation(WINDOW_POSX, WINDOW_POSY);
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setTitle("TicTacToe");
        this.setResizable(false);

        JPanel panSet = new JPanel(new GridLayout(5, 1));
        JTextField loginField = new JTextField("Введите логин");  // <-
        JTextField passField = new JTextField("Введите пароль");  // <-
        JTextField ipField = new JTextField("Введите ip");  // <-
        JTextField portField = new JTextField("Введите порт");  // <-
        panSet.add(loginField);
        panSet.add(passField);
        panSet.add(ipField);
        panSet.add(portField);
        JPanel panBottom = new JPanel(new GridLayout(1, 2));
        panBottom.add(btnConnect);
        panBottom.add(btnExit);
        panSet.add(panBottom);
        this.add(panSet,BorderLayout.NORTH);

        JPanel panMid = new JPanel(new GridLayout(1,2));
        JTextArea fieldChat = new JTextArea();      // <-
        fieldChat.setEditable(false);  // <-
        JList<String> fieldUsers = new JList<String>(); // <-
        String[] usersList = new String[]{"Kate","Alex"};
        fieldUsers.setListData(usersList);  // <-
        panMid.add(fieldChat);
        panMid.add(fieldUsers);
        this.add(panMid,BorderLayout.CENTER);

        JPanel panChat = new JPanel(new GridLayout(2, 1));
        JTextField fieldMessage = new JTextField();  // <-
        JButton btnSend = new JButton("Send");
        panChat.add(fieldMessage);
        panChat.add(btnSend);
        this.add(panChat,BorderLayout.SOUTH);

        this.setVisible(true);

        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        btnConnect.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                return;
            }
        });

        btnSend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fieldChat.append(fieldMessage.getText()+"\n");
                fieldMessage.setText("");
            }
        });


    }

    /**
     * back метод вызова начала игры через back метод в классе map
     * @param mode
     * @param fSzx
     * @param fSzY
     * @param wLen
     */
    public void startNewGame(int mode, int fSzx, int fSzY, int wLen) {

    }
}
