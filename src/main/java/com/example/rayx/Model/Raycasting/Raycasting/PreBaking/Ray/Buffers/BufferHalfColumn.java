package com.example.rayx.Model.Raycasting.Raycasting.PreBaking.Ray.Buffers;

import com.example.rayx.Model.Raycasting.Raycasting.Analyse.RenderSteps.InPoint;
import com.example.rayx.Model.Raycasting.Raycasting.Analyse.RenderSteps.Ray;
import com.example.rayx.Model.Raycasting.Raycasting.MatrixBuffers.UpperInfoBuffer;
import com.example.rayx.Model.Raycasting.Raycasting.PreBaking.Ray.PointOnRay;

public final class BufferHalfColumn {

    private BufferHalfColumn(){

    }
    public static void bufferHalfUpperColumn(float height){

        UpperInfoBuffer.llhheight[ PreColumn.uppernum] = height;


        UpperInfoBuffer.lluposX[ PreColumn.uppernum] = (int) PointOnRay.posX;
        UpperInfoBuffer.lluposY[ PreColumn.uppernum] = (int) PointOnRay.posY;

        UpperInfoBuffer.lhheight[InPoint.countPos] = height;

        Ray.upper = true;


        if ( PreColumn.uppernum < UpperInfoBuffer.lhheight.length - 1)  PreColumn.uppernum++;
    }
}
