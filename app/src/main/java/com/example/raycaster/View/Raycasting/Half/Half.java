package com.example.raycaster.View.Raycasting.Half;

import com.example.raycaster.Model.Raycasting.Raycasting.Analyse.Entities.InPoint;
import com.example.raycaster.Model.Raycasting.Raycasting.Analyse.Entities.Ray;
import com.example.raycaster.Model.Raycasting.Raycasting.Analyse.Entities.Sight;
import com.example.raycaster.Model.Raycasting.Raycasting.Analyse.WallHit;
import com.example.raycaster.Model.Raycasting.Raycasting.PreBaking.Ray.AngleRay;
import com.example.raycaster.Model.Raycasting.Raycasting.PreBaking.Ray.PointOnRay;
import com.example.raycaster.Model.Raycasting.Raycasting.RenderInfoBuffer;
import com.example.raycaster.Model.Raycasting.RenderProcedure;
import com.example.raycaster.Model.Resources.Map.Map;
import com.example.raycaster.View.Raycasting.BasicElements.Column;
import com.example.raycaster.View.Render;

import java.beans.IndexedPropertyChangeEvent;

public final class Half {


    private static void renderXWall(double heights,int shadow,double lheight){
        Column.drawLine((short) (Sight.posScreenX - RenderProcedure.D_SCREEN_STEP), (int) heights, (int) lheight,
                PointOnRay.intdeltaPosX, Sight.lcolumnhalf, shadow, Ray.half, false, 0, 400
                , false, Ray.lceili, false, true);

    }

    private static void renderYWall(double heights,int shadow,double lheight){
        Column.drawLine((short) (Sight.posScreenX - RenderProcedure.D_SCREEN_STEP), (int) heights, (int) lheight,
                PointOnRay.intdeltaPosY, Sight.lcolumnhalf, shadow, Ray.half, false, 0, 400
                , false, Ray.lceili, false, true);

    }

    private static void renderNWall(double heights,double lheight){
        Column.drawLine((short) (Sight.posScreenX - RenderProcedure.D_SCREEN_STEP), (int) heights, (int) lheight,
                Sight.lcolumnhalf, Sight.lcolumnhalf, Sight.lshadowh, Ray.half, false, 0, 400
                , false, Ray.lceili, false, true);
    }

    public static void renderHalfBlock(double heights){
        if(!Ray.half && Sight.renderwall) {

            double lheight = RenderInfoBuffer.lhhsheight[InPoint.countPos];

            if(lheight == 0) {
                if(Sight.halflheight ==0) {
                    lheight = heights;
                    Sight.halflheight = lheight;
                }
                    else lheight = Sight.halflheight;

                if (Map.isNeighbourhood((int) PointOnRay.posX, (int) PointOnRay.posY, Sight.halflposX, Sight.halflposY)) {

                    if (Column.noTrapeze(PointOnRay.deltaPosY, AngleRay.val)) {
                        lheight = heights;
                    }

                }
            }

            int shadow = 0;

            if ((WallHit.pY1 || WallHit.pY2)) {

                if (WallHit.pY1) shadow += 2;

                renderXWall(heights,shadow,lheight);

                Sight.lcolumnhalf = PointOnRay.intdeltaPosX;
                Sight.lshadowh = shadow;
            } else if (WallHit.pY) {


                shadow = 2;
                if (WallHit.pX1) shadow += 2;

                renderYWall(heights,shadow,lheight);
                Sight.lcolumnhalf = PointOnRay.intdeltaPosY;
                Sight.lshadowh = shadow;
            } else {
                renderNWall(heights,heights);

            }

            bufferInfo(heights);
        }

        Ray.half = true;
    }

    public static void bufferInfo(double heights){

        Sight.halflheight = heights;
        RenderInfoBuffer.lhhsheight[InPoint.countPos] = heights;

        Sight.halflposX = (int)PointOnRay.posX;
        Sight.halflposY = (int)PointOnRay.posY;
    }
}
