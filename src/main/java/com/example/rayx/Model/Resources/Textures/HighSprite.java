package com.example.rayx.Model.Resources.Textures;

import com.example.rayx.RayApp;
import javafx.scene.image.Image;

import java.io.IOException;
import java.net.URL;

public class HighSprite extends Texture{

    public HighSprite(RayApp app,String obj) throws IOException {
            super(app,obj,true);
        URL _url = app.getClass().getResource(obj);
        Image texture = new Image(_url.toExternalForm(),128,256,false,false);

        tex = new int[128][128][10];
        if(texture.getWidth()== 128 && texture.getHeight()==256){

            for(int x=0;x<128;x++){
                for(int y=0;y<256;y++) {

                    for (int n = 0; n < 10; n++) {
                        tex[y][x][n] = shadowPixel(texture.getPixelReader().getArgb(y, x), n*10,true);
                    }
                }
            }

        }
        }

    public int getPixel(int x,int y){
        return tex[y][x][0];
    }

}
