package com.example.raycaster.View.Raycasting.UpperBlocks.Full;

import com.example.raycaster.Model.Raycasting.Raycasting.Analyse.Entities.InPoint;
import com.example.raycaster.Model.Raycasting.Raycasting.Analyse.Entities.Ray;
import com.example.raycaster.Model.Raycasting.Raycasting.Analyse.Entities.Sight;
import com.example.raycaster.Model.Raycasting.Raycasting.Analyse.WallHit;
import com.example.raycaster.Model.Raycasting.Raycasting.PreBaking.Ray.PointOnRay;
import com.example.raycaster.Model.Raycasting.Raycasting.PreBaking.Ray.Buffers.PreColumn;
import com.example.raycaster.Model.Raycasting.Raycasting.RenderInfoBuffer;

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
