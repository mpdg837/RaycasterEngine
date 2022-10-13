package com.example.raycaster.Model.Raycasting.Raycasting.PreBaking.Sprites;

import com.example.raycaster.Model.Raycasting.Raycasting.Analyse.Entities.Ray;
import com.example.raycaster.Model.Raycasting.Raycasting.Analyse.Entities.Sight;
import com.example.raycaster.View.Raycasting.Half.Half;
import com.example.raycaster.View.Raycasting.Half.HalfShapes;
import com.example.raycaster.Model.Raycasting.Raycasting.PreBaking.Ray.PointOnRay;
import com.example.raycaster.Model.Raycasting.Raycasting.PreBaking.Ray.PreColumns.PreColumn;
import com.example.raycaster.View.Raycasting.Sprites.SpriteColumn;

public final class Sprites {



    private static int getShadowValue() {
        return (Ray.ceili == 1) ? 4 : 0;
    }



    public static void renderHalf(double heights){
        Ray.sprite = true;
        if (Sight.obj == 4) {
            Half.renderHalfBlock(heights);
        } else {

            final int fun = (int) (-Sight.tan * (double) PointOnRay.intdeltaPosX + Sight.tan * (double) Sight.spritePosX + (double) Sight.spritePosY);

            DynamicSprite.statusofangle = PointOnRay.intdeltaPosY > fun;
        }
    }


    public static void renderSprites(double r){
        if (!Ray.oneheight) {

            int shadows = getShadowValue();

            DynamicSprite.statusofangle = false;

            if (SpriteDetector.isSprite()) {

                final double heights =  PreColumn.height;


                if(Sight.obj == 12){

                   HalfShapes.renderHalfShapes(PointOnRay.intdeltaPosX,PointOnRay.intdeltaPosY);
                }else
                if (!Ray.sprite) {
                    renderHalf(heights);

                } else if ((Sight.obj == 3)) {
                    DynamicSprite.renderDynamicSprite(heights,shadows);

                } else if ((Sight.obj >= 8)) {

                    StaticSprite.renderStaticSprite(heights,shadows);

                }

                SpriteColumn.renderFloor(r);
                Ray.lstatusofAngle = DynamicSprite.statusofangle;
            } else {

                SpriteColumn.renderFloor(r);
            }
        } else {

            SpriteColumn.renderFloor(r);
        }

        Ray.spriterendered = true;
    }
}
