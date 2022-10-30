package com.example.raycaster.View.Raycasting.UpperBlocks.Other;

import com.example.raycaster.Model.Raycasting.Quality;
import com.example.raycaster.Model.Raycasting.Raycasting.Analyse.RenderSteps.InPoint;
import com.example.raycaster.Model.Raycasting.Raycasting.Analyse.RenderSteps.Ray;
import com.example.raycaster.Model.Raycasting.Raycasting.Analyse.RenderSteps.Sight;
import com.example.raycaster.Model.Raycasting.Raycasting.Analyse.WallHit;
import com.example.raycaster.Model.Raycasting.Raycasting.PreBaking.Ray.PointOnRay;
import com.example.raycaster.Model.Raycasting.Raycasting.PreBaking.Ray.Buffers.PreColumn;
import com.example.raycaster.Model.Raycasting.Raycasting.PreBaking.Ray.Buffers.BufferUpperColumn;
import com.example.raycaster.Model.Raycasting.Raycasting.MatrixBuffers.RenderInfoBuffer;
import com.example.raycaster.View.Raycasting.BasicElements.Column;
import com.example.raycaster.View.Raycasting.UpperBlocks.Upper;

public final class UpperBuildingBlocks extends Upper {

    public static int maxh;

    protected static void renderXWall(float height,float lhaa, int shadow){
        Column.drawLine((short) (Sight.posScreenX - Quality.D_SCREEN_STEP), (int) height, (int)lhaa, PointOnRay.intdeltaPosX,  RenderInfoBuffer.lupperd[InPoint.countPos],
                shadow,Ray.half, true,  PreColumn.llminh,  PreColumn.llmaxh, false,Ray.lceili,true,false);

    }

    protected static void renderYWall(float height,float lhaa,int shadow){
        Column.drawLine((short) (Sight.posScreenX - Quality.D_SCREEN_STEP), (int) height, (int) lhaa, PointOnRay.intdeltaPosY,RenderInfoBuffer.lupperd[InPoint.countPos],
                shadow, Ray.half, true,  PreColumn.llminh,  PreColumn.llmaxh, false,Ray.lceili,true,false);

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

                BufferUpperColumn.bufferUpperBuildingColumn(height);
            }
        }
    }
}
