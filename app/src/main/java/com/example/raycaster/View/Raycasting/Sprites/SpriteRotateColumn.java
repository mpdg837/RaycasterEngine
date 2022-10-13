package com.example.raycaster.View.Raycasting.Sprites;

import com.example.raycaster.Model.Raycasting.Raycasting.Analyse.Entities.InPoint;
import com.example.raycaster.Model.Raycasting.Raycasting.Analyse.Entities.Ray;
import com.example.raycaster.Model.Raycasting.Raycasting.PreBaking.Ray.PreColumns.PreColumn;
import com.example.raycaster.Model.Raycasting.Raycasting.RenderInfoBuffer;
import com.example.raycaster.Model.Raycasting.RenderProcedure;
import com.example.raycaster.Model.Raycasting.Raycasting.Textures.TextureContainer;

public final class SpriteRotateColumn extends SpriteRenderer{

    private static double ys;
    private static double yf;

    private static  double delta;

    private static double posTexY;

    private static byte ltexX;
    private static byte texX;

    private static  double dtexX;


    private static void prepare(double heights, int tex){
        ys = RenderProcedure.cameraY - heights;
        yf = RenderProcedure.cameraY + heights;

        if (Ray.half) yf = RenderProcedure.cameraY;

        delta = (double) 128 / ((double) 2 * heights);

        posTexY = 0;

        ltexX = RenderInfoBuffer.mapsprite[InPoint.countPos];
        texX = (byte) (((64 - tex) & 0x3f));

        dtexX = ((double) texX - (double) ltexX) / (double) RenderProcedure.SCREEN_STEP;

        if (tex<=2 && !RenderInfoBuffer.mapspritechange[InPoint.countPos]) {
            RenderInfoBuffer.mapspritechange[InPoint.countPos] = true;
        }
    }
    public static void render(double heights,byte tex,int shadows){


        prepare(heights,tex);


        for (int n = (int) ys; n < yf; n++) {
            if (n >= PreColumn.minY && n >= 0 && n < RenderProcedure.SCREEN_HEIGHT) {

                double ttexX = ltexX;

                for (int k = 0; k < RenderProcedure.SCREEN_STEP; k++) {
                    final int count = Ray.countPosBuffer(k, n);

                    if (RenderInfoBuffer.reservedSpritePixels[count] == 0) {
                        int col;
                        if (RenderInfoBuffer.mapspritechange[InPoint.countPos])
                            col = TextureContainer.spriteTex.getPixel((int) (127 - ttexX), (int) posTexY & 0x7f,shadows) & 0xFFFFFF;
                        else
                            col = TextureContainer.spriteTex.getPixel((int) (ttexX), (int) posTexY & 0x7f,shadows) & 0xFFFFFF;

                        RenderInfoBuffer.reservedSpritePixels[count] = col;
                        ttexX += dtexX;
                    }
                }

            }
            posTexY += delta;
        }
        RenderInfoBuffer.mapsprite[InPoint.countPos] = texX;
    }
}
