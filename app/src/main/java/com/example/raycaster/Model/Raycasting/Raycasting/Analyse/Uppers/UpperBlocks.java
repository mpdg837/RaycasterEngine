package com.example.raycaster.Model.Raycasting.Raycasting.Analyse.Uppers;

import com.example.raycaster.Model.Raycasting.Raycasting.Analyse.Entities.Ray;
import com.example.raycaster.Model.Raycasting.Raycasting.PreBaking.Ray.PreColumns.UpperPreColumn;
import com.example.raycaster.View.Raycasting.UpperBlocks.UpperBlock;
import com.example.raycaster.View.Raycasting.UpperBlocks.UpperBuildingBlocks;
import com.example.raycaster.View.Raycasting.UpperBlocks.UpperHalfBlock;
import com.example.raycaster.Model.Raycasting.Raycasting.PreBaking.Ray.PointOnRay;
import com.example.raycaster.Model.Raycasting.Raycasting.PreBaking.Ray.PreColumns.PreColumn;
import com.example.raycaster.Model.Raycasting.RenderProcedure;

public final class UpperBlocks {

    public static void renderUpperBlocks(){
        if((Ray.ceili == 1 && Ray.lceili != 1) || (Ray.upperbuildingx&& !Ray.lupperbuildingx)){

            final double height = PreColumn.fakeHeight / PreColumn.z;
            final double lha = PreColumn.getLastUpperHeight(height);
            final double lhaa = UpperPreColumn.getLastUpperBuildingHeight(height);

            int shadow = 0;

            UpperBuildingBlocks.analyse(height,shadow,lha,lhaa);

            shadow = 0;

            if((int)PointOnRay.posX != (int) RenderProcedure.pos.x || (int)PointOnRay.posY != (int)RenderProcedure.pos.y)
                if(Ray.ceili == 1 && Ray.lceiling!=1){

                    if (Ray.halfupx==0) {
                        UpperBlock.analyse(height,shadow,lha,lhaa);
                    }else{
                        UpperHalfBlock.analyse(height,shadow,lha,lhaa);
                    }

                    if(!Ray.halfupper){
                        PreColumn.minhh = RenderProcedure.cameraY - (int)(2*height);

                        Ray.halfupper = true;
                    }

                }




        }
    }
}
