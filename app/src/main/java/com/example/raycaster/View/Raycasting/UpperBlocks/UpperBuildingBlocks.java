package com.example.raycaster.View.Raycasting.UpperBlocks;

import com.example.raycaster.Model.Raycasting.Raycasting.Analyse.Entities.InPoint;
import com.example.raycaster.Model.Raycasting.Raycasting.Analyse.Entities.Ray;
import com.example.raycaster.Model.Raycasting.Raycasting.Analyse.Entities.Sight;
import com.example.raycaster.Model.Raycasting.Raycasting.Analyse.WallHit;
import com.example.raycaster.Model.Raycasting.Raycasting.PreBaking.Ray.PointOnRay;
import com.example.raycaster.Model.Raycasting.Raycasting.PreBaking.Ray.PreColumns.PreColumn;
import com.example.raycaster.Model.Raycasting.Raycasting.PreBaking.Ray.PreColumns.UpperPreColumn;
import com.example.raycaster.Model.Raycasting.Raycasting.RenderInfoBuffer;
import com.example.raycaster.Model.Raycasting.RenderProcedure;
import com.example.raycaster.View.Raycasting.BasicElements.Column;

public final class UpperBuildingBlocks extends Upper {

    private static void renderXWall(float height,float lhaa, int shadow){
        Column.drawLine((short) (Sight.posScreenX - RenderProcedure.D_SCREEN_STEP), (int) height, (int)lhaa, PointOnRay.intdeltaPosX,  RenderInfoBuffer.lupperd[InPoint.countPos],
                shadow,Ray.half, true,  PreColumn.llminh,  PreColumn.llmaxh, false,Ray.lceili,true,false,false);

    }

    private static void renderYWall(float height,float lhaa,int shadow){
        Column.drawLine((short) (Sight.posScreenX - RenderProcedure.D_SCREEN_STEP), (int) height, (int) lhaa, PointOnRay.intdeltaPosY,RenderInfoBuffer.lupperd[InPoint.countPos],
                shadow, Ray.half, true,  PreColumn.llminh,  PreColumn.llmaxh, false,Ray.lceili,true,false,false);

    }
    public static void analyse(float height,int shadow,float lha,float lhaa){
        if(Ray.upperbuildingx && !Ray.lupperbuildingx  && Ray.outside){

            if (Sight.renderwall ) {


                if ((WallHit.pY1 || WallHit.pY2)) {

                    renderXWall(height,lhaa,shadow);
                    RenderInfoBuffer.lupperd[InPoint.countPos] = PointOnRay.intdeltaPosX;
                }else {


                    renderYWall(height,lhaa,shadow);

                    RenderInfoBuffer.lupperd[InPoint.countPos] = PointOnRay.intdeltaPosY;

                }

                if (!Ray.upperbuildingXa) {
                    Sight.lshadowu = shadow;
                }

                UpperPreColumn.bufferUpperBuildingColumn(height);
            }
        }
    }
}
