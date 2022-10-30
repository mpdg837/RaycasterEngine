package com.example.raycaster.Model.Raycasting.Raycasting.PreBaking.Ray.Buffers;

import com.example.raycaster.Model.Raycasting.Raycasting.Analyse.Entities.InPoint;
import com.example.raycaster.Model.Raycasting.Raycasting.Analyse.Entities.Ray;
import com.example.raycaster.Model.Raycasting.Raycasting.PreBaking.Ray.PointOnRay;
import com.example.raycaster.Model.Raycasting.Raycasting.RenderInfoBuffer;
import com.example.raycaster.Model.Resources.Map.Map;

public final class BufferUpperColumn {

    private BufferUpperColumn(){

    }



    public static float getLastUpperBuildingHeight(float height){
        float lhaa = RenderInfoBuffer.lhhheight[InPoint.countPos];

        if (Map.isNeighbourhood((int) PointOnRay.posX, (int) PointOnRay.posY, RenderInfoBuffer.llluposX[PreColumn.uppernumh],RenderInfoBuffer.llluposY[ PreColumn.uppernumh])) {
            lhaa = height;

        }
        lhaa = PreColumn.whenZero(lhaa,height,RenderInfoBuffer.lllhheight[PreColumn.uppernumh]);
        return lhaa;
    }

    public static void bufferUpperBuildingColumn(float height){
        RenderInfoBuffer.llluposX[PreColumn.uppernumh] = (int) PointOnRay.posX;
        RenderInfoBuffer.llluposY[PreColumn.uppernumh] = (int) PointOnRay.posY;


        RenderInfoBuffer.lhhheight[InPoint.countPos] = height;
        Ray.upperbuildingXa = true;

        RenderInfoBuffer.lllhheight[PreColumn.uppernumh] = height;
        if (PreColumn.uppernumh < RenderInfoBuffer.lhheight.length - 1)  PreColumn.uppernumh++;
    }


}
