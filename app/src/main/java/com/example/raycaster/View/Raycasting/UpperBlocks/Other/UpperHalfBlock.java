package com.example.raycaster.View.Raycasting.UpperBlocks.Other;

import com.example.raycaster.Model.Raycasting.Quality;
import com.example.raycaster.Model.Raycasting.Raycasting.Analyse.RenderSteps.InPoint;
import com.example.raycaster.Model.Raycasting.Raycasting.Analyse.RenderSteps.Ray;
import com.example.raycaster.Model.Raycasting.Raycasting.Analyse.RenderSteps.Sight;
import com.example.raycaster.Model.Raycasting.Raycasting.Analyse.WallHit;
import com.example.raycaster.Model.Raycasting.Raycasting.PreBaking.Ray.PointOnRay;
import com.example.raycaster.Model.Raycasting.Raycasting.PreBaking.Ray.Buffers.PreColumn;
import com.example.raycaster.Model.Raycasting.Raycasting.MatrixBuffers.RenderInfoBuffer;
import com.example.raycaster.View.Raycasting.BasicElements.Column;
import com.example.raycaster.View.Raycasting.UpperBlocks.Upper;

public final class UpperHalfBlock extends Upper {

    protected static void renderXWall(float height,float lha,int shadow){
        Column.drawLine((short) (Sight.posScreenX - Quality.D_SCREEN_STEP), (int) height, (int) Sight.luheight, PointOnRay.intdeltaPosX,
                RenderInfoBuffer.lcolumnh[InPoint.countPos], shadow, Ray.half, false,  PreColumn.llminh,  PreColumn.llmaxh,true,0,false,false);

    }

    protected static void renderYWall(float height, float lha, int shadow){
        Column.drawLine((short) (Sight.posScreenX - Quality.D_SCREEN_STEP), (int) height, (int) Sight.luheight, PointOnRay.intdeltaPosY,
                RenderInfoBuffer.lcolumnh[InPoint.countPos], shadow, Ray.half, false, PreColumn.llminh, PreColumn.llmaxh,true,0,false,false);
    }

    private static void renderNWall(float height,float lha, int shadow){

        Column.drawLine((short) (Sight.posScreenX - Quality.D_SCREEN_STEP), (int) height, (int) Sight.luheight, Sight.lcolumnhx,
                Sight.lcolumnhx, shadow, Ray.half, false,  PreColumn.llminh,  PreColumn.llmaxh,true,0,false,false);
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

            PreColumn.bufferUpperColumn(height);



        }
    }
}
