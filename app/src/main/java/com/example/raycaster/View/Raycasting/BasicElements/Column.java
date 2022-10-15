package com.example.raycaster.View.Raycasting.BasicElements;

import android.graphics.Point;

import com.example.raycaster.Model.Raycasting.Raycasting.Analyse.Entities.Ray;
import com.example.raycaster.Model.Raycasting.Raycasting.PreBaking.Math.Functions;
import com.example.raycaster.Model.Raycasting.Raycasting.PreBaking.Ray.PointOnRay;
import com.example.raycaster.Model.Raycasting.Raycasting.PreBaking.Ray.PreColumns.PreColumn;
import com.example.raycaster.View.Render;
import com.example.raycaster.Model.Resources.Textures.Texture;
import com.example.raycaster.Model.Raycasting.RenderProcedure;
import com.example.raycaster.Model.Raycasting.Raycasting.Textures.TextureContainer;

public final class Column {

    public static double ys;
    public static double yf;

    public static int lheight;
    public static double height;

    public static int posStart;
    public static int posFinal;


    public static int diff ;
    public static int len;
    public static int cdiff;

    public static double delta;
    public static double deltacolor;

    public static double dh = 0;
    public static double dc;
    public static byte trnsx = 0;

    public static boolean noTrapeze(double deltaPosY,int val){
        boolean decision = true;

        final int intdeltaPosXX = (int) deltaPosY & RenderProcedure.deltaPosMask;

        double tanx = Functions.getTan(val);
        if (intdeltaPosXX == 0 || intdeltaPosXX == 63) {
            if (tanx > 10 || tanx < -10) {
                decision = false;
            }
        } else {
            if (tanx < 0.1 && tanx > -0.1) {
                decision = false;
            }
        }
        return decision;
    }

    public static void selectTypeOfColumn(boolean halfup,boolean upper,boolean upperb,boolean half,boolean dhalf){
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
    }

    private static Texture selectTexture(boolean halfup,boolean upper,boolean upperb){
        Texture tex;

        if(halfup) tex = TextureContainer.halfTex;
        else if(upper) tex = TextureContainer.uptexture;
        else tex = TextureContainer.texture;

        if(upperb) tex = TextureContainer.upbtexture;

        return tex;
    }

    private static void prepare(int column,int lcolumn){
        diff = (int)(height-lheight);

        len = RenderProcedure.D_SCREEN_STEP;

        cdiff = column - lcolumn;
        if (cdiff < 0) cdiff = -cdiff;

        if (cdiff > 32) {
            column = lcolumn + 4;
            len = RenderProcedure.D_SCREEN_STEP+ 1;
        }

        delta = (double) (diff)/(double) len;
        deltacolor = (double) ( column-lcolumn)/(double) RenderProcedure.D_SCREEN_STEP;

        dh = 0;
        dc = lcolumn;
        trnsx = 0;
    }

    private static void makeSmoothBorders(boolean upperb,boolean upper,boolean half,int x,boolean renderHalf,boolean upperhalf){
        if(upperb){
            posStart = (int)(((int)((double)ys-3*dh) * (double)RenderProcedure.SCREEN_WIDTH + (double)x)) << Render.shiftPixelWidth;
            posFinal = (int)(((int)((double)yf-2*dh) * (double)RenderProcedure.SCREEN_WIDTH + (double)x)) << Render.shiftPixelWidth;
        }else
        if(upper){

            if(upperhalf)posStart = (int)(((int)((double)ys-1.5*dh) * (double)RenderProcedure.SCREEN_WIDTH + (double)x)) << Render.shiftPixelWidth;
            else posStart = (int)(((int)((double)ys-2*dh) * (double)RenderProcedure.SCREEN_WIDTH + (double)x)) << Render.shiftPixelWidth;
            posFinal = (int)(((int)((double)yf-dh) * (double)RenderProcedure.SCREEN_WIDTH + (double)x)) << Render.shiftPixelWidth;

        }else{

            if(renderHalf) posStart = (int)(((int)((double)ys) * (double)RenderProcedure.SCREEN_WIDTH + (double)x)) << Render.shiftPixelWidth;
            else posStart = (int)(((int)((double)ys-dh) * (double)RenderProcedure.SCREEN_WIDTH + (double)x)) << Render.shiftPixelWidth;

            if(half) posFinal = (int)(((int)((double)yf) * (double)RenderProcedure.SCREEN_WIDTH + (double)x)) << Render.shiftPixelWidth;
            else {
                posFinal = (int)(((int)((double)yf+dh) * (double)RenderProcedure.SCREEN_WIDTH + (double)x)) << Render.shiftPixelWidth;
            }
        }
    }
    public static void drawLine(short x, int height,int lheight,int column,int lcolumn,int shadow,boolean half,boolean upper,
                                int llminh,int llmaxh,boolean halfup,int lceili,boolean upperb,boolean dhalf){

        Column.lheight = lheight;
        Column.height = height;

        if(lceili == 1) shadow +=2;

        if(shadow>7) shadow = 7;

        selectTypeOfColumn(halfup, upper, upperb, half, dhalf);
        Texture tex = selectTexture(halfup, upper, upperb);

        prepare(column,lcolumn);

        if(yf>0)
            for(int n=0;n<len ;n++) {

                makeSmoothBorders(upperb,upper,half,x,dhalf,halfup);
                ColumnPixel.drawSmallColumn(llminh,llmaxh,upperb,shadow,tex);

            }
    }




}
