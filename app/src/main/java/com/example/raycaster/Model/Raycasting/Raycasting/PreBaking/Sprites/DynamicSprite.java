package com.example.raycaster.Model.Raycasting.Raycasting.PreBaking.Sprites;

import com.example.raycaster.Model.Raycasting.Raycasting.Analyse.Entities.Ray;
import com.example.raycaster.Model.Raycasting.Raycasting.Analyse.Entities.Sight;
import com.example.raycaster.Model.Raycasting.Raycasting.PreBaking.Math.Functions;
import com.example.raycaster.Model.Raycasting.Raycasting.PreBaking.Ray.PointOnRay;
import com.example.raycaster.View.Raycasting.Sprites.SpriteRotateColumn;

public final class DynamicSprite {

    public static boolean statusofangle = false;

    public static void renderDynamicSprite(double heights,int shadows){


        final double fun = (double) (-Sight.tan * (double) PointOnRay.intdeltaPosX + Sight.tan * (double) Sight.spritePosX + (double) Sight.spritePosY);


        final double posTexX = Functions.getSqrt(SpriteDetector.eq) + 1;
        statusofangle = PointOnRay.intdeltaPosY > fun;

        if (statusofangle != Ray.lstatusofAngle) {

            SpriteRotateColumn.render(heights, posTexX, shadows);

        }

    }

}
