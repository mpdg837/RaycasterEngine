package com.example.rayx.Model.Raycasting.Raycasting.PreBaking.Floor;

import com.example.rayx.Model.Raycasting.Raycasting.Analyse.RenderSteps.Ray;
import com.example.rayx.Model.Raycasting.RenderProcedure;
import com.example.rayx.View.Raycasting.BasicElements.FloorRender;
import com.example.rayx.View.Raycasting.Blocks.Stairs;

public final class Floor extends FlatSurface{

    private Floor(){

    }

    public static void analyse(float r, boolean half,int ceil,int poslX,int poslY,int posScreenX,float heightx){
        int posfinish = (int) (RenderProcedure.cameraY + heightx);

        if(Ray.floorDown == -1) posfinish = (int) (RenderProcedure.cameraY + heightx + ((int)heightx>>2) + ((int)heightx>>3));
        if(Ray.floorDown == 1) posfinish = (int) (RenderProcedure.cameraY + heightx - ((int)heightx>>2) - ((int)heightx>>3));

        if (!half && !Ray.oneheight) {

            if(posfinish< Ray.maxY) {
                FloorRender.renderFloorDown(r, ceil, FloorAndCeiling.hei, poslX, poslY, posScreenX, posfinish);
                Stairs.analyseStairs();
                Ray.maxY = posfinish;
            }

        }
    }

}
