package com.example.raycaster.Model.Raycasting.Raycasting.PreBaking.Sprites.Models;

import com.example.raycaster.Model.Raycasting.Raycasting.Analyse.Entities.Ray;
import com.example.raycaster.Model.Raycasting.Raycasting.Analyse.Entities.Sight;
import com.example.raycaster.Model.Raycasting.Raycasting.PreBaking.Math.Functions;
import com.example.raycaster.Model.Raycasting.Raycasting.PreBaking.Ray.PointOnRay;
import com.example.raycaster.Model.Raycasting.Raycasting.PreBaking.Sprites.SpriteDetector;
import com.example.raycaster.View.Raycasting.Sprites.SpriteRotateColumn;

public final class DynamicSprite {

    public static boolean statusofangle = false;

    private DynamicSprite(){

    }
    public static void renderDynamicSprite(float heights,int shadows){


        final float fun = (float) (-Sight.tan * (float) PointOnRay.intdeltaPosX + Sight.tan * (float) Sight.spritePosX + (float) Sight.spritePosY);


        final float posTexX = Functions.getSqrt(SpriteDetector.eq) + 1;
        statusofangle = PointOnRay.intdeltaPosY > fun;

        if (statusofangle != Ray.lstatusofAngle) {

            SpriteRotateColumn.render(heights, posTexX, shadows);

        }

    }

}
