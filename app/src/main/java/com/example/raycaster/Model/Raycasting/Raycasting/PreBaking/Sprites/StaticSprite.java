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

        if ((Sight.obj == 8) && (PointOnRay.intdeltaPosY>>2 == 8)) {
            if(Ray.spriteStableCounter>1) {
                start = true;
                tex = (byte) PointOnRay.intdeltaPosX;
            }
            Ray.spriteStableCounter = 0;
        }else
        if ((Sight.obj == 9) && (PointOnRay.intdeltaPosX>>2) == 8) {
            if(Ray.spriteStableCounter>1) {
                start = true;
                tex = (byte) PointOnRay.intdeltaPosY;

                Ray.spriteStableCounter = 0;
            }
        }else
        if ((Sight.obj == 10) && ((PointOnRay.intdeltaPosX>>2) == 8 || (PointOnRay.intdeltaPosY>>2) ==8)) {

            boolean centerX = PointOnRay.intdeltaPosX >> 2 == 8;
            boolean centerY = PointOnRay.intdeltaPosY >> 2 == 8;

            if(Ray.spriteStableCounter>1 || (centerX && centerY)) {
                start = true;
                texM = (PointOnRay.intdeltaPosX >> 2) == 8;
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

    public static void renderStaticSprite(float heights, int shadows){
        detectTypeOfStaticSprite();

        if (start) {

            SpriteColumn.render(heights,texM,tex,shadows);
        }
    }


}
