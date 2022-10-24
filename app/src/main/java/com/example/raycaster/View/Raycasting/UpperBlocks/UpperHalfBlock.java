package com.example.raycaster.View.Raycasting.UpperBlocks;

import com.example.raycaster.Model.Raycasting.Raycasting.Analyse.Entities.InPoint;
import com.example.raycaster.Model.Raycasting.Raycasting.Analyse.Entities.Ray;
import com.example.raycaster.Model.Raycasting.Raycasting.Analyse.Entities.Sight;
import com.example.raycaster.Model.Raycasting.Raycasting.Analyse.WallHit;
import com.example.raycaster.Model.Raycasting.Raycasting.PreBaking.Ray.PreColumns.HalfPreColumn;
import com.example.raycaster.Model.Raycasting.Raycasting.PreBaking.Ray.PointOnRay;
import com.example.raycaster.Model.Raycasting.Raycasting.PreBaking.Ray.PreColumns.PreColumn;
import com.example.raycaster.Model.Raycasting.Raycasting.RenderInfoBuffer;
import com.example.raycaster.Model.Raycasting.RenderProcedure;
import com.example.raycaster.View.Raycasting.BasicElements.Column;

public final class UpperHalfBlock extends Upper {

    private static void renderXWall(float height,float lha,int shadow){
        Column.drawLine((short) (Sight.posScreenX - RenderProcedure.D_SCREEN_STEP), (int) height, (int) Sight.luheight, PointOnRay.intdeltaPosX,
                RenderInfoBuffer.lcolumnh[InPoint.countPos], shadow, Ray.half, false,  PreColumn.llminh,  PreColumn.llmaxh,true,0,false,
                false,false);

    }

    private static void renderYWall(float height, float lha, int shadow){
        Column.drawLine((short) (Sight.posScreenX - RenderProcedure.D_SCREEN_STEP), (int) height, (int) Sight.luheight, PointOnRay.intdeltaPosY,
                RenderInfoBuffer.lcolumnh[InPoint.countPos], shadow, Ray.half, false, PreColumn.llminh, PreColumn.llmaxh,true,0,false,
                false,false);
    }

    private static void renderNWall(float height,float lha, int shadow){

        Column.drawLine((short) (Sight.posScreenX - RenderProcedure.D_SCREEN_STEP), (int) height, (int) Sight.luheight, Sight.lcolumnhx,
                Sight.lcolumnhx, shadow, Ray.half, false,  PreColumn.llminh,  PreColumn.llmaxh,true,0,false,false,false);
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
