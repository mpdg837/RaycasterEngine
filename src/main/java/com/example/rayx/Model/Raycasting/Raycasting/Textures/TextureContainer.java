package com.example.rayx.Model.Raycasting.Raycasting.Textures;


import com.example.rayx.Model.Resources.Textures.SkyBox;
import com.example.rayx.Model.Resources.Textures.Texture;
import com.example.rayx.RayApp;

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

    public static void loadTextures(RayApp app){
        try {

            texture = new Texture(app,"textures.png",false);
            uptexture = new Texture(app,"uptex.png",false);
            upbtexture = new Texture(app,"upper2.png",false);
            floor = new Texture(app,"floor.png",false);
            floor1 = new Texture(app,"floorminus.png",false);
            spriteTex = new Texture(app,"sprite.png",true);
            sky = new SkyBox(app,"skybox.png");
            fence = new Texture(app,"fence.png",true);
            halfTex =  new Texture(app,"half.png",false);
            high = new Texture(app,"hsprite.png",true);
        }catch (IOException e){
            throw new RuntimeException(e);
        }

    }

}
