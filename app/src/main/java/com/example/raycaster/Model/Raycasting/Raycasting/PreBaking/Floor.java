package com.example.raycaster.Model.Raycasting.Raycasting.PreBaking;

import com.example.raycaster.Model.Raycasting.Quality;
import com.example.raycaster.Model.Resources.Map.Map;
import com.example.raycaster.Model.Raycasting.Raycasting.Analyse.RenderSteps.Ray;
import com.example.raycaster.Model.Raycasting.Raycasting.PreBaking.Ray.PointOnRay;
import com.example.raycaster.Model.Raycasting.Raycasting.PreBaking.Ray.Buffers.PreColumn;
import com.example.raycaster.Model.Raycasting.RenderProcedure;
import com.example.raycaster.View.Raycasting.BasicElements.FloorRender;

public final class Floor {

    static float heightBuffer = 0;
    public static  int hei;

    private Floor(){

    }

    private static int getHei(float r){
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
        return hei+2;
    }

    public static void renderFloor(int posX, int posY, boolean renderFloor, int posScreenX, float deltaPosY
            , float deltaPosX, float r, boolean half, boolean oneheight, boolean halfupx, int maxhh, int minhh){

        posScreenX += (Quality.SCREEN_STEP>>1);

        if (posScreenX != 0 && renderFloor) {

            hei = getHei(r);
            if(hei != 0) {
                final float heightx = PreColumn.height;

                if (RenderProcedure.cameraY + heightx < (RenderProcedure.canvasHeight << 1) - 1) {
                    final int ceil = Map.ceiling[posX][posY];

                    if (ceil != 0 || !half) {

                        final int poslY = PointOnRay.intdeltaPosY << 1;
                        final int poslX = PointOnRay.intdeltaPosX << 1;


                        int posstart = (int) (RenderProcedure.cameraY - heightx - heightx * ((ceil - 1) << 1));
                        int posfinish = (int) (RenderProcedure.cameraY + heightx);



                        if (!oneheight) {
                            if (ceil != 0 && !(ceil == 2 && Ray.luppershapeR)) {

                                if (posstart > PreColumn.maxh) {
                                    boolean inhalfup = (posstart > minhh && posstart < maxhh);

                                    if (posstart < PreColumn.minh && !inhalfup) {
                                        FloorRender.renderCeiling(r,ceil,hei,poslX,poslY,posScreenX,posstart);
                                    }

                                }

                                if (ceil == 1) {

                                    if(PreColumn.maxh < posstart)
                                        PreColumn.maxh = posstart;

                                }



                            }


                            if (!half && !Ray.oneheight) {

                                FloorRender.renderFloorDown(r,ceil,hei,poslX,poslY,posScreenX,posfinish);


                            }

                            FloorRender.posllX = poslX;
                            FloorRender.posllY = poslY;
                        }

                    }

                }
            }
        }
    }
}