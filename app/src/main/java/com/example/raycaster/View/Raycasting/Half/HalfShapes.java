package com.example.raycaster.View.Raycasting.Half;

import com.example.raycaster.Model.Raycasting.Raycasting.Analyse.Entities.InPoint;
import com.example.raycaster.Model.Raycasting.Raycasting.Analyse.Entities.Ray;
import com.example.raycaster.Model.Raycasting.Raycasting.Analyse.Entities.Sight;
import com.example.raycaster.Model.Raycasting.Raycasting.Analyse.ShapeHit;
import com.example.raycaster.Model.Raycasting.Raycasting.PreBaking.Ray.PointOnRay;
import com.example.raycaster.Model.Raycasting.Raycasting.PreBaking.Ray.PreColumns.PreColumn;
import com.example.raycaster.Model.Raycasting.Raycasting.RenderInfoBuffer;
import com.example.raycaster.Model.Raycasting.RenderProcedure;
import com.example.raycaster.View.Raycasting.BasicElements.Column;

public final class HalfShapes {

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

    private static void renderWall(float height,int intdeltaPosX,int shadow,float lheight){
        Column.drawLine((short) (Sight.posScreenX - RenderProcedure.D_SCREEN_STEP), (int) height, (int) lheight,
                intdeltaPosX, Sight.lcolumnhalf, shadow, false, false, 0, 400
                , false, Ray.lceili, false, true,false);

    }

    public static void renderHalfShapes(int intdeltaPosX,int intdeltaPosY){

        if(ShapeHit.isInShape()) {
            Ray.sprite = true;

            final float height =  PreColumn.height;

            int shadow = 0;

            if (!Ray.half && Sight.renderwall) {

                float lheight = RenderInfoBuffer.lhhsheight[InPoint.countPos];

                if(lheight == 0) lheight = height;

                if(Ray.ceili == 1){
                    shadow +=3;
                }

                if (PointOnRay.lintdeltaPosX <=16 || PointOnRay.lintdeltaPosX>=48) {

                    ignoreBigDiffrence(intdeltaPosY);

                    renderWall(height,intdeltaPosY,shadow,lheight);

                    Sight.lcolumnhalf = intdeltaPosY;

                } else {

                    ignoreBigDiffrence(intdeltaPosX);

                    renderWall(height,intdeltaPosX,shadow,lheight);


                    Sight.lcolumnhalf = intdeltaPosX;
                }

                RenderInfoBuffer.lhhsheight[InPoint.countPos] = height;
            }


            Ray.half = true;
        }

    }
}
