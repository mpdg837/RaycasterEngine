package com.example.rayx.Model.Raycasting.Raycasting.Analyse.Uppers;

import com.example.rayx.Model.Raycasting.Raycasting.Analyse.RenderSteps.InPoint;
import com.example.rayx.Model.Raycasting.Raycasting.Analyse.RenderSteps.Ray;
import com.example.rayx.Model.Raycasting.Raycasting.PreBaking.Floor.FloorAndCeiling;
import com.example.rayx.Model.Raycasting.Raycasting.PreBaking.Ray.Buffers.BufferUpperColumn;
import com.example.rayx.Model.Raycasting.Raycasting.PreBaking.Ray.Buffers.PreColumn;
import com.example.rayx.Model.Raycasting.RenderProcedure;
import com.example.rayx.View.Raycasting.UpperBlocks.Full.UpperBlock;
import com.example.rayx.View.Raycasting.UpperBlocks.Other.UpperBuildingBlocks;
import com.example.rayx.View.Raycasting.UpperBlocks.Other.UpperHalfBlock;

public final class UpperBlocks {

    private UpperBlocks(){

    }

    public static boolean isRenderingUpperBlock(){
        return (Ray.ceili == 1 && Ray.lceili != 1) || (Ray.lhalfupx == 1 && Ray.halfupx == 0 && Ray.ceili == 1);
    }

    public static void bufferHalfBlock(){

        int height = (int)PreColumn.height;

        PreColumn.maxhh = RenderProcedure.cameraY - height;

        if(PreColumn.minhh > RenderProcedure.cameraY - ((int)height<<1)- (FloorAndCeiling.hei))
            PreColumn.minhh = RenderProcedure.cameraY - ((int)height<<1)- (FloorAndCeiling.hei);
    }
    public static void renderUpperBlocks(){
        if(isRenderingUpperBlock() || (Ray.upperbuildingx&& !Ray.lupperbuildingx)){

            final float height = PreColumn.fakeHeight / PreColumn.z;
            final float lha = PreColumn.getLastUpperHeight(height);
            final float lhaa = BufferUpperColumn.getLastUpperBuildingHeight(height);



            int shadow = 0;

            if(InPoint.inPlayerArea()) {


                UpperBuildingBlocks.analyse(height,0,lha,lhaa);

                if (isRenderingUpperBlock()) {

                    if (Ray.halfupx == 0) {
                        UpperBlock.analyse(height, shadow, lha, lhaa);
                    } else {
                        UpperHalfBlock.analyse(height, shadow, lha, lhaa);
                    }

                    if (!Ray.halfupper) {
                        Ray.halfupper = true;
                    }

                }
            }



        }
    }
}
