package com.example.raycaster.Model.Raycasting.Raycasting.Analyse.Entities;

import com.example.raycaster.View.Raycasting.Blocks.Blocks;
import com.example.raycaster.Model.Raycasting.Raycasting.Analyse.Uppers.UpperBlocks;
import com.example.raycaster.View.Raycasting.UpperBlocks.UpperShapes;
import com.example.raycaster.Model.Raycasting.Raycasting.Analyse.WallHit;
import com.example.raycaster.Model.Raycasting.Raycasting.PreBaking.Ray.PointOnRay;
import com.example.raycaster.Model.Raycasting.Raycasting.PreBaking.Ray.PreColumns.PreColumn;
import com.example.raycaster.Model.Raycasting.RenderProcedure;
import com.example.raycaster.Model.Raycasting.Raycasting.PreBaking.Sprites.Sprites;
import com.example.raycaster.Model.Raycasting.Raycasting.PreBaking.Floor;
import com.example.raycaster.Model.Resources.Map.Map;

public final class InPoint {

    public static int countPos;

    public static void collectInfoAboutActualBlock(){
        Ray.luppershape = false;

        Sight.obj = Map.map[(int) PointOnRay.posX][(int) PointOnRay.posY];

        Ray.sprite = false;

        Ray.lceili = Ray.ceili;
        Ray.ceili = Map.ceiling[(int) PointOnRay.posX][(int) PointOnRay.posY];

        Ray.lhalfupx = Ray.halfupx;
        Ray.halfupx = Map.halfup[(int)PointOnRay.posX][(int)PointOnRay.posY];

        if(Ray.lhalfupx == 1){
            final double height =  PreColumn.height;
            PreColumn.maxhh = RenderProcedure.cameraY - (int)height;
        }

        Ray.lupperbuildingx = Ray.upperbuildingx;
        Ray.upperbuildingx = Map.upperbuilding[(int) PointOnRay.posX][(int) PointOnRay.posY];



        if((int)PointOnRay.posX != (int)RenderProcedure.pos.x || (int)PointOnRay.posY != (int)RenderProcedure.pos.y)
            UpperBlocks.renderUpperBlocks();

        if(Ray.halfupx == 0) Ray.lceiling = Ray.ceili;

        Ray.uppershapeX = Map.uppershape[(int) PointOnRay.posX][(int) PointOnRay.posY];
    }

    private static int countLocalPos(){
       return (((int) PointOnRay.posX - (int) RenderProcedure.pos.x+16) << 5) +((int)PointOnRay.posY-(int)RenderProcedure.pos.y+16);
    }
    public static void analysePoint(double r){
        countPos = countLocalPos();

        if((int)PointOnRay.posX != (int)RenderProcedure.pos.x || (int)PointOnRay.posY != (int)RenderProcedure.pos.y)
        if(Sight.lcountPos != countPos) {
            WallHit.analysePotentionalHit();

            collectInfoAboutActualBlock();

        }

        if(Ray.uppershapeX != 0) {
            UpperShapes.renderUpperShapes();
        }

        Sight.lcountPos = countPos;

        if(!Ray.finish || !Ray.finalrender){
            PreColumn.countHeight();
        }
        if(Ray.finish) {

            if(!Ray.finalrender) {
                if (Ray.ceili == 2)

                    renderFloor(r,false,true);

                if (Ray.ceili == 1) Ray.finalrender = true;
            }
        }else{
            switch (Sight.obj) {

                case 1:
                case 2:
                case 11:

                    Blocks.renderBlocks(r);
                    break;

                case 3:
                case 4:
                case 8:
                case 9:
                case 10:
                case 12:

                    Sprites.renderSprites(r);
                    break;

                default:
                    Ray.sprite = false;

                    renderFloor(r,Ray.oneheight,Ray.halfupx == 1 || Ray.halfupx == 2);
                    break;
            }
        }
    }

    private static void renderFloor(double r,boolean oneheight,boolean halfupx){
        Floor.renderFloor((int) PointOnRay.posX, (int) PointOnRay.posY, Ray.renderFloor, Sight.posScreenX, PointOnRay.deltaPosY, PointOnRay.deltaPosX, r,
                Ray.half, oneheight,halfupx, PreColumn.maxhh, PreColumn.minhh);
    }
}
