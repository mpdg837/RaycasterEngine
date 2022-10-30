package com.example.raycaster.Model.Raycasting.Raycasting.Analyse.Uppers;

import com.example.raycaster.Model.Raycasting.Raycasting.Analyse.Entities.Ray;
import com.example.raycaster.Model.Raycasting.Raycasting.PreBaking.Ray.Buffers.BufferUpperColumn;
import com.example.raycaster.View.Raycasting.UpperBlocks.Full.UpperBlock;
import com.example.raycaster.View.Raycasting.UpperBlocks.Other.UpperBuildingBlocks;
import com.example.raycaster.View.Raycasting.UpperBlocks.Other.UpperHalfBlock;
import com.example.raycaster.Model.Raycasting.Raycasting.PreBaking.Ray.PointOnRay;
import com.example.raycaster.Model.Raycasting.Raycasting.PreBaking.Ray.Buffers.PreColumn;
import com.example.raycaster.Model.Raycasting.RenderProcedure;

public final class UpperBlocks {

    private UpperBlocks(){

    }

    public static void renderUpperBlocks(){
        if((Ray.ceili == 1 && Ray.lceili != 1) || (Ray.upperbuildingx&& !Ray.lupperbuildingx)){

            final float height = PreColumn.fakeHeight / PreColumn.z;
            final float lha = PreColumn.getLastUpperHeight(height);
            final float lhaa = BufferUpperColumn.getLastUpperBuildingHeight(height);



            int shadow = 0;

            if((int)PointOnRay.posX != (int) RenderProcedure.pos.x || (int)PointOnRay.posY != (int)RenderProcedure.pos.y) {


                UpperBuildingBlocks.analyse(height,0,lha,lhaa);

                if (Ray.ceili == 1 && Ray.lceiling != 1) {

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
