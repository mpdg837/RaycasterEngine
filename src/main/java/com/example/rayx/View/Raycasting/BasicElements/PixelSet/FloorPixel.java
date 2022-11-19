package com.example.rayx.View.Raycasting.BasicElements.PixelSet;

import com.example.rayx.Model.Raycasting.Quality;
import com.example.rayx.Model.Raycasting.RenderProcedure;
import com.example.rayx.View.Render;

public final class FloorPixel {


    public static void setCPixel(int x, int y, int column,int hei,boolean check){
        int pos = (y*RenderProcedure.SCREEN_WIDTH+x) << 2;

        if(pos < Render.maxLen && pos >= 0){
                for (int k = 0; k < RenderProcedure.realWidth * hei; k += RenderProcedure.realWidth) {

                    for (int d = 0; d < Quality.SCREEN_STEP << Render.shiftPixelWidth; d += Render.pixelWidth) {
                        final int bt = pos + d + k;
                        if (bt < Render.maxLen && bt >= 0) {

                            RenderProcedure.setPixel(bt, column);

                        }
                    }
                }
            }

    }

}
