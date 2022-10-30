package com.example.raycaster.Model.Resources.Textures;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;

public class HighSprite extends Texture{

    public HighSprite(AppCompatActivity app, int obj) throws IOException {
            super(app,obj,true);

            Bitmap texture;

            Bitmap preTex = BitmapFactory.decodeResource(app.getResources(), obj);
            texture = Bitmap.createScaledBitmap(preTex,128,256,false);

            tex = new int[256][128][10];
            if(texture.getWidth()== 128 && texture.getHeight()==256){

                for(int x=0;x<128;x++){
                    for(int y=0;y<256;y++){

                        tex[y][x][0] = texture.getPixel(x,y);
                    }
                }

            }
        }

    public int getPixel(int x,int y){
        return tex[y][x][0];
    }

}
