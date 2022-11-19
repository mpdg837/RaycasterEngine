package com.example.rayx.Model.Raycasting.Raycasting.PreBaking.Floor;

import com.example.rayx.Model.Raycasting.Quality;
import com.example.rayx.Model.Raycasting.Raycasting.Analyse.RenderSteps.Ray;
import com.example.rayx.Model.Raycasting.Raycasting.PreBaking.Ray.Buffers.PreColumn;
import com.example.rayx.Model.Raycasting.Raycasting.PreBaking.Ray.PointOnRay;
import com.example.rayx.Model.Raycasting.RenderProcedure;
import com.example.rayx.Model.Resources.Map.Map;
import com.example.rayx.View.Raycasting.BasicElements.FloorRender;

public final class FloorAndCeiling {

    static float heightBuffer = 0;
    public static  int hei;

    private FloorAndCeiling(){

    }

    private static int getHei(){
        int hei = (int)(PreColumn.lheightpos - PreColumn.height);

        if(hei == 0){
            heightBuffer += PreColumn.lheightpos - PreColumn.height;
            if(heightBuffer >= 1){
                hei = 1;
                heightBuffer = 0;
            }
        }else{
            heightBuffer = 0;
        }

        if(Ray.floorDown == -1) hei ++;

        return hei+2;
    }

    public static void renderFloor(int posX, int posY, boolean renderFloor, int posScreenX, float deltaPosY
            , float deltaPosX, float r, boolean half, boolean oneheight, boolean halfupx, int maxhh, int minhh){

        posScreenX += (Quality.SCREEN_STEP>>1);

        if (posScreenX != 0 && renderFloor) {

            hei = getHei();
            if(hei != 0) {
                final float heightx = PreColumn.height;

                if (RenderProcedure.cameraY + heightx < (RenderProcedure.canvasHeight << 1) - 1) {
                    final int ceil = Map.ceiling[posX][posY];

                    if (ceil != 0 || !half) {

                        final int poslY = PointOnRay.intdeltaPosY << 1;
                        final int poslX = PointOnRay.intdeltaPosX << 1;

                        if (!oneheight) {

                            Ceiling.analyse(r,ceil,minhh,heightx,maxhh,poslX,poslY,posScreenX,halfupx);

                            Floor.analyse(r,half,ceil,poslX,poslY,posScreenX,heightx);

                            FloorRender.posllX = poslX;
                            FloorRender.posllY = poslY;
                        }

                    }

                }
            }
        }
    }
}