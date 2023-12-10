package Interactable;

import Windows.Panels.MainCanvas;

import java.awt.*;

public interface Interactable {
    void update(MainCanvas canvas, float deltaTime);

    void render(MainCanvas canvas, Graphics g);

}
