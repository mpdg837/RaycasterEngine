package com.example.rayx.Model.Raycasting.Raycasting.Analyse.RenderSteps;

import com.example.rayx.Model.Raycasting.Quality;
import com.example.rayx.Model.Raycasting.Raycasting.PreBaking.Ray.AngleRay;
import com.example.rayx.Model.Raycasting.Raycasting.PreBaking.Ray.Buffers.PreColumn;
import com.example.rayx.Model.Raycasting.Raycasting.PreBaking.Ray.PointOnRay;
import com.example.rayx.Model.Raycasting.RenderProcedure;
import com.example.rayx.Model.Resources.Map.Map;
import com.example.rayx.View.Raycasting.Sprites.SpriteBufferRender;
import com.example.rayx.View.Raycasting.UpperBlocks.Other.UpperBuildingBlocks;

public final class Ray extends RenderStep{
    public static boolean renderFloor;

    public static boolean finish;
    public static boolean lstatusofAngle;
    public static boolean sprite;

    public static boolean upper;
    public static boolean half;

    public static boolean oneheight;

    public static int ceili = 0;
    public static int lceiling;

    public static boolean finalrender;

    public static byte halfupx;
    public static boolean halfupper;
    public static boolean spriterendered;
    public static int lceili;
    public static int spriteStableCounter;
    public static boolean upperbuildingx;
    public static boolean lupperbuildingx;
    public static byte lhalfupx;
    public static boolean upperbuildingXa;
    public static boolean upperXa;
    public static byte uppershapeX;
    public static boolean luppershape;
    public static boolean luppershapeR;
    public static boolean outside;
    public static int floorDown;
    public static int lfloorDown;
    public static int maxY;

    private Ray(){

    }

    public static int countPosBuffer(int x, int y){
        int count = (y << 3) + (x);
        if(count>=6400) count = 0;
        return count;
    }



    private static void initRay(){

            UpperBuildingBlocks.maxh = 0;

            maxY = RenderProcedure.cameraY<<1;
            halfupx = 0;
            lhalfupx = 0;

            renderFloor = true;

            finish = false;
            lstatusofAngle = false;
            sprite = false;

            upper = false;
            half = false;
            oneheight = false;

            floorDown = Map.floorH[(int) PointOnRay.posX][(int) PointOnRay.posY];
            lfloorDown = 0;

            ceili = Map.ceiling[(int) PointOnRay.posX][(int) PointOnRay.posY];


            lceiling = Map.ceiling[(int) PointOnRay.posX][(int) PointOnRay.posY];

            finalrender = false;


            halfupper = false;

            spriterendered = false;

            lceili = Map.ceiling[(int)  PointOnRay.posX][(int)  PointOnRay.posY];

            spriteStableCounter = 0;

            upperbuildingXa = false;
            upperXa = false;
            luppershapeR = false;

    }

    private static void analyseAreaNearPlayer(){

        upperbuildingx = Map.upperbuilding[(int) PointOnRay.posX][(int)  PointOnRay.posY];
        lupperbuildingx = Map.upperbuilding[(int)  PointOnRay.posX][(int)  PointOnRay.posY];

        outside = Map.ceiling[(int)  PointOnRay.posX][(int)  PointOnRay.posY] == 0;
    }
    public static void analyse(float fi){

        AngleRay.setNewAngle(fi);
        PointOnRay.resetRay();

        PreColumn.start();
        initRay();
        analyseAreaNearPlayer();

        float actRaycastStep = Quality.raycasterStep;


        for (float r = 0; r < 12; r += actRaycastStep) {

            if(Map.ceiling[(int)  PointOnRay.posX][(int)  PointOnRay.posY] == 0) outside = true;

            InPoint.analyse(r);


                if(Map.map[(int)  PointOnRay.posX][(int)  PointOnRay.posY] == 5 ){
                    PreColumn.minY = RenderProcedure.cameraY - (int)( PreColumn.height);
                }

            PointOnRay.nextStep();
            PointOnRay.reductionAmountOfRaycastStep();
        }

        if(!half){
            Sight.halflheight = 0;
        }
        if(Sight.renderwall) {
            Sight.lupperbuildingXa = upperbuildingXa;
            Sight.lupperXa = upperXa;
        }

        if(!finish && !oneheight){
            Sight.lheight = 0;
            Sight.lcolumn = 0;
        }


        if(spriterendered) {

            SpriteBufferRender.renderBufferedColumn();

        }

        Sight.posScreenX += Quality.SCREEN_STEP;
        Sight.renderwall = !Sight.renderwall;
    }
}
