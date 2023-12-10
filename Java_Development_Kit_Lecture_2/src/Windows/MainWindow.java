package Windows;

import Interactable.Background.Background;
import Interactable.Objects.Ball;
import Interactable.Sprite;
import Windows.Panels.MainCanvas;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
    private static final int POS_X = 400;
    private static final int POS_Y = 200;
    private static final int WINDOWS_WIDTH = 800;
    private static final int WINDOWS_HEIGHT = 600;
    private final Sprite[] sprites = new Sprite[10];
    private Background bkg = new Background();

    public MainWindow() {
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setBounds(POS_X, POS_Y, WINDOWS_WIDTH, WINDOWS_HEIGHT);
        this.setTitle("Circles");
        for (int i = 0; i < sprites.length; i++) {
            this.sprites[i] = new Ball();
        }
        MainCanvas canvas = new MainCanvas(this);
        this.add(canvas);
        this.setVisible(true);
    }

    public void onDrawFrame(MainCanvas canvas, Graphics g, float deltaTime) {
        this.update(canvas, deltaTime);
        this.render(canvas, g);
    }

    private void update(MainCanvas canvas, float deltaTime) {
        for (int i = 0; i < sprites.length; i++) {
            this.sprites[i].update(canvas, deltaTime);
        }
        bkg.update(canvas,deltaTime);
    }

    private void render(MainCanvas canvas, Graphics g) {
        for (int i = 0; i < sprites.length; i++) {
            this.sprites[i].render(canvas, g);
        }
        bkg.render(canvas,g);
    }

}
