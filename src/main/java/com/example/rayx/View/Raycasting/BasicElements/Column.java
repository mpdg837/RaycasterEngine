package com.example.rayx.View.Raycasting.BasicElements;

import com.example.rayx.Model.Raycasting.Raycasting.Analyse.RenderSteps.Ray;
import com.example.rayx.Model.Raycasting.Raycasting.Analyse.RenderSteps.Sight;
import com.example.rayx.Model.Raycasting.Raycasting.PreBaking.Math.Functions;
import com.example.rayx.Model.Raycasting.Raycasting.Textures.TextureContainer;
import com.example.rayx.Model.Raycasting.RenderProcedure;
import com.example.rayx.Model.Resources.Textures.Texture;
import com.example.rayx.View.Raycasting.BasicElements.PixelSet.ColumnPixel;

public final class Column extends Trapeze{

    private Column(){

    }

    public static boolean noTrapeze(float deltaPosY,int val){
        boolean decision = true;

        final int intdeltaPosXX = (int) deltaPosY & RenderProcedure.deltaPosMask;

        float tanx = Functions.getTan(val);
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

    private static Texture selectTexture(boolean halfup, boolean upper, boolean upperb){
        Texture tex;

        if(halfup) tex = TextureContainer.halfTex;
        else if(upper) tex = TextureContainer.uptexture;
        else tex = TextureContainer.texture;

        if(upperb) tex = TextureContainer.upbtexture;

        return tex;
    }

    private static boolean darkerMode(int lceili, boolean upperb){
        return (lceili == 1) && !upperb && Sight.obj == 1;
    }
    public static void drawLine(short x, int height,int lheight,int column,int lcolumn,int shadow,boolean half,boolean upper,
                                int llminh,int llmaxh,boolean halfup,int lceili,boolean upperb,boolean dhalf,int floorH) {

        if (!(Ray.finalrender) || upperb) {
            Column.lheight = lheight;
            Column.height = height;


            if (shadow > 7) shadow = 7;

            selectTypeOfColumn(halfup, upper, upperb, half, dhalf,floorH);
            Texture tex = selectTexture(halfup, upper, upperb);

            if (darkerMode(lceili, upperb)) shadow += 2;

            prepare(column, lcolumn);

            if (yf > 0)
                for (int n = 0; n < len; n++) {

                    makeSmoothBorders(upperb, upper, half, x, dhalf, halfup,floorH);
                    ColumnPixel.drawSmallColumn(llminh, llmaxh, upperb, shadow, tex);

                }
        }
    }




}
