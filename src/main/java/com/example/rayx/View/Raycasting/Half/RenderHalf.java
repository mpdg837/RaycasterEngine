package com.example.rayx.View.Raycasting.Half;

import com.example.rayx.Model.Raycasting.Quality;
import com.example.rayx.Model.Raycasting.Raycasting.Analyse.RenderSteps.Ray;
import com.example.rayx.Model.Raycasting.Raycasting.Analyse.RenderSteps.Sight;
import com.example.rayx.Model.Raycasting.Raycasting.PreBaking.Ray.PointOnRay;
import com.example.rayx.View.Raycasting.BasicElements.Column;
import com.example.rayx.View.Render;

public class RenderHalf {
    protected RenderHalf(){

    }

    protected static void renderXWall(float heights,int shadow,float lheight){
        Column.drawLine((short) (Sight.posScreenX - Quality.D_SCREEN_STEP), (int) heights, (int) lheight,
                PointOnRay.intdeltaPosX, Sight.lcolumnhalf, shadow, Ray.half, false, 0, Render.SCREEN_HEIGHT
                , false, Ray.lceili, false, true,0);

    }

    protected static void renderYWall(float heights,int shadow,float lheight){
        Column.drawLine((short) (Sight.posScreenX - Quality.D_SCREEN_STEP), (int) heights, (int) lheight,
                PointOnRay.intdeltaPosY, Sight.lcolumnhalf, shadow, Ray.half, false, 0, Render.SCREEN_HEIGHT
                , false, Ray.lceili, false, true,0);

    }

    protected static void renderNWall(float heights,float lheight){
        Column.drawLine((short) (Sight.posScreenX - Quality.D_SCREEN_STEP), (int) heights, (int) lheight,
                Sight.lcolumnhalf, Sight.lcolumnhalf, Sight.lshadowh, Ray.half, false, 0, Render.SCREEN_HEIGHT
                , false, Ray.lceili, false, true,0);
    }


    protected static void renderWall(float height,int intdeltaPosX,int shadow,float lheight){
        Column.drawLine((short) (Sight.posScreenX - Quality.D_SCREEN_STEP), (int) height, (int) lheight,
                intdeltaPosX, Sight.lcolumnhalf, shadow, false, false, 0, Render.SCREEN_HEIGHT
                , false, Ray.lceili, false, true,0);

    }
}
