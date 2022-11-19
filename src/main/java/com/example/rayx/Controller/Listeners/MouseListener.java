package com.example.rayx.Controller.Listeners;

import com.example.rayx.Model.Game.Rotating;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.robot.Robot;
import javafx.stage.Stage;
import javafx.stage.Window;

public class MouseListener implements EventHandler<MouseEvent> {

    private final Window window;
    public MouseListener(Window window){
        this.window = window;
    }
    @Override
    public void handle(MouseEvent mouseEvent) {
            Rotating.getMousePos((int) mouseEvent.getX());
            Robot robo = new Robot();

            final int delta = 100;
            robo.mouseMove(this.window.getX() + delta, this.window.getY() + delta);

    }
}
