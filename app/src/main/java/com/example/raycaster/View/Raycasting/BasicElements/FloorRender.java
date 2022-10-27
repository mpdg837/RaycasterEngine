package com.example.raycaster.View.Raycasting.BasicElements;

import com.example.raycaster.Model.Raycasting.Raycasting.Textures.TextureContainer;
import com.example.raycaster.Model.Raycasting.RenderProcedure;

public final class FloorRender {

    public static int posllY;
    public static int posllX;

    private static final int delta = (RenderProcedure.D_SCREEN_STEP);

    public static void renderCeiling(float r, int ceil, int hei, int poslX, int poslY, int posScreenX, int posstart){

        int color = 0;

        if (ceil == 1)
            color = TextureContainer.floor.getPixel((int) poslX, (int) poslY, 7);
        else
            color = TextureContainer.floor.getPixel((int) poslX, (int) poslY, 1);


        FloorPixel.setCPixel(posScreenX - delta,
                posstart, color, hei*ceil, false);
    }

    public static void renderFloorDown(float r, int ceil, int hei, int poslX, int poslY, int posScreenX, int posfinish){
        int intensity = 2;
        if (ceil == 1) intensity = 7;

        int scolor = TextureContainer.floor.getPixel((int) poslX, (int) poslY, intensity);
        FloorPixel.setCPixel(posScreenX - delta, posfinish, scolor, hei, true);
    }
}
