package online;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SettingsWindow extends JFrame {
    private static final int WINDOW_HEIGHT = 230;
    private static final int WINDOW_WIDTH = 350;

    JPanel menu = new JPanel(new GridLayout(10, 1));
    JLabel labelMode = new JLabel("Выберите режим игры");
    ButtonGroup groupButton = new ButtonGroup(); //так как это не компонент, мы его никогда не передаем для размещения.
    // Используется только для согласования логики работы Radiobutton
    JRadioButton pvp = new JRadioButton("Человек против человека");
    JRadioButton pve = new JRadioButton("Человек против компьютера");
    JLabel labelwLen = new JLabel("Выберите длину для победы");
    JSlider sliderwLen = new JSlider(3, 10, 3);
    JLabel labelValuewLen = new JLabel(String.valueOf(sliderwLen.getValue()));

    JLabel labelxySize = new JLabel("Выберите размер поля");
    JSlider sliderxySize = new JSlider(3, 10, 3);
    JLabel labelValuexySize = new JLabel(String.valueOf(sliderxySize.getValue()));
    JButton btnStart = new JButton("Start new game"); //создаем кнопку в классе, так как она относится ко всему окну

    /**
     * В btnStart.addActionListener(new ActionListener()) вызываем метод начала игры, который относится к back
     * import классов во frontend происходит через передачу других классов в параметры создаваемых экземпляров
     *
     * @param gameWindow
     */
    SettingsWindow(GameWindow gameWindow) {
        this.setLocationRelativeTo(gameWindow);
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);


        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (pve.isSelected()) {
                    gameWindow.startNewGame(0, sliderxySize.getValue(), sliderxySize.getValue(), sliderwLen.getValue());

                }
                if (pvp.isSelected()) {
                    gameWindow.startNewGame(1, sliderxySize.getValue(), sliderxySize.getValue(), sliderwLen.getValue());

                }
                setVisible(false);
            }
        });

        sliderwLen.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                labelValuewLen.setText(String.valueOf(sliderwLen.getValue()));
            }
        });
        sliderxySize.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                labelValuexySize.setText(String.valueOf(sliderxySize.getValue()));
            }
        });
        groupButton.add(pvp);
        pvp.setSelected(true);
        groupButton.add(pve);
        menu.add(labelMode);
        menu.add(pvp);
        menu.add(pve);
        menu.add(labelwLen);
        menu.add(sliderwLen);
        menu.add(labelValuewLen);
        menu.add(labelxySize);
        menu.add(sliderxySize);
        menu.add(labelValuexySize);
        menu.add(btnStart);
        this.add(menu);
    }
}
