package com.example.rayx;

import com.example.rayx.Model.Game.Rotating;
import com.example.rayx.Model.Raycasting.GameLoop.RenderLoop;
import com.example.rayx.View.UI.RenderScene;
import javafx.application.Application;
import javafx.scene.layout.Pane;
import javafx.scene.robot.Robot;
import javafx.stage.Stage;

import java.io.IOException;

public class RayApp extends Application {

    public boolean initized = false;
    public RenderScene renderScene;

    public Robot robo = new Robot();
    @Override
    public void start(Stage stage) throws IOException {

        Pane root = new Pane();

        RenderLoop.run(this);
        renderScene = new RenderScene(stage, root, this);
        initized = true;

    }
    public static void main(String[] args) {
        launch();
    }
}