package com.example.rayx.Controller.Listeners;

import javafx.event.EventHandler;
import javafx.stage.WindowEvent;

public class WindowExitListener implements EventHandler<WindowEvent>{


    @Override
    public void handle(WindowEvent windowEvent) {
        System.exit(0);
    }
}
