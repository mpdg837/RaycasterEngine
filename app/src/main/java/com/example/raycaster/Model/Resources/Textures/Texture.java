package com.example.raycaster.Model.Resources.Textures;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;

public class Texture {
    int[][][] tex;

    public Texture(AppCompatActivity app, int id, boolean sprite) throws IOException{

        Bitmap texture;

        Bitmap preTex = BitmapFactory.decodeResource(app.getResources(), id);
        texture = Bitmap.createScaledBitmap(preTex,128,128,false);

        tex = new int[128][128][10];
        if(texture.getWidth()== 128 && texture.getHeight()==128){

            for(int x=0;x<128;x++){
                for(int y=0;y<128;y++) {

                    for (int n = 0; n < 10; n++) {
                        tex[y][x][n] = shadowPixel(texture.getPixel(y, x), n*10,sprite);
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
