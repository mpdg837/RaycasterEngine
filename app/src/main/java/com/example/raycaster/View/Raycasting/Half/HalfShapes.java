package com.example.raycaster.View.Raycasting.Half;

import com.example.raycaster.Model.Raycasting.Raycasting.Analyse.RenderSteps.InPoint;
import com.example.raycaster.Model.Raycasting.Raycasting.Analyse.RenderSteps.Ray;
import com.example.raycaster.Model.Raycasting.Raycasting.Analyse.RenderSteps.Sight;
import com.example.raycaster.Model.Raycasting.Raycasting.Analyse.ShapeHit;
import com.example.raycaster.Model.Raycasting.Raycasting.MatrixBuffers.UpperInfoBuffer;
import com.example.raycaster.Model.Raycasting.Raycasting.PreBaking.Ray.Buffers.PreColumn;
import com.example.raycaster.Model.Raycasting.Raycasting.PreBaking.Ray.PointOnRay;

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

                float lheight = UpperInfoBuffer.lhhsheight[InPoint.countPos];

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

                UpperInfoBuffer.lhhsheight[InPoint.countPos] = height;
            }


            Ray.half = true;
        }

    }
}
