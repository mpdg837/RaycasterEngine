package com.example.rayx.Model.Raycasting.Raycasting.Analyse.RenderSteps;

import com.example.rayx.Model.Raycasting.Raycasting.Analyse.Uppers.UpperBlocks;
import com.example.rayx.Model.Raycasting.Raycasting.Analyse.Hits.WallHit;
import com.example.rayx.Model.Raycasting.Raycasting.PreBaking.Floor.FloorAndCeiling;
import com.example.rayx.Model.Raycasting.Raycasting.PreBaking.Ray.Buffers.PreColumn;
import com.example.rayx.Model.Raycasting.Raycasting.PreBaking.Ray.PointOnRay;
import com.example.rayx.Model.Raycasting.Raycasting.PreBaking.Sprites.Sprites;
import com.example.rayx.Model.Raycasting.RenderProcedure;
import com.example.rayx.Model.Resources.Map.Map;
import com.example.rayx.View.Raycasting.Blocks.Blocks;
import com.example.rayx.View.Raycasting.UpperBlocks.Full.UpperShapes;

public final class InPoint extends RenderStep{

    public static int countPos;

    public static boolean inPlayerArea(){
        return (int)PointOnRay.posX != (int)RenderProcedure.pos.x || (int)PointOnRay.posY != (int)RenderProcedure.pos.y;
    }

    public static void collectInfoAboutActualBlock(){
        Ray.luppershape = false;

        Sight.obj = Map.map[(int) PointOnRay.posX][(int) PointOnRay.posY];

        Ray.sprite = false;

        Ray.lfloorDown = Ray.floorDown;
        Ray.floorDown = Map.floorH[(int) PointOnRay.posX][(int) PointOnRay.posY];

        Ray.lceili = Ray.ceili;
        Ray.ceili = Map.ceiling[(int) PointOnRay.posX][(int) PointOnRay.posY];


        Ray.lhalfupx = Ray.halfupx;
        Ray.halfupx = Map.halfup[(int)PointOnRay.posX][(int)PointOnRay.posY];


        Ray.lupperbuildingx = Ray.upperbuildingx;
        Ray.upperbuildingx = Map.upperbuilding[(int) PointOnRay.posX][(int) PointOnRay.posY];



        if(Ray.halfupx == 0) Ray.lceiling = Ray.ceili;

        Ray.uppershapeX = Map.uppershape[(int) PointOnRay.posX][(int) PointOnRay.posY];

    }


    private static void renderFloor(float r,boolean oneheight,boolean halfupx){
        FloorAndCeiling.renderFloor((int) PointOnRay.posX, (int) PointOnRay.posY, Ray.renderFloor, Sight.posScreenX, PointOnRay.deltaPosY, PointOnRay.deltaPosX, r,
                Ray.half, oneheight,halfupx, PreColumn.maxhh, PreColumn.minhh);
    }

    private static int countLocalPos(){
       return (((int) PointOnRay.posX - (int) RenderProcedure.pos.x+16) << 5) +((int)PointOnRay.posY-(int)RenderProcedure.pos.y+16);
    }

    private static void renderUpperAndPreCount(){
        countPos = countLocalPos();

        if(inPlayerArea())
            if(Sight.lcountPos != countPos) {
                WallHit.analyse();
                collectInfoAboutActualBlock();
                UpperBlocks.renderUpperBlocks();
            }else if(Ray.uppershapeX != 0) {
                UpperShapes.renderUpperShapes();
            }

        Sight.lcountPos = countPos;

        if(!Ray.finish || !Ray.finalrender){
            PreColumn.countHeight();
        }
    }

    private static void renderUpperFloor(float r){
        if(!Ray.finalrender) {
            if (Ray.ceili == 2) {

                renderFloor(r, false, false);
            }
            if (Ray.ceili == 1 && (Ray.halfupx==0)) {
                Ray.finalrender = true;
            }else if(Ray.halfupx == 1){
                UpperBlocks.bufferHalfBlock();
            }
        }
    }

    private static void selectRenderedObject(float r){
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
    public static void analyse(float r){

        renderUpperAndPreCount();

        if(Ray.finish) {
            renderUpperFloor(r);
        }else{
            selectRenderedObject(r);
        }
    }

}
