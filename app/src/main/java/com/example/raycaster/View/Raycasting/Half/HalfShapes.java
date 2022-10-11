package com.example.raycaster.View.Raycasting.Half;

import com.example.raycaster.Model.Raycasting.Raycasting.Analyse.Entities.InPoint;
import com.example.raycaster.Model.Raycasting.Raycasting.Analyse.Entities.Ray;
import com.example.raycaster.Model.Raycasting.Raycasting.Analyse.Entities.Sight;
import com.example.raycaster.Model.Raycasting.Raycasting.PreBaking.Ray.PointOnRay;
import com.example.raycaster.Model.Raycasting.Raycasting.PreBaking.Ray.PreColumn;
import com.example.raycaster.Model.Raycasting.Raycasting.RenderInfoBuffer;
import com.example.raycaster.Model.Raycasting.RenderProcedure;
import com.example.raycaster.View.Raycasting.BasicElements.Column;

public final class HalfShapes {

    private static boolean inX;
    private static boolean inY;

    private static void detectShape(int intdeltaPosX,int intdeltaPosY){
        inX = intdeltaPosX > 16 && intdeltaPosX < 48;
        inY = intdeltaPosY > 16 && intdeltaPosY < 48;
    }

    private static int countShadowX(int intdeltaPosX,int shadow){
        if (intdeltaPosX < 19) {
            shadow = 1;
        } else {
            shadow = 2;
        }

        if (Ray.ceili == 1) {
            shadow += 3;
        }
        return shadow;
    }

    private static int countShadowY(int intdeltaPosY,int shadow){
        if (intdeltaPosY < 19) {
            shadow = 2;
        } else {
            shadow = 1;
        }

        if (Ray.ceili == 1) {
            shadow += 3;
        }
        return shadow;
    }

    private static void ignoreBigDiffrence(int value){
        int diff = value - Sight.lcolumnhalf;
        if (diff > 32 || diff < -32) {
            Sight.lcolumnhalf = value;
        }
    }

    private static void renderWall(double height,int intdeltaPosX,int shadow,double lheight){
        Column.drawLine((short) (Sight.posScreenX - RenderProcedure.D_SCREEN_STEP), (int) height, (int) lheight,
                intdeltaPosX, Sight.lcolumnhalf, shadow, false, false, 0, 400
                , false, Ray.lceili, false, true);

    }

    public static void renderHalfShapes(int intdeltaPosX,int intdeltaPosY){

        detectShape(intdeltaPosX,intdeltaPosY);

        if(inX && inY) {
            Ray.sprite = true;

            final double height =  PreColumn.height;

            int shadow = 0;

            if (!Ray.half && Sight.renderwall) {

                double lheight = RenderInfoBuffer.lhhsheight[InPoint.countPos];

                if(lheight == 0) lheight = height;

                if (PointOnRay.lintdeltaPosX <=16 || PointOnRay.lintdeltaPosX>=48) {

                    ignoreBigDiffrence(intdeltaPosY);

                    shadow = countShadowX(intdeltaPosY, shadow);
                    renderWall(height,intdeltaPosY,shadow,lheight);

                    Sight.lcolumnhalf = intdeltaPosY;

                } else {

                    ignoreBigDiffrence(intdeltaPosX);

                    shadow = countShadowY(intdeltaPosX, shadow);
                    renderWall(height,intdeltaPosX,shadow,lheight);


                    Sight.lcolumnhalf = intdeltaPosX;
                }

                RenderInfoBuffer.lhhsheight[InPoint.countPos] = height;
            }


            Ray.half = true;
        }

    }
}
