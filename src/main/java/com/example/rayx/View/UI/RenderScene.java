package com.example.rayx.View.UI;

import com.example.rayx.Controller.EventInit;
import com.example.rayx.RayApp;
import com.example.rayx.View.UI.Components.Background;
import com.example.rayx.View.UI.Components.CanvasFX;
import com.example.rayx.View.UI.Components.StatusBar;
import javafx.scene.Cursor;
import javafx.scene.ImageCursor;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class RenderScene extends Scene{

    public CanvasFX view;
    public StatusBar bar;

    public RenderScene(Stage stage, Pane root, RayApp app){

        super(root, 800,600);

        this.setCursor(null);

        root.getChildren().add(new Background(stage,"skybox.png",app));

        root.getChildren().add(view = new CanvasFX(stage));
        root.getChildren().add(bar = new StatusBar(stage));

        this.setCursor(Cursor.NONE);

        stage.setScene(this);
        stage.show();

        EventInit.init(this.getWindow());

    }


}
