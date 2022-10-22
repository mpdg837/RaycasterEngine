package com.example.raycaster.View.Raycasting.BasicElements;

import com.example.raycaster.Model.Raycasting.Raycasting.Analyse.Entities.Ray;
import com.example.raycaster.Model.Raycasting.RenderProcedure;
import com.example.raycaster.Model.Resources.Map.Map;
import com.example.raycaster.View.Render;

public final class FloorPixel {


    public static void setCPixelGoodQuality(int x, int y, int[] column,int hei,boolean check){
        int pos = (y* RenderProcedure.SCREEN_WIDTH+x) << 2;

        if(pos < Render.maxLen && pos >= 0){
                int kk = 0;
                for (int k = 0; k < RenderProcedure.realWidth * hei; k += RenderProcedure.realWidth) {

                    for (int d = 0; d < RenderProcedure.SCREEN_STEP << Render.shiftPixelWidth; d += Render.pixelWidth) {
                        final int bt = pos + d + k;
                        if (bt < Render.maxLen && bt >= 0) {

                            RenderProcedure.setPixel(bt, column[kk]);

                        }
                    }
                    kk++;
                }
            }

    }

    public static void setCPixel(int x, int y, int column,int hei,boolean check){
        int pos = (y*RenderProcedure.SCREEN_WIDTH+x) << 2;

        if(pos < Render.maxLen && pos >= 0){
                for (int k = 0; k < RenderProcedure.realWidth * hei; k += RenderProcedure.realWidth) {

                    for (int d = 0; d < RenderProcedure.SCREEN_STEP << Render.shiftPixelWidth; d += Render.pixelWidth) {
                        final int bt = pos + d + k;
                        if (bt < Render.maxLen && bt >= 0) {

                            RenderProcedure.setPixel(bt, column);

                        }
                    }
                }
            }

    }

}
