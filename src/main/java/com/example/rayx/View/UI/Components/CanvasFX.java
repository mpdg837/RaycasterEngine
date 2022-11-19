package com.example.rayx.View.UI.Components;

import com.example.rayx.View.Render;
import javafx.scene.image.*;
import javafx.stage.Stage;

import java.nio.ByteBuffer;

public class CanvasFX extends FullScreenComponent{

    public WritableImage img = new WritableImage(Render.SCREEN_WIDTH, Render.SCREEN_HEIGHT);
    public PixelWriter pw = img.getPixelWriter();
    public CanvasFX(Stage stage){
        super(stage);
        this.setSmooth(false);

        this.setImage(img);

    }

    public void refresh(byte[] pixels){
        img = new WritableImage(Render.SCREEN_WIDTH, Render.SCREEN_HEIGHT);

        pw = img.getPixelWriter();
        pw.setPixels(0, 0, Render.SCREEN_WIDTH, Render.SCREEN_HEIGHT,
                PixelFormat.getByteBgraPreInstance(), pixels, 0, Render.SCREEN_WIDTH<<2);

        this.setImage(img);

    }

}
