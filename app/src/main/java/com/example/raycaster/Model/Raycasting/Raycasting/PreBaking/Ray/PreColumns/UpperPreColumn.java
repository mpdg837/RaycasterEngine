package com.example.raycaster.Model.Raycasting.Raycasting.PreBaking.Ray.PreColumns;

import com.example.raycaster.Model.Raycasting.Raycasting.Analyse.Entities.InPoint;
import com.example.raycaster.Model.Raycasting.Raycasting.Analyse.Entities.Ray;
import com.example.raycaster.Model.Raycasting.Raycasting.Analyse.Entities.Sight;
import com.example.raycaster.Model.Raycasting.Raycasting.PreBaking.Ray.AngleRay;
import com.example.raycaster.Model.Raycasting.Raycasting.PreBaking.Ray.PointOnRay;
import com.example.raycaster.Model.Raycasting.Raycasting.RenderInfoBuffer;
import com.example.raycaster.Model.Resources.Map.Map;
import com.example.raycaster.View.Raycasting.BasicElements.Column;

public final class UpperPreColumn {


    public static double getLastUpperBuildingHeight(double height){
        double lhaa = RenderInfoBuffer.lhhheight[InPoint.countPos];

        if (Map.isNeighbourhood((int) PointOnRay.posX, (int) PointOnRay.posY, RenderInfoBuffer.llluposX[PreColumn.uppernumh],RenderInfoBuffer.llluposY[ PreColumn.uppernumh])) {
            if (Column.noTrapeze(PointOnRay.deltaPosY, AngleRay.val) || (!Sight.lupperbuildingXa || Ray.upperbuildingXa)) {
                lhaa = height;
            }
        }

        if (lhaa == 0) {
            lhaa = RenderInfoBuffer.lllhheight[PreColumn.uppernumh];
            if(lhaa == 0) lhaa = height;

            double taa = height / lhaa;
            if (taa > 4 || taa < 0.25) lhaa = height;
        }

        return lhaa;
    }

    public static void bufferUpperBuildingColumn(double height){
        RenderInfoBuffer.llluposX[PreColumn.uppernumh] = (int) PointOnRay.posX;
        RenderInfoBuffer.llluposY[PreColumn.uppernumh] = (int) PointOnRay.posY;


        RenderInfoBuffer.lhhheight[InPoint.countPos] = height;
        Ray.upperbuildingXa = true;

        RenderInfoBuffer.lllhheight[PreColumn.uppernumh] = height;
        if (PreColumn.uppernumh < RenderInfoBuffer.lhheight.length - 1)  PreColumn.uppernumh++;
    }


}
