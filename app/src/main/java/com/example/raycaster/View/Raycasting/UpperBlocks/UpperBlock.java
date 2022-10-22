package com.example.raycaster.View.Raycasting.UpperBlocks;

import com.example.raycaster.Model.Raycasting.Raycasting.Analyse.Entities.InPoint;
import com.example.raycaster.Model.Raycasting.Raycasting.Analyse.Entities.Ray;
import com.example.raycaster.Model.Raycasting.Raycasting.Analyse.Entities.Sight;
import com.example.raycaster.Model.Raycasting.Raycasting.Analyse.WallHit;
import com.example.raycaster.Model.Raycasting.Raycasting.PreBaking.Ray.PointOnRay;
import com.example.raycaster.Model.Raycasting.Raycasting.PreBaking.Ray.PreColumns.PreColumn;
import com.example.raycaster.Model.Raycasting.Raycasting.RenderInfoBuffer;
import com.example.raycaster.Model.Raycasting.RenderProcedure;
import com.example.raycaster.View.Raycasting.BasicElements.Column;

public final class UpperBlock extends Upper {

    private static void renderXWall(float height,float lha,int shadow){
        Column.drawLine((short) (Sight.posScreenX - RenderProcedure.D_SCREEN_STEP), (int) height, (int)lha, PointOnRay.intdeltaPosX, RenderInfoBuffer.lcolumnh[InPoint.countPos],
                shadow, Ray.half, true,  PreColumn.llminh,  PreColumn.llmaxh,false,0,false,false);

    }

    private static void renderYWall(float height, float lha, int shadow){
        Column.drawLine((short) (Sight.posScreenX - RenderProcedure.D_SCREEN_STEP), (int) height, (int)lha, PointOnRay.intdeltaPosY, RenderInfoBuffer.lcolumnh[InPoint.countPos],
                shadow, Ray.half, true,  PreColumn.llminh,  PreColumn.llmaxh,false,0,false,false);

    }

    private static void renderNWall(float lha){

        Column.drawLine((short) (Sight.posScreenX - RenderProcedure.D_SCREEN_STEP), (int)lha, (int) lha, Sight.lcolumnhx, Sight.lcolumnhx, Sight.lshadowu,
                Ray.half, true,  PreColumn.llminh,  PreColumn.llmaxh,false,0,false,false);
    }


    public static void analyse(float height,int shadow,float lha,float lhaa){

        Ray.upperXa = true;
        if (Sight.renderwall) {

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
