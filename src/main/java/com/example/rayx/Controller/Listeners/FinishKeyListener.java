package com.example.rayx.Controller.Listeners;

import com.example.rayx.Model.Game.Moving;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;

public class FinishKeyListener implements EventHandler<KeyEvent> {
    @Override
    public void handle(KeyEvent keyEvent) {
        Moving.stopWalk();
    }
}
