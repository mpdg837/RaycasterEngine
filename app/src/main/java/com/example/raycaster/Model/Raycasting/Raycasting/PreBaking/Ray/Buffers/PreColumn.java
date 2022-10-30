package com.example.raycaster.Model.Raycasting.Raycasting.PreBaking.Ray.Buffers;

import com.example.raycaster.Model.Raycasting.Raycasting.PreBaking.Ray.PointOnRay;
import com.example.raycaster.Model.Resources.Map.Map;
import com.example.raycaster.Model.Raycasting.Raycasting.Analyse.Entities.InPoint;
import com.example.raycaster.Model.Raycasting.Raycasting.Analyse.Entities.Ray;
import com.example.raycaster.Model.Raycasting.Raycasting.RenderInfoBuffer;
import com.example.raycaster.Model.Raycasting.RenderProcedure;

public final class PreColumn {

    public static int llmaxh;
    public static int llminh;

    public static int maxhh;
    public static int minhh;

    public static int maxh = 0;
    public static int minh = 0;
    public static int mminh = 0;

    public static float fakeHeight;
    public static float z;

    public static int uppernum;
    public static int uppernumh;

    public static int minY = 0;


    public static float height = 0;
    public static float lheightpos  =0;

    private PreColumn(){

    }

    public static void start(){

        maxh = 0;
        minh = 0;
        mminh = 0;

        maxh = 0;
        minh = RenderProcedure.cameraY<<1;

        llmaxh = RenderProcedure.cameraY<<1;
        llminh = 0;

        maxhh = 0;
        minhh = RenderProcedure.cameraY<<1;

        uppernum = 0;
        uppernumh = 0;

        fakeHeight = RenderProcedure.canvasHeight;
        z = 0;

        minY = 0;
        lheightpos =RenderProcedure.canvasHeight;
        Ray.halfupper = false;
    }

    public static float whenZero(float lha,float height,float lheight){
        if (lha == 0) {
            lha = lheight;
            if(lha == 0) lha = height;

            float ta = height / lha;
            if(ta>4|| ta<0.25) lha = height;
        }

        return lha;
    }

    public static void countHeight(){
        height = fakeHeight / z;
    }

    public static float getLastUpperHeight(float height){
        float lha = RenderInfoBuffer.lhheight[InPoint.countPos];

        if (Map.isNeighbourhood((int) PointOnRay.posX, (int) PointOnRay.posY, RenderInfoBuffer.lluposX[PreColumn.uppernum], RenderInfoBuffer.lluposY[ PreColumn.uppernum])) {
            lha = height;

        }

        lha = whenZero(lha,height,RenderInfoBuffer.llhheight[PreColumn.uppernum]);

        return lha;
    }

    public static void bufferUpperColumn(float height){

        RenderInfoBuffer.llhheight[ PreColumn.uppernum] = height;


        RenderInfoBuffer.lluposX[ PreColumn.uppernum] = (int) PointOnRay.posX;
        RenderInfoBuffer.lluposY[ PreColumn.uppernum] = (int) PointOnRay.posY;


        RenderInfoBuffer.lhheight[InPoint.countPos] = height;

        Ray.upper = true;


        if ( PreColumn.uppernum < RenderInfoBuffer.lhheight.length - 1)  PreColumn.uppernum++;
    }


}
