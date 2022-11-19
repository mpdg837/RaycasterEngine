package com.example.rayx.View.UI.Components;

import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class FullScreenComponent extends ImageView {

    protected Stage stage;
    public FullScreenComponent(Stage stage){
        this.stage = stage;
        this.setSmooth(false);
        this.setEffect(null);

        fitToScreen();
    }
    protected void fitToScreen(){
        this.fitWidthProperty().bind(stage.widthProperty());
        this.fitHeightProperty().bind(stage.heightProperty());
    }

}
