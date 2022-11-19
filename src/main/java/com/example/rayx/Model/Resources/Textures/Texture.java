package com.example.rayx.Model.Resources.Textures;

import com.example.rayx.RayApp;
import javafx.scene.image.Image;

import java.io.IOException;
import java.net.URL;

public class Texture {
    int[][][] tex;

    public Texture(RayApp context, String fileName, boolean sprite) throws IOException{
        URL _url = context.getClass().getResource(fileName);
        Image texture = new Image(_url.toExternalForm(),128,128,false,false);

        tex = new int[128][128][10];
        if(texture.getWidth()== 128 && texture.getHeight()==128){

            for(int x=0;x<128;x++){
                for(int y=0;y<128;y++) {

                    for (int n = 0; n < 10; n++) {
                        tex[y][x][n] = shadowPixel(texture.getPixelReader().getArgb(y, x), n*10,sprite);
                    }
                }
            }

        }

    }

    public static int shadowPixel(int pcol,final int shadowIntensity,boolean sprite){
            int r = (pcol >> 16) & 0xFF;
            int g = (pcol >> 8) & 0xFF;
            int b = pcol & 0xFF;

            if (r - shadowIntensity > 0) r -= shadowIntensity;
            else r = 0;

            if (g - shadowIntensity > 0) g -= shadowIntensity;
            else g = 0;

            if (b - shadowIntensity > 0) b -= shadowIntensity;
            else b = 0;

            int col = (r << 16) | (g << 8) | (b);

            if(col == 0 && !sprite) col = 1;
            else if((pcol & 0xFFFFFF) != 0 && col == 0) col = 1;

            return col;

    }

    public int getPixel(int x,int y,int shadow){
        return tex[x][y][shadow];
    }
}
