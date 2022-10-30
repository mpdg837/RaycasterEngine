package com.example.raycaster.Model.Raycasting.Raycasting.PreBaking.Sprites.Models;

import com.example.raycaster.Model.Raycasting.Raycasting.Analyse.Entities.Ray;
import com.example.raycaster.Model.Raycasting.Raycasting.Analyse.Entities.Sight;
import com.example.raycaster.Model.Raycasting.Raycasting.PreBaking.Ray.PointOnRay;
import com.example.raycaster.View.Raycasting.Sprites.SpriteColumn;

public final class StaticSprite {


    private static byte tex = 0;
    private static boolean start = false;
    private static boolean texM = false;

    private static boolean inrange(int value){
        return value > 16 && value < 48;
    }

    private StaticSprite(){

    }

    public static boolean crossed(int value, int lvalue) {
        if (inrange(lvalue) && inrange(value))
            return (value > 32 && lvalue <= 32) || (value < 32 && lvalue >= 32);
        else
            return false;
    }
    public static void detectTypeOfStaticSprite(){
        tex = 0;
        start = false;
        texM = false;

        if ((Sight.obj == 8) && crossed(PointOnRay.intdeltaPosY,PointOnRay.lintdeltaPosY)) {

                start = true;
                tex = (byte) PointOnRay.intdeltaPosX;

        }else
        if ((Sight.obj == 9) && crossed(PointOnRay.intdeltaPosX,PointOnRay.lintdeltaPosX)) {

                start = true;
                tex = (byte) PointOnRay.intdeltaPosY;


        }else
        if ((Sight.obj == 10) &&
                (crossed(PointOnRay.intdeltaPosY,PointOnRay.lintdeltaPosY) ||
                        crossed(PointOnRay.intdeltaPosX,PointOnRay.lintdeltaPosX))) {

                start = true;
                texM = crossed(PointOnRay.intdeltaPosX,PointOnRay.lintdeltaPosX);

                if (texM) {
                    tex = (byte) PointOnRay.intdeltaPosY;


                } else {
                    tex = (byte) PointOnRay.intdeltaPosX;


                }


        }
    }

    public static void renderStaticSprite(float heights, int shadows){
        detectTypeOfStaticSprite();

        if (start) {

            SpriteColumn.render(heights,texM,tex,shadows);
        }
    }


}
