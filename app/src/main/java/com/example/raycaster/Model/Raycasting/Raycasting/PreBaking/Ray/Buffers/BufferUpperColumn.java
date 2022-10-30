package com.example.raycaster.Model.Raycasting.Raycasting.PreBaking.Ray.Buffers;

import com.example.raycaster.Model.Raycasting.Raycasting.Analyse.RenderSteps.InPoint;
import com.example.raycaster.Model.Raycasting.Raycasting.Analyse.RenderSteps.Ray;
import com.example.raycaster.Model.Raycasting.Raycasting.MatrixBuffers.UpperInfoBuffer;
import com.example.raycaster.Model.Raycasting.Raycasting.PreBaking.Ray.PointOnRay;
import com.example.raycaster.Model.Resources.Map.Map;

public final class BufferUpperColumn {

    private BufferUpperColumn(){

    }


    public static float getLastUpperBuildingHeight(float height){
        float lhaa = UpperInfoBuffer.lhhheight[InPoint.countPos];

        if (Map.isNeighbourhood((int) PointOnRay.posX, (int) PointOnRay.posY, UpperInfoBuffer.llluposX[PreColumn.uppernumh],UpperInfoBuffer.llluposY[ PreColumn.uppernumh])) {
            lhaa = height;

        }
        lhaa = PreColumn.whenZero(lhaa,height,UpperInfoBuffer.lllhheight[PreColumn.uppernumh]);
        return lhaa;
    }

    public static void bufferUpperBuildingColumn(float height){
        UpperInfoBuffer.llluposX[PreColumn.uppernumh] = (int) PointOnRay.posX;
        UpperInfoBuffer.llluposY[PreColumn.uppernumh] = (int) PointOnRay.posY;


        UpperInfoBuffer.lhhheight[InPoint.countPos] = height;
        Ray.upperbuildingXa = true;

        UpperInfoBuffer.lllhheight[PreColumn.uppernumh] = height;
        if (PreColumn.uppernumh < UpperInfoBuffer.lhheight.length - 1)  PreColumn.uppernumh++;
    }


}
