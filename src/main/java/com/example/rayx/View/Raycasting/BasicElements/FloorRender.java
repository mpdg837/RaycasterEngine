package com.example.rayx.View.Raycasting.BasicElements;

import com.example.rayx.Model.Raycasting.Quality;
import com.example.rayx.Model.Raycasting.Raycasting.Analyse.RenderSteps.Ray;
import com.example.rayx.Model.Raycasting.Raycasting.Textures.TextureContainer;
import com.example.rayx.Model.Raycasting.RenderProcedure;
import com.example.rayx.View.Raycasting.BasicElements.PixelSet.FloorPixel;

public final class FloorRender {

    public static int posllY;
    public static int posllX;

    private static final int delta = (Quality.D_SCREEN_STEP);

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
        if(Ray.floorDown == -1) intensity = 4;

        int scolor = TextureContainer.floor.getPixel((int) poslX, (int) poslY, intensity);
        FloorPixel.setCPixel(posScreenX - delta, posfinish, scolor, hei, true);
    }
}
