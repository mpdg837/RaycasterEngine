package com.example.raycaster.View.Raycasting.BasicElements;

import com.example.raycaster.Model.Resources.Map.Map;
import com.example.raycaster.Model.Raycasting.Raycasting.Analyse.Entities.Ray;
import com.example.raycaster.Model.Raycasting.Raycasting.PreBaking.Ray.PointOnRay;
import com.example.raycaster.Model.Raycasting.Raycasting.PreBaking.Ray.PreColumn;
import com.example.raycaster.View.Render;
import com.example.raycaster.Model.Raycasting.RenderProcedure;
import com.example.raycaster.Model.Raycasting.Raycasting.Textures.TextureContainer;

public final class Floor {

    public static void setCPixel(int x, int y, int column,int hei,boolean check){
        int pos = (y*RenderProcedure.SCREEN_WIDTH+x) << 2;

        if(pos < Render.maxLen && pos >= 0)
            if(!check || RenderProcedure.isEmpty(pos))
                for(int k=0;k<RenderProcedure.realWidth*hei;k+=RenderProcedure.realWidth) {

                    for (int d = 0; d < RenderProcedure.SCREEN_STEP << Render.shiftPixelWidth; d += Render.pixelWidth) {
                        final int bt = pos + d+k;
                        if (bt < Render.maxLen && bt >= 0) {

                            if(Map.ceiling[(int)RenderProcedure.pos.x][(int) RenderProcedure.pos.y] ==1 && Ray.ceili == 2 ){
                                if(RenderProcedure.isEmpty(bt)) RenderProcedure.setPixel(bt, column);
                            }else
                              RenderProcedure.setPixel(bt, column);

                        }
                    }
                }

    }

    private static int getHei(double r){
        int hei;

        if (r < 1.5) {
            hei = 7;
        } else if(r < 2.5) {
            hei = 3;
        } else if (r < 3.14) {
            hei = 2;
        } else{
            hei = 1;
        }

        return hei;
    }
    public static void renderFloor(int posX, int posY, boolean renderFloor, int posScreenX, double deltaPosY
            , double deltaPosX, double r, boolean half, boolean oneheight, boolean halfupx, int maxhh, int minhh){

        posScreenX += (RenderProcedure.SCREEN_STEP>>1);

        if (posScreenX != 0 && renderFloor) {


            final double heightx = PreColumn.height;

            if (RenderProcedure.cameraY+ heightx < (RenderProcedure.canvasHeight << 1) - 1) {
                final int ceil = Map.ceiling[posX][posY];

                if(ceil !=0 || !half) {

                    final int poslY = PointOnRay.intdeltaPosY << 1;
                    final int poslX = PointOnRay.intdeltaPosX << 1;
                    int hei = getHei(r);

                    int posstart = (int) (RenderProcedure.cameraY - heightx - heightx*((ceil-1)<<1));
                    int posfinish = (int) (RenderProcedure.cameraY + heightx);


                    if( !oneheight) {
                        if (ceil !=0 && !(ceil ==2 && Ray.luppershapeR)) {

                            if( posstart> PreColumn.maxh) {
                                boolean inhalfup = (posstart > minhh && posstart < maxhh);

                                if (posstart <  PreColumn.minh && !inhalfup) {
                                    int color;

                                    if (ceil == 1) color = TextureContainer.floor.getPixel(poslX, poslY, 7);
                                    else color = TextureContainer.floor.getPixel(poslX, poslY, 1);

                                    setCPixel(posScreenX - (RenderProcedure.SCREEN_STEP << 1),
                                            posstart, color, hei + (ceil - 1), false);
                                }

                            }

                                if(ceil == 1){
                                    if(!halfupx)  PreColumn.maxh = posstart;

                                }

                        }


                        if (!half) {
                            int intensity = 2;
                            if(ceil == 1) intensity =7;


                            int scolor = TextureContainer.floor.getPixel(poslX, poslY, intensity);

                            setCPixel(posScreenX - (RenderProcedure.SCREEN_STEP<<1), posfinish, scolor, hei,true);
                        }
                    }

                }

            }

        }
    }
}