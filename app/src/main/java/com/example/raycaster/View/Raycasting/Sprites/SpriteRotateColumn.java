package com.example.raycaster.View.Raycasting.Sprites;

import com.example.raycaster.Model.Raycasting.Raycasting.Analyse.Entities.InPoint;
import com.example.raycaster.Model.Raycasting.Raycasting.Analyse.Entities.Ray;
import com.example.raycaster.Model.Raycasting.Raycasting.Analyse.Entities.Sight;
import com.example.raycaster.Model.Raycasting.Raycasting.PreBaking.Ray.PointOnRay;
import com.example.raycaster.Model.Raycasting.Raycasting.PreBaking.Ray.Buffers.PreColumn;
import com.example.raycaster.Model.Raycasting.Raycasting.RenderInfoBuffer;
import com.example.raycaster.Model.Raycasting.RenderProcedure;
import com.example.raycaster.Model.Raycasting.Raycasting.Textures.TextureContainer;

public final class SpriteRotateColumn extends SpriteRenderer{

    private static float ys;
    private static float yf;

    private static  float delta;

    private static float posTexY;

    private static float ltexX;
    private static float texX;

    private static  float dtexX;

    private SpriteRotateColumn(){

    }

    private static void startPointOfSprite(){

        if((RenderProcedure.angle<0 && RenderProcedure.angle>-RenderProcedure.pi) ||
                (RenderProcedure.angle<2*RenderProcedure.pi && RenderProcedure.angle>RenderProcedure.pi)) {
            if (Sight.tan > 0) {
                if (PointOnRay.intdeltaPosX < 32) {
                    texX = (127 - texX);
                }
            } else {
                if (PointOnRay.intdeltaPosX >= 32) {
                    texX = (127 - texX);
                }
            }
        }else{
            if (Sight.tan < 0) {
                if (PointOnRay.intdeltaPosX < 32) {
                    texX = (127 - texX);
                }
            } else {
                if (PointOnRay.intdeltaPosX >= 32) {
                    texX = (127 - texX);
                }
            }
        }
    }

    private static void prepare(float heights, float tex){
        ys = RenderProcedure.cameraY - heights;
        yf = RenderProcedure.cameraY + heights;

        if (Ray.half) yf = RenderProcedure.cameraY;

        delta = (float) 128 / ((float) 2 * heights);

        posTexY = 0;

        ltexX = RenderInfoBuffer.mapsprite[InPoint.countPos];
        int texXX = (byte) (((64 - (int)tex) & 0x3f));

        if(ltexX != 0){
            texX = ltexX + (float) (32*RenderProcedure.SCREEN_STEP)/ heights;

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

            startPointOfSprite();
        }
        dtexX = (texX - ltexX) / (float) RenderProcedure.SCREEN_STEP;
    }
    public static void render(float heights,float tex,int shadows){


        prepare(heights,tex);


        for (int n = (int) ys; n < yf; n++) {
            if (n >= PreColumn.minY && n >= 0 && n < RenderProcedure.SCREEN_HEIGHT) {

                float ttexX = ltexX;

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
