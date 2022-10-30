package com.example.raycaster.View.Raycasting.UpperBlocks.Full;

import com.example.raycaster.Model.Raycasting.Raycasting.Analyse.Entities.InPoint;
import com.example.raycaster.Model.Raycasting.Raycasting.Analyse.Entities.Ray;
import com.example.raycaster.Model.Raycasting.Raycasting.Analyse.Entities.Sight;
import com.example.raycaster.Model.Raycasting.Raycasting.Analyse.ShapeHit;
import com.example.raycaster.Model.Raycasting.Raycasting.PreBaking.Ray.PointOnRay;
import com.example.raycaster.Model.Raycasting.Raycasting.PreBaking.Ray.Buffers.PreColumn;
import com.example.raycaster.Model.Raycasting.Raycasting.RenderInfoBuffer;

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
