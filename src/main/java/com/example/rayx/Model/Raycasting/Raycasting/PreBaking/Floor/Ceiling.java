package com.example.rayx.Model.Raycasting.Raycasting.PreBaking.Floor;

import com.example.rayx.Model.Raycasting.Raycasting.Analyse.RenderSteps.Ray;
import com.example.rayx.Model.Raycasting.Raycasting.Analyse.Uppers.UpperBlocks;
import com.example.rayx.Model.Raycasting.Raycasting.PreBaking.Ray.Buffers.PreColumn;
import com.example.rayx.Model.Raycasting.RenderProcedure;
import com.example.rayx.View.Raycasting.BasicElements.FloorRender;

public final class Ceiling extends FlatSurface{

    private Ceiling(){

    }

    public static void analyse(float r,int ceil, int minhh,float heightx, int maxhh, int poslX,int poslY, int posScreenX,boolean halfupx){

        int posstart = (int) (RenderProcedure.cameraY - heightx - heightx * ((ceil - 1) << 1));

        if (ceil != 0 && !(ceil == 2 && Ray.luppershapeR)) {

            if (posstart > PreColumn.maxh) {
                boolean inhalfup = (posstart > minhh && posstart < maxhh);

                if (posstart < PreColumn.minh && !inhalfup) {
                    FloorRender.renderCeiling(r,ceil,FloorAndCeiling.hei,poslX,poslY,posScreenX,posstart);
                }

            }

            if (ceil == 1) {

                if(!halfupx) PreColumn.maxh = posstart;
                else{
                    UpperBlocks.bufferHalfBlock();
                }

            }

        }
    }

}
