package com.example.rayx.View.Raycasting.Half;

import com.example.rayx.Model.Raycasting.Raycasting.Analyse.RenderSteps.InPoint;
import com.example.rayx.Model.Raycasting.Raycasting.Analyse.RenderSteps.Ray;
import com.example.rayx.Model.Raycasting.Raycasting.Analyse.RenderSteps.Sight;
import com.example.rayx.Model.Raycasting.Raycasting.Analyse.Hits.WallHit;
import com.example.rayx.Model.Raycasting.Raycasting.MatrixBuffers.UpperInfoBuffer;
import com.example.rayx.Model.Raycasting.Raycasting.PreBaking.Ray.AngleRay;
import com.example.rayx.Model.Raycasting.Raycasting.PreBaking.Ray.PointOnRay;
import com.example.rayx.Model.Resources.Map.Map;
import com.example.rayx.View.Raycasting.BasicElements.Column;

public final class Half extends RenderHalf{

    private Half(){

    }

    public static void renderHalfBlock(float heights){
        if(!Ray.half && Sight.renderwall) {

            float lheight = UpperInfoBuffer.lhhsheight[InPoint.countPos];

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


                renderXWall(heights,shadow,lheight);

                Sight.lcolumnhalf = PointOnRay.intdeltaPosX;
                Sight.lshadowh = shadow;
            } else if (WallHit.pY) {



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

    public static void bufferInfo(float heights){

        Sight.halflheight = heights;
        UpperInfoBuffer.lhhsheight[InPoint.countPos] = heights;

        Sight.halflposX = (int)PointOnRay.posX;
        Sight.halflposY = (int)PointOnRay.posY;
    }
}
