package com.example.rayx.View.Raycasting.UpperBlocks.Full;

import com.example.rayx.Model.Raycasting.Raycasting.Analyse.RenderSteps.InPoint;
import com.example.rayx.Model.Raycasting.Raycasting.Analyse.RenderSteps.Ray;
import com.example.rayx.Model.Raycasting.Raycasting.Analyse.RenderSteps.Sight;
import com.example.rayx.Model.Raycasting.Raycasting.Analyse.Hits.ShapeHit;
import com.example.rayx.Model.Raycasting.Raycasting.PreBaking.Ray.PointOnRay;
import com.example.rayx.Model.Raycasting.Raycasting.PreBaking.Ray.Buffers.PreColumn;
import com.example.rayx.Model.Raycasting.Raycasting.MatrixBuffers.RenderInfoBuffer;

public final class UpperShapes extends UpperFull{

    private UpperShapes(){

    }

    public static void renderUpperShapes(){

        if (ShapeHit.isInShape()) {

            ShapeHit.analyse();
            if (Sight.renderwall && !Ray.luppershape) {

                final float height =  PreColumn.fakeHeight/PreColumn.z;
                float lha = PreColumn.getLastUpperHeight(height);

                if(PointOnRay.lintdeltaPosX <=16 || PointOnRay.lintdeltaPosX>=48){

                    renderYWall(height,lha,0);
                    RenderInfoBuffer.lcolumnh[InPoint.countPos] = PointOnRay.intdeltaPosY;

                }else{
                    renderXWall(height,lha,0);
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
