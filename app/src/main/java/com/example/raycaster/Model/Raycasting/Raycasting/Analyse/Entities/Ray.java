package com.example.raycaster.Model.Raycasting.Raycasting.Analyse.Entities;

import com.example.raycaster.Model.Raycasting.Raycasting.PreBaking.Ray.AngleRay;
import com.example.raycaster.Model.Raycasting.Raycasting.PreBaking.Ray.PointOnRay;
import com.example.raycaster.Model.Raycasting.Raycasting.PreBaking.Ray.PreColumns.PreColumn;
import com.example.raycaster.Model.Raycasting.RenderProcedure;
import com.example.raycaster.Model.Resources.Map.Map;
import com.example.raycaster.View.Raycasting.BasicElements.SpriteBufferRender;

public final class Ray {



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

    public static int countPosBuffer(int x, int y){
        int count = (y << 3) + (x);
        if(count>=6400) count = 0;
        return count;
    }



    private static void initRay(){

            halfupx = 0;
            lhalfupx = 0;

            renderFloor = true;

            finish = false;
            lstatusofAngle = false;
            sprite = false;

            upper = false;
            half = false;


            oneheight = false;

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
    public static void analyseRay(float fi){

        new AngleRay(fi);
        new PointOnRay();

        PreColumn.start();
        initRay();
        analyseAreaNearPlayer();

        float actRaycastStep = RenderProcedure.raycasterStep;


        for (float r = 0; r < 12; r += actRaycastStep) {

            if(Map.ceiling[(int)  PointOnRay.posX][(int)  PointOnRay.posY] == 0) outside = true;

            InPoint.analysePoint(r);


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

        Sight.posScreenX += RenderProcedure.SCREEN_STEP;
        Sight.renderwall = !Sight.renderwall;
    }
}
