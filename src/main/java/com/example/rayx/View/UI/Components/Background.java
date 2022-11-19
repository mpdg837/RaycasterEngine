package com.example.rayx.View.UI.Components;

import com.example.rayx.RayApp;
import com.example.rayx.View.Render;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.net.URL;

public class Background extends FullScreenComponent {

    private Image backImg;

    public Background(Stage stage, String name, RayApp app){
        super(stage);
        this.stage = stage;

        URL _url =app.getClass().getResource(name);
        backImg = new Image(_url.toExternalForm(), Render.SCREEN_WIDTH,
                Render.SCREEN_HEIGHT,false,false);

        this.setImage(backImg);
    }


}
