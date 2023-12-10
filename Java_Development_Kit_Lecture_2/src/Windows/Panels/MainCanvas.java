package Windows.Panels;

import Windows.MainWindow;
import com.sun.tools.javac.Main;

import javax.swing.*;
import java.awt.*;

/**
 * Канва для рисования
 */
public class MainCanvas extends JPanel {

    private final MainWindow controller;
    private long lastFrameTime;

    public MainCanvas(MainWindow controller) {
        this.setBackground(Color.BLUE);
        this.controller = controller;
        this.lastFrameTime = System.nanoTime();
    }

    @Override
    protected void paintComponent(Graphics g) { //do
        super.paintComponent(g);                //something
        //useful
        try {                                    //sleep
            Thread.sleep(16);              //16 ms
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        float deltaTime = (System.nanoTime() - this.lastFrameTime) * 0.000000001f;
        controller.onDrawFrame(this, g, deltaTime);
        this.lastFrameTime = System.nanoTime();
        repaint();                              //while(true)
    }

    public int getLeft() {
        return 0;
    }

    public int getRight() {
        return this.getWidth() - 1;
    }

    public int getTop() {
        return 0;
    }

    public int getBottom() {
        return this.getHeight() - 1;
    }
}
