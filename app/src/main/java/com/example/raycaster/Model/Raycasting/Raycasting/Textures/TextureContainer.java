package com.example.raycaster.Model.Raycasting.Raycasting.Textures;

import androidx.appcompat.app.AppCompatActivity;

import com.example.raycaster.Model.Resources.Textures.SkyBox;
import com.example.raycaster.Model.Resources.Textures.Texture;
import com.example.raycaster.R;

import java.io.IOException;

public final class TextureContainer {

    public static Texture spriteTex;
    public static Texture texture;
    public static Texture uptexture;

    public static Texture upbtexture;
    public static Texture floor;
    public static Texture floor1;
    public static Texture halfTex;
    public static Texture fence;
    public static Texture high;
    public static SkyBox sky;

    private TextureContainer(){

    }

    public static void loadTextures(AppCompatActivity app){
        try {

            texture = new Texture(app, R.drawable.textures,false);
            uptexture = new Texture(app,R.drawable.uptex,false);
            upbtexture = new Texture(app,R.drawable.upper2,false);
            floor = new Texture(app,R.drawable.floor,false);
            floor1 = new Texture(app,R.drawable.floorminus,false);
            spriteTex = new Texture(app,R.drawable.sprite,true);
            sky = new SkyBox(app,R.drawable.skybox);
            fence = new Texture(app,R.drawable.fence,true);
            halfTex =  new Texture(app,R.drawable.half,false);
            high = new Texture(app,R.drawable.hsprite,true);
        }catch (IOException e){
            throw new RuntimeException(e);
        }

    }

}
