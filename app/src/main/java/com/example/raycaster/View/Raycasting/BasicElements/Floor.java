package com.example.raycaster.View.Raycasting.BasicElements;

import com.example.raycaster.Model.Resources.Map.Map;
import com.example.raycaster.Model.Raycasting.Raycasting.Analyse.Entities.Ray;
import com.example.raycaster.Model.Raycasting.Raycasting.PreBaking.Ray.PointOnRay;
import com.example.raycaster.Model.Raycasting.Raycasting.PreBaking.Ray.PreColumns.PreColumn;
import com.example.raycaster.Model.Raycasting.RenderProcedure;
import com.example.raycaster.Model.Raycasting.Raycasting.Textures.TextureContainer;

public final class Floor {

    public static final double MAX_GOOD_QUALITY_DISTANCE_UP = 1.5;
    public static final double MAX_GOOD_QUALITY_DISTANCE_DOWN = 2;


    static double heightBuffer = 0;

    static int posllY;
    static int posllX;


    private static int getHei(double r){
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
        return hei + 1;
    }


    private static void renderCeiling(double r,int ceil, int hei, int poslX,int poslY,int posScreenX,int posstart){
        if (r < MAX_GOOD_QUALITY_DISTANCE_UP && ceil !=2 &&RenderProcedure.SCREEN_STEP == 4) {
            int[] color = new int[hei + (ceil - 1)];

            double posXa = posllX;
            double posYa = posllY;

            final double deltaPosXa = (double) (poslX - posllX) / (double) hei;
            final double deltaPosYa = (double) (poslY - posllY) / (double) hei;

            for (int k = 0; k < color.length; k++) {
                if (ceil == 1)
                    color[k] = TextureContainer.floor.getPixel((int) posXa, (int) posYa, 7);
                else
                    color[k] = TextureContainer.floor.getPixel((int) posXa, (int) posYa, 1);


                posXa += deltaPosXa;
                posYa += deltaPosYa;
            }

            FloorPixel.setCPixelGoodQuality(posScreenX - (RenderProcedure.SCREEN_STEP << 1),
                    posstart, color, hei + (ceil - 1), false);
        }else{
            int color = 0;

            if (ceil == 1)
                color = TextureContainer.floor.getPixel((int) poslX, (int) poslY, 7);
            else
                color = TextureContainer.floor.getPixel((int) poslX, (int) poslY, 1);


            FloorPixel.setCPixel(posScreenX - (RenderProcedure.SCREEN_STEP << 1),
                    posstart, color, hei + (ceil - 1), false);
        }
    }

    private static void renderFloorDown(double r,int ceil, int hei, int poslX,int poslY,int posScreenX,int posfinish){
        int intensity = 2;
        if (ceil == 1) intensity = 7;

        if(r<MAX_GOOD_QUALITY_DISTANCE_DOWN && RenderProcedure.SCREEN_STEP == 4) {


            int[] scolor = new int[hei];

            double posXa = posllX;
            double posYa = posllY;

            final double deltaPosXa = (double) (poslX - posllX) / (double) hei;
            final double deltaPosYa = (double) (poslY - posllY) / (double) hei;

            for (int k = 0; k < scolor.length; k++) {

                scolor[k] = TextureContainer.floor.getPixel((int) posXa, (int) posYa, intensity);

                posXa += deltaPosXa;
                posYa += deltaPosYa;
            }
            FloorPixel.setCPixelGoodQuality(posScreenX - (RenderProcedure.SCREEN_STEP << 1), posfinish, scolor, hei, true);
        }else{
            int scolor = TextureContainer.floor.getPixel((int) poslX, (int) poslY, intensity);
            FloorPixel.setCPixel(posScreenX - (RenderProcedure.SCREEN_STEP << 1), posfinish, scolor, hei, true);
        }
    }
    public static void renderFloor(int posX, int posY, boolean renderFloor, int posScreenX, double deltaPosY
            , double deltaPosX, double r, boolean half, boolean oneheight, boolean halfupx, int maxhh, int minhh){

        posScreenX += (RenderProcedure.SCREEN_STEP>>1);

        if (posScreenX != 0 && renderFloor) {

            int hei = getHei(r);
            if(hei != 0) {
                final double heightx = PreColumn.height;

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
                                        renderCeiling(r,ceil,hei,poslX,poslY,posScreenX,posstart);
                                    }

                                }

                                if (ceil == 1) {
                                    if (!halfupx) PreColumn.maxh = posstart;

                                }

                            }


                            if (!half) {

                                renderFloorDown(r,ceil,hei,poslX,poslY,posScreenX,posfinish);


                            }

                            posllX = poslX;
                            posllY = poslY;
                        }

                    }

                }
            }
        }
    }
}