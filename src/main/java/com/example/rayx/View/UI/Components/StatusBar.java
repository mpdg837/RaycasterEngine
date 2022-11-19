package com.example.rayx.View.UI.Components;

import com.example.rayx.View.Render;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.image.WritablePixelFormat;
import javafx.stage.Stage;

import java.nio.ByteBuffer;

public class StatusBar extends FullScreenComponent{

    WritableImage img;
    private WritableImage generateImage(int width, int height, int red, int green, int blue) {

        WritableImage img = new WritableImage(Render.SCREEN_WIDTH, Render.SCREEN_HEIGHT);
        PixelWriter pw = img.getPixelWriter();
        WritablePixelFormat<ByteBuffer> format = WritablePixelFormat.getByteBgraInstance();
        // Should really verify 0.0 <= red, green, blue, opacity <= 1.0

        byte r = (byte) (red) ;
        byte g = (byte) (green) ;
        byte b = (byte) (blue) ;

        byte[] pixels = new byte[(width * height)*4];

        boolean isE = false;

        int index = 0;

        for(int y=0;y<height;y++){
            for(int x=0;x<width;x++){

                if(y>height-150) {
                    if ((x) == 10 && (y) == 100) {
                        pixels[index] = 0;
                        pixels[index + 1] = 0;
                        pixels[index + 2] = 0;
                        pixels[index + 3] = (byte) 255;
                    } else {
                        pixels[index] = (byte) 255;
                        pixels[index + 1] = 0;
                        pixels[index + 2] = 0;
                        pixels[index + 3] = (byte) 255;
                    }
                }

                isE = !isE;
                index +=4;
            }
        }



        pw.setPixels(0, 0, width, height, format, pixels, 0, width*4);
        return img;
    }


    public StatusBar(Stage stage) {
        super(stage);

        this.setImage(img = generateImage(640,600,0,0,0));

    }
}
