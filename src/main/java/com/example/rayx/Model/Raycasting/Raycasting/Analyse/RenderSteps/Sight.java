package com.example.rayx.Model.Raycasting.Raycasting.Analyse.RenderSteps;

import com.example.rayx.Model.Raycasting.Quality;
import com.example.rayx.Model.Raycasting.RenderProcedure;
import com.example.rayx.Model.Resources.Map.Map;

public final class Sight extends RenderStep{

    public static int spritePosX = 32;
    public static int spritePosY = 24;

    public static float deltaPosXc;
    public static float deltaPosYc;

    public static boolean renderwall = false;
    public static boolean lastWall = false;

    public static int posScreenX;

    public static float lheight;
    public static float lheighte;
    public static float luheight ;

    public static int lcolumn;

    public static float tan;
    public static int obj;
    public static int lcountPos;

    public static boolean wallinitized = false;

    public static int lshadowu = 0;
    public static int lshadow = 0;

    public static int lcolumnhx = 0;
    public static int llposX =0;
    public static int llposY = 0;

    public static int llcposX =0;
    public static int llcposY = 0;

    public static boolean lupperbuildingXa = false;
    public static boolean lupperXa = false;

    public static int lcolumnhalf = 0;
    public static int lshadowh = 0;

    public static int halflposX;
    public static int halflposY;

    public static float halflheight = 0;

    private Sight(){

    }

    private static float countTan(){
        float tan = (float) Math.tan(RenderProcedure.angle);

        if(tan>10){
            tan = 10;
        }else if(tan < -10){
            tan = -10;
        }

        return tan;
    }

    private static void countRelativePos(){

        deltaPosXc = ((RenderProcedure.pos.x-((float) (int)RenderProcedure.pos.x))*(float) Quality.textureResolution);
        deltaPosYc = ((RenderProcedure.pos.y-((float) (int)RenderProcedure.pos.y))*(float) Quality.textureResolution);

    }

    private static void initSight(){
        posScreenX = 0;

        lheight = 0;
        luheight =0;

        lcolumn =0;

        lheighte = 0;

        renderwall = false;
        lastWall = false;

        llcposY = 0;
        llcposX = 0;

        tan = countTan();

        obj = 0;
        lcountPos = 0;

        wallinitized = false;

        lshadowu = 0;
        lshadow = 0;

        lcolumnhx = 0;
        llposX =0;
        llposY = 0;

        lupperbuildingXa = false;
        lupperXa = false;

        lcolumnhalf = 0;
        lshadowh = 0;

        halflposX = 0;
        halflposY = 0;

        halflheight = 0;
    }

    public static void analyse(){

       initSight();
       countRelativePos();

        RenderProcedure.canvasHeight = 300;

        if(Map.floorH[(int)RenderProcedure.pos.x][(int)RenderProcedure.pos.y] ==-1){
            RenderProcedure.cameraY = 280;
        }else if(Map.floorH[(int)RenderProcedure.pos.x][(int)RenderProcedure.pos.y] ==1){

            RenderProcedure.canvasHeight = 330;
            RenderProcedure.cameraY = 330;
        }else{
            RenderProcedure.cameraY = 300;
        }

        for(float fi = RenderProcedure.angle - RenderProcedure.pi/4.8f ;fi<RenderProcedure.angle+RenderProcedure.pi/4.8f; fi+=Quality.deltaFi) {
            Ray.analyse(fi);

        }
    }
}
