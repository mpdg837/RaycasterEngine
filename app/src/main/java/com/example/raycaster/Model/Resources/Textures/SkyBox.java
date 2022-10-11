package com.example.raycaster.Model.Resources.Textures;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import androidx.appcompat.app.AppCompatActivity;

import com.example.raycaster.View.Render;

import java.io.IOException;

public class SkyBox extends Texture{
    private int[] newScreen = new int[(640*400) << Render.shiftPixelWidth];

    public SkyBox(AppCompatActivity app, int obj) throws IOException {
        super(app,obj,false);

        Bitmap texture;

        Bitmap preTex = BitmapFactory.decodeResource(app.getResources(), obj);
        texture = Bitmap.createScaledBitmap(preTex,512,256,false);

        tex = new int[512][512][10];
        if(texture.getWidth()== 512 && texture.getHeight()==256){

            for(int x=0;x<256;x++){
                for(int y=0;y<512;y++) {
                    for (int n = 0; n < 9; n++) {
                        tex[y][x][n] = texture.getPixel(y, x);
                    }
                }
            }

        }
    }

}
