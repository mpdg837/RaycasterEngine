package com.example.raycaster.Model.Raycasting.Raycasting.PreBaking.Ray.PreColumns;

import com.example.raycaster.Model.Raycasting.Raycasting.Analyse.Entities.InPoint;
import com.example.raycaster.Model.Raycasting.Raycasting.Analyse.Entities.Ray;
import com.example.raycaster.Model.Raycasting.Raycasting.PreBaking.Ray.PointOnRay;
import com.example.raycaster.Model.Raycasting.Raycasting.RenderInfoBuffer;

public final class HalfPreColumn {

    public static void bufferHalfUpperColumn(float height){

        RenderInfoBuffer.llhheight[ PreColumn.uppernum] = height;


        RenderInfoBuffer.lluposX[ PreColumn.uppernum] = (int) PointOnRay.posX;
        RenderInfoBuffer.lluposY[ PreColumn.uppernum] = (int) PointOnRay.posY;

        RenderInfoBuffer.lhheight[InPoint.countPos] = height;

        Ray.upper = true;


        if ( PreColumn.uppernum < RenderInfoBuffer.lhheight.length - 1)  PreColumn.uppernum++;
    }
}
