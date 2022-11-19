package com.example.rayx.View.Raycasting.Blocks;

import com.example.rayx.Model.Raycasting.Quality;
import com.example.rayx.Model.Raycasting.Raycasting.Analyse.Hits.WallHit;
import com.example.rayx.Model.Raycasting.Raycasting.Analyse.RenderSteps.InPoint;
import com.example.rayx.Model.Raycasting.Raycasting.Analyse.RenderSteps.Ray;
import com.example.rayx.Model.Raycasting.Raycasting.Analyse.RenderSteps.Sight;
import com.example.rayx.Model.Raycasting.Raycasting.MatrixBuffers.RenderInfoBuffer;
import com.example.rayx.Model.Raycasting.Raycasting.PreBaking.Ray.Buffers.PreColumn;
import com.example.rayx.Model.Raycasting.Raycasting.PreBaking.Ray.PointOnRay;
import com.example.rayx.View.Raycasting.BasicElements.Column;
import com.example.rayx.View.Render;

public final class Stairs{

    private Stairs(){

    }

    private static int getTexturePos(){
        if ((WallHit.pY1 || WallHit.pY2)) return PointOnRay.intdeltaPosX;
        else return PointOnRay.intdeltaPosY;
    }
    private static void analyseUpperStair(int height){
        if(Ray.floorDown != 0 && Ray.lfloorDown==0) {
            if (Sight.renderwall) {


                if (Ray.floorDown == 1) {
                    renderStairColumn(1,height);
                }
            }
        }
    }

    private static void renderStairColumn(int floorH, int height){
        int tex = getTexturePos();
        int ltex = RenderInfoBuffer.lstarircolumn[InPoint.countPos];

        Column.drawLine((short) (Sight.posScreenX - Quality.D_SCREEN_STEP), (int) height, (int) height,tex,
                ltex, 1, false, false, 0, Render.SCREEN_HEIGHT,
                false, 0, false, false, floorH);

        RenderInfoBuffer.lstarircolumn[InPoint.countPos] = tex;
    }
    private static void analyseDownStair(int height){
        if(Ray.lfloorDown != 0 && Ray.floorDown==0){
            if(Sight.renderwall) {
                if (Ray.lfloorDown == -1) {
                    renderStairColumn(-1,height);

                }
            }
        }
    }
    public static void analyseStairs(){
        int height = (int) PreColumn.height;

        analyseDownStair(height);
        analyseUpperStair(height);

        Ray.lfloorDown = Ray.floorDown;

    }
}
