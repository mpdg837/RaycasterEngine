package com.example.raycaster.View.Raycasting.Sprites;

import com.example.raycaster.Model.Raycasting.Raycasting.Analyse.Entities.InPoint;
import com.example.raycaster.Model.Raycasting.Raycasting.Analyse.Entities.Ray;
import com.example.raycaster.Model.Raycasting.Raycasting.Analyse.Entities.Sight;
import com.example.raycaster.Model.Raycasting.Raycasting.PreBaking.Ray.PointOnRay;
import com.example.raycaster.Model.Raycasting.Raycasting.PreBaking.Ray.PreColumns.PreColumn;
import com.example.raycaster.Model.Raycasting.Raycasting.RenderInfoBuffer;
import com.example.raycaster.Model.Raycasting.RenderProcedure;
import com.example.raycaster.Model.Raycasting.Raycasting.Textures.TextureContainer;
import com.example.raycaster.View.Raycasting.BasicElements.Floor;

public final class SpriteColumn extends SpriteRenderer{

    private static double ys;
    private static double yf;

    private static  double delta;

    private static double posTexY;

    private static byte ltexX;
    private static byte texX;

    private static  double dtexX;

    public static void renderFloor(double r){
        Floor.renderFloor((int) PointOnRay.posX, (int) PointOnRay.posY, Ray.renderFloor, Sight.posScreenX, PointOnRay.deltaPosY, PointOnRay.deltaPosX, r,
                Ray.half, Ray.oneheight,Ray.halfupx == 1 || Ray.halfupx == 2, PreColumn.maxhh, PreColumn.minhh);

    }

    public static void prepare(double heights, int tex,boolean texM){
        ys = RenderProcedure.cameraY - heights;
        yf = RenderProcedure.cameraY + heights;

        if (Ray.half) yf = RenderProcedure.cameraY;

        delta = (double) 128 / ((double) 2 * heights);

        posTexY = 0;

        ltexX = RenderInfoBuffer.mapsprite[InPoint.countPos];

        if (texM) ltexX = RenderInfoBuffer.mapsprite2[InPoint.countPos];
        if (ltexX == 0) ltexX = (byte)tex;

        dtexX = ((double) tex - (double) ltexX) / (double) RenderProcedure.SCREEN_STEP;

    }
    public static void render(double heights,boolean texM,byte tex,int shadows){

        prepare(heights,tex,texM);
        int range = RenderProcedure.SCREEN_HEIGHT;

        for (int n = (int) ys; n < yf; n++) {

            if (n >= PreColumn.minY && n >= 0 && n < range) {

                double ttexX = ltexX;

                for (int k = 0; k < RenderProcedure.SCREEN_STEP; k++) {
                    final int count = Ray.countPosBuffer(k, n);

                    if (RenderInfoBuffer.reservedSpritePixels[count] == 0) {
                        int col;

                        if (Sight.obj == 10)
                            col =  TextureContainer.high.getPixel((int) (ttexX) << 1, (int) posTexY & 0x7f,shadows) & 0xFFFFFF;
                        else
                            col = TextureContainer.fence.getPixel((int) (ttexX) << 1, (int) posTexY & 0x7f,shadows) & 0xFFFFFF;
                        RenderInfoBuffer.reservedSpritePixels[count] = col;
                        ttexX += dtexX;
                    }
                }

            }
            posTexY += delta;
        }
        if (!texM) RenderInfoBuffer.mapsprite[InPoint.countPos] = tex;
        else RenderInfoBuffer.mapsprite2[InPoint.countPos] = tex;


    }
}
