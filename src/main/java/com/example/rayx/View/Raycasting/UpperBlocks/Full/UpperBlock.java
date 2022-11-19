package com.example.rayx.View.Raycasting.UpperBlocks.Full;

import com.example.rayx.Model.Raycasting.Raycasting.Analyse.RenderSteps.InPoint;
import com.example.rayx.Model.Raycasting.Raycasting.Analyse.RenderSteps.Ray;
import com.example.rayx.Model.Raycasting.Raycasting.Analyse.RenderSteps.Sight;
import com.example.rayx.Model.Raycasting.Raycasting.Analyse.Hits.WallHit;
import com.example.rayx.Model.Raycasting.Raycasting.PreBaking.Ray.PointOnRay;
import com.example.rayx.Model.Raycasting.Raycasting.PreBaking.Ray.Buffers.PreColumn;
import com.example.rayx.Model.Raycasting.Raycasting.MatrixBuffers.RenderInfoBuffer;

public final class UpperBlock extends UpperFull {

    private UpperBlock(){

    }

    public static void analyse(float height,int shadow,float lha,float lhaa){

        Ray.upperXa = true;
        if (Sight.renderwall&& !Ray.luppershapeR) {

            if ((WallHit.pY1 || WallHit.pY2)) {

                renderXWall(height,lha,shadow);
                RenderInfoBuffer.lcolumnh[InPoint.countPos] = PointOnRay.intdeltaPosX;
                Sight.lcolumnhx = PointOnRay.intdeltaPosX;
            } else if (WallHit.pY) {


                renderYWall(height, lha, shadow);
                RenderInfoBuffer.lcolumnh[InPoint.countPos] = PointOnRay.intdeltaPosY;
                Sight.lcolumnhx = PointOnRay.intdeltaPosY;


            } else {
                renderNWall(lha);
            }

            if (!Ray.upper) {
                Sight.lshadowu = shadow;
            }

            PreColumn.bufferUpperColumn(height);
        }
    }
}
