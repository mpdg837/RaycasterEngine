package com.example.raycaster.View.Raycasting.Half;

import com.example.raycaster.Model.Raycasting.Raycasting.Analyse.Entities.InPoint;
import com.example.raycaster.Model.Raycasting.Raycasting.Analyse.Entities.Ray;
import com.example.raycaster.Model.Raycasting.Raycasting.Analyse.Entities.Sight;
import com.example.raycaster.Model.Raycasting.Raycasting.Analyse.ShapeHit;
import com.example.raycaster.Model.Raycasting.Raycasting.PreBaking.Ray.PointOnRay;
import com.example.raycaster.Model.Raycasting.Raycasting.PreBaking.Ray.Buffers.PreColumn;
import com.example.raycaster.Model.Raycasting.Raycasting.RenderInfoBuffer;

public final class HalfShapes extends RenderHalf{


    private HalfShapes(){

    }

    private static void ignoreBigDiffrence(int value){
        int diff = value - Sight.lcolumnhalf;
        if (diff > 32 || diff < -32) {
            Sight.lcolumnhalf = value;
        }
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
