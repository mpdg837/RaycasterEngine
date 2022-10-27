package com.example.raycaster.View.Raycasting.BasicElements;

import com.example.raycaster.Model.Raycasting.Raycasting.Analyse.Entities.Ray;
import com.example.raycaster.Model.Raycasting.Raycasting.PreBaking.Ray.PreColumns.PreColumn;
import com.example.raycaster.Model.Raycasting.RenderProcedure;
import com.example.raycaster.Model.Resources.Textures.Texture;
import com.example.raycaster.View.Render;

public final class ColumnPixel {


    public static void setPixelColumn(int pos, int column, int y, int shadow, Texture tex ){
        if(pos>0 && pos < Render.maxLen) {

            int pcol;

            pcol = tex.getPixel(column << 1, y, shadow);

            if(!Ray.upperbuildingx && !Ray.halfupper){
                RenderProcedure.setPixel(pos, pcol);
            }else
            if (((RenderProcedure.isEmpty(pos)))) {
                RenderProcedure.setPixel(pos, pcol);
            }


        }
    }


    public static void drawSmallColumn(int llminh,int llmaxh,boolean upperb,int shadow,Texture tex){
        final float deltaPos = ((float)Column.lheight + (Column.dh) )/(float) RenderProcedure.textureResolution;

        float texPos = 0;
        float deltaP = 0;

        final int minimal =  llminh*(int)RenderProcedure.realWidth;
        final int maximal = llmaxh*(int)RenderProcedure.realWidth;
        final int minimalY =  PreColumn.maxh*(int)RenderProcedure.realWidth;

        for(int y=Column.posStart;y<Column.posFinal;y+=RenderProcedure.realWidth) {
            if ((y >= minimal && y < maximal && y>minimalY) || upperb) {

                final int acolumn = ((int) Column.dc & RenderProcedure.deltaPosMask);
                setPixelColumn(y + Column.trnsx, acolumn, (int) texPos & 0x7f, shadow,tex);

            }

            deltaP ++;
            if(deltaP >= deltaPos) {
                texPos+= deltaP / deltaPos;
                deltaP =0;
            }


        }

        Column.dc += Column.deltacolor;
        Column.dh+=Column.delta;
        Column.trnsx += Render.pixelWidth;
    }

}
