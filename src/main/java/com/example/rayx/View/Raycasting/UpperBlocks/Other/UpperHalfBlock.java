package com.example.rayx.View.Raycasting.UpperBlocks.Other;

import com.example.rayx.Model.Raycasting.Quality;
import com.example.rayx.Model.Raycasting.Raycasting.Analyse.Hits.WallHit;
import com.example.rayx.Model.Raycasting.Raycasting.Analyse.RenderSteps.InPoint;
import com.example.rayx.Model.Raycasting.Raycasting.Analyse.RenderSteps.Ray;
import com.example.rayx.Model.Raycasting.Raycasting.Analyse.RenderSteps.Sight;
import com.example.rayx.Model.Raycasting.Raycasting.MatrixBuffers.RenderInfoBuffer;
import com.example.rayx.Model.Raycasting.Raycasting.PreBaking.Ray.Buffers.BufferHalfColumn;
import com.example.rayx.Model.Raycasting.Raycasting.PreBaking.Ray.Buffers.PreColumn;
import com.example.rayx.Model.Raycasting.Raycasting.PreBaking.Ray.PointOnRay;
import com.example.rayx.View.Raycasting.BasicElements.Column;
import com.example.rayx.View.Raycasting.UpperBlocks.Upper;

public final class UpperHalfBlock extends Upper {

    protected static void renderXWall(float height,float lha,int shadow){
        Column.drawLine((short) (Sight.posScreenX - Quality.D_SCREEN_STEP), (int) height, (int) Sight.luheight, PointOnRay.intdeltaPosX,
                RenderInfoBuffer.lcolumnh[InPoint.countPos], shadow, Ray.half, false,  PreColumn.llminh,  PreColumn.llmaxh,true,0,false,false,0);

    }

    protected static void renderYWall(float height, float lha, int shadow){
        Column.drawLine((short) (Sight.posScreenX - Quality.D_SCREEN_STEP), (int) height, (int) Sight.luheight, PointOnRay.intdeltaPosY,
                RenderInfoBuffer.lcolumnh[InPoint.countPos], shadow, Ray.half, false, PreColumn.llminh, PreColumn.llmaxh,true,0,false,false,0);
    }

    private static void renderNWall(float height,float lha, int shadow){

        Column.drawLine((short) (Sight.posScreenX - Quality.D_SCREEN_STEP), (int) height, (int) Sight.luheight, Sight.lcolumnhx,
                Sight.lcolumnhx, shadow, Ray.half, false,  PreColumn.llminh,  PreColumn.llmaxh,true,0,false,false,0);
    }

    public static void analyse(float height,int shadow,float lha,float lhaa){

        shadow = 0;
        if(Sight.renderwall && !Ray.luppershapeR) {

            Sight.luheight = lha;


            if ((WallHit.pY1 || WallHit.pY2)) {

                renderXWall(height,lha,shadow);
                RenderInfoBuffer.lcolumnh[InPoint.countPos] = PointOnRay.intdeltaPosX;
                Sight.lcolumnhx = PointOnRay.intdeltaPosX;
            }else if(WallHit.pY){

                renderYWall(height,lha,shadow);
                RenderInfoBuffer.lcolumnh[InPoint.countPos] = PointOnRay.intdeltaPosY;
                Sight.lcolumnhx = PointOnRay.intdeltaPosY;
            }else{
                renderNWall(height,lha,shadow);
            }

            BufferHalfColumn.bufferHalfUpperColumn(height);



        }
    }
}
