package com.example.raycaster.View.Raycasting.Sprites;

import com.example.raycaster.Model.Raycasting.Raycasting.Analyse.Entities.InPoint;
import com.example.raycaster.Model.Raycasting.Raycasting.Analyse.Entities.Ray;
import com.example.raycaster.Model.Raycasting.Raycasting.PreBaking.Ray.PointOnRay;
import com.example.raycaster.Model.Raycasting.Raycasting.PreBaking.Ray.PreColumns.PreColumn;
import com.example.raycaster.Model.Raycasting.Raycasting.RenderInfoBuffer;
import com.example.raycaster.Model.Raycasting.RenderProcedure;
import com.example.raycaster.Model.Raycasting.Raycasting.Textures.TextureContainer;

public final class SpriteRotateColumn extends SpriteRenderer{

    private static double ys;
    private static double yf;

    private static  double delta;

    private static double posTexY;

    private static double ltexX;
    private static double texX;

    private static  double dtexX;


    private static void prepare(double heights, double tex){
        ys = RenderProcedure.cameraY - heights;
        yf = RenderProcedure.cameraY + heights;

        if (Ray.half) yf = RenderProcedure.cameraY;

        delta = (double) 128 / ((double) 2 * heights);

        posTexY = 0;

        ltexX = RenderInfoBuffer.mapsprite[InPoint.countPos];
        int texXX = (byte) (((64 - (int)tex) & 0x3f));

        if(ltexX != 0){
            texX = ltexX + (double) (32*RenderProcedure.SCREEN_STEP)/ heights;

            if (texX > 127) {
                texX = 127;
            }

            if (texX < 0) {
                texX = 0;
            }

        }else {
            texX = ((63 - tex));

            if (texX < 0) {
                texX = 0;
            }
            if (PointOnRay.intdeltaPosX < 31 ) {
                texX =(127 - texX);
            }


        }
        dtexX = (texX - ltexX) / (double) RenderProcedure.SCREEN_STEP;
    }
    public static void render(double heights,double tex,int shadows){


        prepare(heights,tex);


        for (int n = (int) ys; n < yf; n++) {
            if (n >= PreColumn.minY && n >= 0 && n < RenderProcedure.SCREEN_HEIGHT) {

                double ttexX = ltexX;

                for (int k = 0; k < RenderProcedure.SCREEN_STEP; k++) {
                    final int count = Ray.countPosBuffer(k, n);

                    if (RenderInfoBuffer.reservedSpritePixels[count] == 0) {
                        int col;

                        col = TextureContainer.spriteTex.getPixel((int) (ttexX), (int) posTexY & 0x7f,shadows) & 0xFFFFFF;

                        RenderInfoBuffer.reservedSpritePixels[count] = col;
                    }

                    ttexX += dtexX;
                }

            }
            posTexY += delta;
        }
        RenderInfoBuffer.mapsprite[InPoint.countPos] = texX;
    }
}
