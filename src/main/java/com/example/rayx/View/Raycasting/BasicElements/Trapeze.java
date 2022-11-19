package com.example.rayx.View.Raycasting.BasicElements;

import com.example.rayx.Model.Raycasting.Quality;
import com.example.rayx.Model.Raycasting.Raycasting.PreBaking.Floor.FloorAndCeiling;
import com.example.rayx.Model.Raycasting.RenderProcedure;
import com.example.rayx.View.Render;

public class Trapeze {


    public static float ys;
    public static float yf;

    public static int lheight;
    public static float height;

    public static int posStart;
    public static int posFinal;


    public static int diff ;
    public static int len;
    public static int cdiff;

    public static float delta;
    public static float deltacolor;

    public static float dh = 0;
    public static float dc;
    public static byte trnsx = 0;

    protected Trapeze(){}

    protected static void selectTypeOfColumn(boolean halfup,boolean upper,boolean upperb,boolean half,boolean dhalf,int floorH){
        ys = RenderProcedure.cameraY-lheight;
        yf = RenderProcedure.cameraY+lheight;

        if(half) yf = RenderProcedure.cameraY;
        if(upper){
            ys = RenderProcedure.cameraY-lheight - (lheight << 1);
            yf = RenderProcedure.cameraY-lheight;
        }

        if(halfup){
            ys = RenderProcedure.cameraY-(lheight<<1);
            yf = RenderProcedure.cameraY-lheight;
        }

        if(dhalf){
            ys = RenderProcedure.cameraY;
            yf = RenderProcedure.cameraY+lheight;
        }

        if(upperb){
            ys = RenderProcedure.cameraY-lheight - (lheight<<2);
            yf = RenderProcedure.cameraY-lheight - (lheight<<1);
        }


        if(floorH == 1){
            ys = RenderProcedure.cameraY+lheight-(lheight >> 2) - (lheight >>3)+ FloorAndCeiling.hei;
            yf = RenderProcedure.cameraY+lheight;
        }else if(floorH == -1){
            ys = RenderProcedure.cameraY+lheight;
            yf = RenderProcedure.cameraY+lheight+(lheight >> 2) + (lheight >>3);
        }
    }


    protected static void prepare(int column,int lcolumn){
        diff = (int)(height-lheight);

        len = Quality.D_SCREEN_STEP;

        cdiff = column - lcolumn;
        if (cdiff < 0) cdiff = -cdiff;

        if (cdiff > 32) {
            column = lcolumn + 4;
            len = Quality.D_SCREEN_STEP+ 1;
        }

        delta = (float) (diff)/(float) len;
        deltacolor = (float) ( column-lcolumn)/(float) Quality.D_SCREEN_STEP;

        dh = 0;
        dc = lcolumn;
        trnsx = 0;
    }

    protected static void makeSmoothBorders(boolean upperb,boolean upper,boolean half,int x,boolean renderHalf,boolean upperhalf,int floorH){

        if(floorH == -1 || floorH == 1){
            posStart = (int)(((int)(ys) * (float)RenderProcedure.SCREEN_WIDTH + (float)x)) << Render.shiftPixelWidth;
            posFinal = (int)(((int)(yf) * (float)RenderProcedure.SCREEN_WIDTH + (float)x)) << Render.shiftPixelWidth;
        }else
        if(upperhalf){
            posStart = (int)(((int)(ys-dh) * (float)RenderProcedure.SCREEN_WIDTH + (float)x)) << Render.shiftPixelWidth;
            posFinal = (int)(((int)(yf-dh) * (float)RenderProcedure.SCREEN_WIDTH + (float)x)) << Render.shiftPixelWidth;
        }else
        if(upperb){
            posStart = (int)(((int)(ys-3*dh) * (float)RenderProcedure.SCREEN_WIDTH + (float)x)) << Render.shiftPixelWidth;
            posFinal = (int)(((int)(yf-2*dh) * (float)RenderProcedure.SCREEN_WIDTH + (float)x)) << Render.shiftPixelWidth;
        }else
        if(upper){


            posStart = (int)(((int)(ys-2*dh) * (float)RenderProcedure.SCREEN_WIDTH + (float)x)) << Render.shiftPixelWidth;
            posFinal = (int)(((int)(yf-dh) * (float)RenderProcedure.SCREEN_WIDTH + (float)x)) << Render.shiftPixelWidth;

        }else{

            if(renderHalf) posStart = (int)(((int)(ys) * (float)RenderProcedure.SCREEN_WIDTH + (float)x)) << Render.shiftPixelWidth;
            else posStart = (int)(((int)(ys-dh) * (float)RenderProcedure.SCREEN_WIDTH + (float)x)) << Render.shiftPixelWidth;

            if(half) posFinal = (int)(((int)(yf) * (float)RenderProcedure.SCREEN_WIDTH + (float)x)) << Render.shiftPixelWidth;
            else {
                posFinal = (int)(((int)(yf+dh) * (float)RenderProcedure.SCREEN_WIDTH + (float)x)) << Render.shiftPixelWidth;
            }
        }
    }
}
