package com.example.rayx.View.Raycasting.Blocks;

import com.example.rayx.Model.Raycasting.Quality;
import com.example.rayx.Model.Raycasting.Raycasting.Analyse.RenderSteps.Ray;
import com.example.rayx.Model.Raycasting.Raycasting.Analyse.RenderSteps.Sight;
import com.example.rayx.Model.Raycasting.Raycasting.PreBaking.Ray.PointOnRay;
import com.example.rayx.View.Raycasting.BasicElements.Column;
import com.example.rayx.View.Render;

public class RenderObject {

    protected RenderObject(){

    }

    protected static void renderXWall(float height,int shadow, int lheight){
        Column.drawLine((short) (Sight.posScreenX - Quality.D_SCREEN_STEP), (int) height, lheight,
                PointOnRay.intdeltaPosX, Sight.lcolumn, shadow, Ray.half, false, 0, Render.SCREEN_HEIGHT
                , false, Ray.lceili, false, false,0);
    }

    protected static void renderYWall(float height,int shadow, int lheight){
        Column.drawLine((short) (Sight.posScreenX - Quality.D_SCREEN_STEP), (int) height, lheight,
                PointOnRay.intdeltaPosY, Sight.lcolumn, shadow, Ray.half, false, 0, Render.SCREEN_HEIGHT
                , false, Ray.lceili, false, false,0);
    }

    protected static void renderNWall(float height, int lheight){
        Column.drawLine((short) (Sight.posScreenX - Quality.D_SCREEN_STEP), (int) height,lheight,
                Sight.lcolumn, Sight.lcolumn, Sight.lshadow, Ray.half, false, 0, Render.SCREEN_HEIGHT
                , false, Ray.lceili, false, false,0);
    }

}
