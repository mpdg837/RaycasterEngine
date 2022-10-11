package com.example.raycaster.Model.Raycasting.Raycasting.Analyse.Entities;

import com.example.raycaster.Model.Raycasting.RenderProcedure;

public final class Sight {


    public static int spritePosX = 32;
    public static int spritePosY = 24;

    public static double deltaPosXc;
    public static double deltaPosYc;

    public static boolean renderwall = false;
    public static boolean lastWall = false;

    public static int posScreenX;

    public static double lheight;
    public static double lheighte;
    public static double luheight ;

    public static int lcolumn;

    public static double tan;
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


    public static double halflheight = 0;
    public static int halflposX = 0;
    public static int halflposY = 0;


    private static double countTan(){
        double tan = (double) Math.tan(RenderProcedure.angle);

        if(tan>10){
            tan = 10;
        }else if(tan < -10){
            tan = -10;
        }

        return tan;
    }

    private static void countRelativePos(){

        deltaPosXc = ((RenderProcedure.pos.x-((double) (int)RenderProcedure.pos.x))*(double) RenderProcedure.textureResolution);
        deltaPosYc = ((RenderProcedure.pos.y-((double) (int)RenderProcedure.pos.y))*(double) RenderProcedure.textureResolution);

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


        halflheight = 0;
        halflposY = 0;
        halflposX = 0;
    }
    public static void renderSight(){

       initSight();
       countRelativePos();

        for(double fi = RenderProcedure.angle - RenderProcedure.pi/6 ;fi<RenderProcedure.angle + RenderProcedure.pi/6; fi+=RenderProcedure.deltaFi) {
            Ray.analyseRay(fi);

        }
    }
}
