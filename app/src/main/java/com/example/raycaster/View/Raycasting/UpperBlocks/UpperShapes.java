package com.example.raycaster.View.Raycasting.UpperBlocks;

import com.example.raycaster.Model.Raycasting.Raycasting.Analyse.Entities.InPoint;
import com.example.raycaster.Model.Raycasting.Raycasting.Analyse.Entities.Ray;
import com.example.raycaster.Model.Raycasting.Raycasting.Analyse.Entities.Sight;
import com.example.raycaster.Model.Raycasting.Raycasting.Analyse.ShapeHit;
import com.example.raycaster.Model.Raycasting.Raycasting.PreBaking.Ray.PointOnRay;
import com.example.raycaster.Model.Raycasting.Raycasting.PreBaking.Ray.PreColumns.PreColumn;
import com.example.raycaster.Model.Raycasting.RenderProcedure;
import com.example.raycaster.View.Raycasting.BasicElements.Column;
import com.example.raycaster.Model.Raycasting.Raycasting.RenderInfoBuffer;

public final class UpperShapes{

    private static void  renderYWall(float height,float lha){
        Column.drawLine((short) (Sight.posScreenX - RenderProcedure.D_SCREEN_STEP), (int) height, (int) lha, PointOnRay.intdeltaPosY, RenderInfoBuffer.lcolumnh[InPoint.countPos],
                0, Ray.half, true,  PreColumn.llminh,  PreColumn.llmaxh, false, 0, false, false);

    }

    private static void  renderXWall(float height,float lha){
        Column.drawLine((short) (Sight.posScreenX - RenderProcedure.D_SCREEN_STEP), (int) height, (int) lha, PointOnRay.intdeltaPosX, RenderInfoBuffer.lcolumnh[InPoint.countPos],
                0, Ray.half, true,  PreColumn.llminh,  PreColumn.llmaxh, false, 0, false, false);

    }
    public static void renderUpperShapes(){

        if (ShapeHit.isInShape()) {

            ShapeHit.analyse();
            if (Sight.renderwall && !Ray.luppershape) {

                final float height =  PreColumn.fakeHeight/PreColumn.z;
                float lha = PreColumn.getLastUpperHeight(height);

                if(PointOnRay.lintdeltaPosX <=16 || PointOnRay.lintdeltaPosX>=48){

                    renderYWall(height,lha);
                    RenderInfoBuffer.lcolumnh[InPoint.countPos] = PointOnRay.intdeltaPosY;

                }else{
                    renderXWall(height,lha);
                    RenderInfoBuffer.lcolumnh[InPoint.countPos] = PointOnRay.intdeltaPosX;
                }



                PreColumn.bufferUpperColumn(height);
                Ray.luppershape = true;

            }

            Ray.luppershapeR = true;
            Ray.upperXa = true;
        }
    }
}
