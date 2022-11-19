package com.example.rayx.Model.Raycasting.Raycasting.PreBaking.Sprites.Models;

import com.example.rayx.Model.Raycasting.Raycasting.Analyse.RenderSteps.Ray;
import com.example.rayx.Model.Raycasting.Raycasting.Analyse.RenderSteps.Sight;
import com.example.rayx.Model.Raycasting.Raycasting.PreBaking.Math.Functions;
import com.example.rayx.Model.Raycasting.Raycasting.PreBaking.Ray.PointOnRay;
import com.example.rayx.Model.Raycasting.Raycasting.PreBaking.Sprites.SpriteDetector;
import com.example.rayx.View.Raycasting.Sprites.SpriteRotateColumn;

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
