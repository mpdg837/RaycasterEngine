package com.example.raycaster.View.Raycasting.UpperBlocks;

import com.example.raycaster.Model.Raycasting.Raycasting.Analyse.Entities.InPoint;
import com.example.raycaster.Model.Raycasting.Raycasting.Analyse.Entities.Ray;
import com.example.raycaster.Model.Raycasting.Raycasting.Analyse.Entities.Sight;
import com.example.raycaster.Model.Raycasting.Raycasting.Analyse.WallHit;
import com.example.raycaster.Model.Raycasting.Raycasting.PreBaking.Ray.PointOnRay;
import com.example.raycaster.Model.Raycasting.Raycasting.PreBaking.Ray.PreColumn;
import com.example.raycaster.Model.Raycasting.Raycasting.RenderInfoBuffer;
import com.example.raycaster.Model.Raycasting.RenderProcedure;
import com.example.raycaster.View.Raycasting.BasicElements.Column;

public final class UpperHalfBlock extends Upper {

    private static void renderXWall(double height,double lha,int shadow){
        Column.drawLine((short) (Sight.posScreenX - RenderProcedure.D_SCREEN_STEP), (int) height, (int) Sight.luheight, PointOnRay.intdeltaPosX,
                RenderInfoBuffer.lcolumnh[InPoint.countPos], shadow, Ray.half, false,  PreColumn.llminh,  PreColumn.llmaxh,true,0,false,false);

    }

    private static void renderYWall(double height, double lha, int shadow){
        Column.drawLine((short) (Sight.posScreenX - RenderProcedure.D_SCREEN_STEP), (int) height, (int) Sight.luheight, PointOnRay.intdeltaPosY,
                RenderInfoBuffer.lcolumnh[InPoint.countPos], shadow, Ray.half, false, PreColumn.llminh, PreColumn.llmaxh,true,0,false,false);
    }

    private static void renderNWall(double height,double lha, int shadow){

        Column.drawLine((short) (Sight.posScreenX - RenderProcedure.D_SCREEN_STEP), (int) height, (int) Sight.luheight, Sight.lcolumnhx,
                Sight.lcolumnhx, shadow, Ray.half, false,  PreColumn.llminh,  PreColumn.llmaxh,true,0,false,false);
    }

    public static void analyse(double height,int shadow,double lha,double lhaa){
        if(Sight.renderwall) {

            Sight.luheight = lha;
            if(Sight.luheight == 0) Sight.luheight = height;

            if ((WallHit.pY1 || WallHit.pY2)) {
                if (WallHit.pY1) shadow += 2;

                renderXWall(height,lhaa,shadow);
                RenderInfoBuffer.lcolumnh[InPoint.countPos] = PointOnRay.intdeltaPosX;
                Sight.lcolumnhx = PointOnRay.intdeltaPosX;
            }else if(WallHit.pY){

                shadow = 2;

                if (WallHit.pX1) shadow += 2;

                renderYWall(height,lhaa,shadow);
                RenderInfoBuffer.lcolumnh[InPoint.countPos] = PointOnRay.intdeltaPosY;
                Sight.lcolumnhx = PointOnRay.intdeltaPosY;
            }else{
                renderNWall(height,lhaa,shadow);
            }

            PreColumn.bufferHalfUpperColumn(height);

        }

    }
}
