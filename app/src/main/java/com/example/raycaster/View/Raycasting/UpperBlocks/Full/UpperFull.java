package com.example.raycaster.View.Raycasting.UpperBlocks.Full;

import com.example.raycaster.Model.Raycasting.Raycasting.Analyse.Entities.InPoint;
import com.example.raycaster.Model.Raycasting.Raycasting.Analyse.Entities.Ray;
import com.example.raycaster.Model.Raycasting.Raycasting.Analyse.Entities.Sight;
import com.example.raycaster.Model.Raycasting.Raycasting.PreBaking.Ray.PointOnRay;
import com.example.raycaster.Model.Raycasting.Raycasting.PreBaking.Ray.Buffers.PreColumn;
import com.example.raycaster.Model.Raycasting.Raycasting.RenderInfoBuffer;
import com.example.raycaster.Model.Raycasting.RenderProcedure;
import com.example.raycaster.View.Raycasting.BasicElements.Column;
import com.example.raycaster.View.Raycasting.UpperBlocks.Upper;

public class UpperFull extends Upper {

    protected UpperFull(){

    }

    protected static void renderXWall(float height,float lha,int shadow){
        Column.drawLine((short) (Sight.posScreenX - RenderProcedure.D_SCREEN_STEP), (int) height, (int)lha, PointOnRay.intdeltaPosX, RenderInfoBuffer.lcolumnh[InPoint.countPos],
                shadow, Ray.half, true,  PreColumn.llminh,  PreColumn.llmaxh,false,0,false,false);

    }

    protected static void renderYWall(float height, float lha, int shadow){
        Column.drawLine((short) (Sight.posScreenX - RenderProcedure.D_SCREEN_STEP), (int) height, (int)lha, PointOnRay.intdeltaPosY, RenderInfoBuffer.lcolumnh[InPoint.countPos],
                shadow, Ray.half, true,  PreColumn.llminh,  PreColumn.llmaxh,false,0,false,false);

    }

    protected static void renderNWall(float lha){

        Column.drawLine((short) (Sight.posScreenX - RenderProcedure.D_SCREEN_STEP), (int)lha, (int) lha, Sight.lcolumnhx, Sight.lcolumnhx, Sight.lshadowu,
                Ray.half, true,  PreColumn.llminh,  PreColumn.llmaxh,false,0,false,false);
    }


}
