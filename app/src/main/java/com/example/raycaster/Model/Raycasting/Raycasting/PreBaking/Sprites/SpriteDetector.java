package com.example.raycaster.Model.Raycasting.Raycasting.PreBaking.Sprites;

import com.example.raycaster.Model.Raycasting.Raycasting.Analyse.Entities.Sight;
import com.example.raycaster.Model.Raycasting.Raycasting.PreBaking.Ray.PointOnRay;
import com.example.raycaster.Model.Raycasting.RenderProcedure;

public final class SpriteDetector {

    public static int eq;

    private SpriteDetector(){

    }
    public static boolean isSprite(){
        boolean decision;

        if (Sight.obj != 3) decision = true;
        else {

            int sqx = (PointOnRay.intdeltaPosX - Sight.spritePosX);
            int sqy = (PointOnRay.intdeltaPosY - Sight.spritePosY);
            eq = sqx * sqx + sqy * sqy;
            decision = eq < 512;
        }


        if ((int) PointOnRay.posX == (int) RenderProcedure.pos.x && (int) PointOnRay.posY == (int) RenderProcedure.pos.y) {
            decision = false;
        }

        return decision;
    }

}
