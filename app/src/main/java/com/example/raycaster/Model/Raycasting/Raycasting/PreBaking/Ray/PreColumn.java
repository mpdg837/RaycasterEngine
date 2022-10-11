package com.example.raycaster.Model.Raycasting.Raycasting.PreBaking.Ray;

import com.example.raycaster.Model.Resources.Map.Map;
import com.example.raycaster.Model.Raycasting.Raycasting.Analyse.Entities.InPoint;
import com.example.raycaster.Model.Raycasting.Raycasting.Analyse.Entities.Ray;
import com.example.raycaster.Model.Raycasting.Raycasting.Analyse.Entities.Sight;
import com.example.raycaster.Model.Raycasting.Raycasting.RenderInfoBuffer;
import com.example.raycaster.Model.Raycasting.RenderProcedure;
import com.example.raycaster.View.Raycasting.BasicElements.Column;

public final class PreColumn {

    public static int llmaxh;
    public static int llminh;

    public static int maxhh;
    public static int minhh;

    public static double fakeHeight;
    public static double z;

    public static int uppernum;
    public static int uppernumh;

    public static int minY = 0;

    public static int maxh = 0;
    public static int minh = 0;

    public static double height = 0;

    public static void start(){

        maxh = 0;
        minh = 0;

        maxh = 0;
        minh = 400;

        llmaxh = 400;
        llminh = 0;

        maxhh = 0;
        minhh = 400;

        uppernum = 0;
        uppernumh = 0;

        fakeHeight = RenderProcedure.canvasHeight;
        z = 0;

        minY = 0;
    }

    public static void countHeight(){
        height = fakeHeight / z;
    }
    public static double getLastUpperHeight(double height){
        double lha = RenderInfoBuffer.lhheight[InPoint.countPos];

        if (Map.isNeighbourhood((int) PointOnRay.posX, (int) PointOnRay.posY, RenderInfoBuffer.lluposX[PreColumn.uppernum], RenderInfoBuffer.lluposY[ PreColumn.uppernum])) {
            if (Column.noTrapeze(PointOnRay.deltaPosY, AngleRay.val) || (!Sight.lupperXa || Ray.upperXa)) {
                lha = height;
            }
        }

        if (lha == 0) {
            lha = RenderInfoBuffer.llhheight[PreColumn.uppernum];
            if(lha == 0) lha = height;

            double ta = height / lha;
            if(ta>4|| ta<0.25) lha = height;
        }

        return lha;
    }

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

    public static void bufferUpperColumn(double height){

        RenderInfoBuffer.llhheight[ PreColumn.uppernum] = height;


        RenderInfoBuffer.lluposX[ PreColumn.uppernum] = (int) PointOnRay.posX;
        RenderInfoBuffer.lluposY[ PreColumn.uppernum] = (int) PointOnRay.posY;


        RenderInfoBuffer.lhheight[InPoint.countPos] = height;

        Ray.upper = true;


        if ( PreColumn.uppernum < RenderInfoBuffer.lhheight.length - 1)  PreColumn.uppernum++;
    }
    public static void bufferHalfUpperColumn(double height){

        RenderInfoBuffer.llhheight[ PreColumn.uppernum] = height;


        RenderInfoBuffer.lluposX[ PreColumn.uppernum] = (int) PointOnRay.posX;
        RenderInfoBuffer.lluposY[ PreColumn.uppernum] = (int) PointOnRay.posY;


        RenderInfoBuffer.lhheight[InPoint.countPos] = height;

        if ( PreColumn.uppernum < RenderInfoBuffer.lhheight.length - 1)  PreColumn.uppernum++;
    }

}
