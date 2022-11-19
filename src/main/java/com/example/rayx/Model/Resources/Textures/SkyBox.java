package com.example.rayx.Model.Resources.Textures;

import com.example.rayx.RayApp;
import com.example.rayx.View.Render;
import javafx.scene.image.Image;

import java.io.IOException;
import java.net.URL;

public class SkyBox extends Texture{
    private int[] newScreen = new int[(640*400) << Render.shiftPixelWidth];

    public SkyBox(RayApp app,String obj) throws IOException {
        super(app,obj,false);
        URL _url = app.getClass().getResource(obj);
        Image texture = new Image(_url.toExternalForm(),512,256,false,false);

        tex = new int[128][128][10];
        if(texture.getWidth()== 512 && texture.getHeight()==256){

            for(int x=0;x<128;x++){
                for(int y=0;y<128;y++) {

                    for (int n = 0; n < 10; n++) {
                        tex[y][x][n] = shadowPixel(texture.getPixelReader().getArgb(y, x), n*10,false);
                    }
                }
            }

        }
    }

}
