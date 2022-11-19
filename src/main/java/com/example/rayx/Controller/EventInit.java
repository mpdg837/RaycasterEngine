package com.example.rayx.Controller;

import com.example.rayx.Controller.Listeners.MouseListener;
import com.example.rayx.Controller.Listeners.WindowExitListener;
import com.example.rayx.Controller.Listeners.FinishKeyListener;
import com.example.rayx.Controller.Listeners.MoveListener;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Window;
import javafx.stage.WindowEvent;

public final class EventInit {
    public static void init(Window window){
        window.addEventFilter(WindowEvent.WINDOW_CLOSE_REQUEST,new WindowExitListener());
        window.addEventFilter(KeyEvent.KEY_PRESSED,new MoveListener());
        window.addEventFilter(KeyEvent.KEY_RELEASED,new FinishKeyListener());

        window.addEventFilter(MouseEvent.MOUSE_MOVED,new MouseListener(window));
    }
}
