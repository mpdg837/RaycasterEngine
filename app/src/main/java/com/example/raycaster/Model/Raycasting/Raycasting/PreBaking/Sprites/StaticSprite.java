package com.example.raycaster.Model.Raycasting.Raycasting.PreBaking.Sprites;

import com.example.raycaster.Model.Raycasting.Raycasting.Analyse.Entities.Ray;
import com.example.raycaster.Model.Raycasting.Raycasting.Analyse.Entities.Sight;
import com.example.raycaster.Model.Raycasting.Raycasting.PreBaking.Ray.PointOnRay;
import com.example.raycaster.View.Raycasting.Sprites.SpriteColumn;

public final class StaticSprite {


    private static byte tex = 0;
    private static boolean start = false;
    private static boolean texM = false;

    public static void detectTypeOfStaticSprite(){
        tex = 0;
        start = false;
        texM = false;

        if ((Sight.obj == 8) && (PointOnRay.intdeltaPosY>>1 == 16)) {
            if(Ray.spriteStableCounter>2) {
                start = true;
                tex = (byte) PointOnRay.intdeltaPosX;
            }
            Ray.spriteStableCounter = 0;
        }else
        if ((Sight.obj == 9) && (PointOnRay.intdeltaPosX>>1) == 16) {
            if(Ray.spriteStableCounter>2) {
                start = true;
                tex = (byte) PointOnRay.intdeltaPosY;

                Ray.spriteStableCounter = 0;
            }
        }else
        if ((Sight.obj == 10) && ((PointOnRay.intdeltaPosX>>1) == 16 || (PointOnRay.intdeltaPosY>>1) == 16)) {

            boolean centerX = ((PointOnRay.intdeltaPosX>>1) < 18) && ((PointOnRay.intdeltaPosX>>1) > 14);
            boolean centerY = ((PointOnRay.intdeltaPosY>>1) < 18) && ((PointOnRay.intdeltaPosY>>1) > 14);

            if(Ray.spriteStableCounter>2 || (centerX && centerY)) {
                start = true;
                texM = (PointOnRay.intdeltaPosX >> 1) == 16;
                if (texM) {
                    tex = (byte) PointOnRay.intdeltaPosY;


                } else {
                    tex = (byte) PointOnRay.intdeltaPosX;


                }
            }

        }else{
            Ray.spriteStableCounter ++;
        }
    }

    public static void renderStaticSprite(double heights, int shadows){
        detectTypeOfStaticSprite();

        if (start) {

            SpriteColumn.render(heights,texM,tex,shadows);
        }
    }


}
