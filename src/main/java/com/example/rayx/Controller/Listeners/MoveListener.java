package com.example.rayx.Controller.Listeners;

import com.example.rayx.Model.Game.Moving;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.util.Set;

public class MoveListener implements EventHandler<KeyEvent> {

    private static final Set<KeyCode> up = Set.of(KeyCode.W, KeyCode.UP);
    private static final Set<KeyCode> down = Set.of(KeyCode.S, KeyCode.DOWN);
    private static final Set<KeyCode> left = Set.of(KeyCode.A, KeyCode.LEFT);
    private static final Set<KeyCode> right = Set.of(KeyCode.D, KeyCode.RIGHT);

    @Override
    public void handle(KeyEvent keyEvent) {
        KeyCode character = keyEvent.getCode();

        if(up.contains(character)){
            Moving.setWalkY(0.02f);
        }else if(down.contains(character)){
            Moving.setWalkY(-0.02f);
        }
        if(left.contains(character)){
            Moving.setWalkX(-0.2f);
        }else if(right.contains(character)){
            Moving.setWalkX(0.2f);
        }


    }
}
