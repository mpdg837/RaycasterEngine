package com.example.raycaster.View.Raycasting.Half;

import com.example.raycaster.Model.Raycasting.Quality;
import com.example.raycaster.Model.Raycasting.Raycasting.Analyse.RenderSteps.Ray;
import com.example.raycaster.Model.Raycasting.Raycasting.Analyse.RenderSteps.Sight;
import com.example.raycaster.Model.Raycasting.Raycasting.PreBaking.Ray.PointOnRay;
import com.example.raycaster.View.Raycasting.BasicElements.Column;

public class RenderHalf {
    protected RenderHalf(){

    }

    protected static void renderXWall(float heights,int shadow,float lheight){
        Column.drawLine((short) (Sight.posScreenX - Quality.D_SCREEN_STEP), (int) heights, (int) lheight,
                PointOnRay.intdeltaPosX, Sight.lcolumnhalf, shadow, Ray.half, false, 0, 400
                , false, Ray.lceili, false, true);

    }

    protected static void renderYWall(float heights,int shadow,float lheight){
        Column.drawLine((short) (Sight.posScreenX - Quality.D_SCREEN_STEP), (int) heights, (int) lheight,
                PointOnRay.intdeltaPosY, Sight.lcolumnhalf, shadow, Ray.half, false, 0, 400
                , false, Ray.lceili, false, true);

    }

    protected static void renderNWall(float heights,float lheight){
        Column.drawLine((short) (Sight.posScreenX - Quality.D_SCREEN_STEP), (int) heights, (int) lheight,
                Sight.lcolumnhalf, Sight.lcolumnhalf, Sight.lshadowh, Ray.half, false, 0, 400
                , false, Ray.lceili, false, true);
    }


    protected static void renderWall(float height,int intdeltaPosX,int shadow,float lheight){
        Column.drawLine((short) (Sight.posScreenX - Quality.D_SCREEN_STEP), (int) height, (int) lheight,
                intdeltaPosX, Sight.lcolumnhalf, shadow, false, false, 0, 400
                , false, Ray.lceili, false, true);

    }
}
