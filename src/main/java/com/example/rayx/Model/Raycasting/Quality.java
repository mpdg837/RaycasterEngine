package com.example.rayx.Model.Raycasting;

import com.example.rayx.Model.Game.Moving;
import com.example.rayx.View.Render;

public final class Quality {


    public static final int SCREEN_STEP_STAND =3;
    public static final int SCREEN_STEP_WALK = 4;
    public final  static byte textureResolution = 64;

    public static int SCREEN_STEP;
    public static int D_SCREEN_STEP;
    public final  static float raycasterStep = 0.032f;
    public final static float lineHeightStep = (float) RenderProcedure.canvasHeight/(float) RenderProcedure.distance * raycasterStep;
    public final  static float deltaRaycasterStep = raycasterStep * textureResolution;

    public static float deltaFi;

    public static void adaptationQuality(){
        if(Moving.walking()){
            SCREEN_STEP =SCREEN_STEP_WALK;
        }else{
            SCREEN_STEP =SCREEN_STEP_STAND;
        }
        D_SCREEN_STEP = SCREEN_STEP << 1;
        RenderProcedure.realWidth = RenderProcedure.SCREEN_WIDTH << Render.shiftPixelWidth;

        deltaFi = RenderProcedure.pi/((float) 1920/(float) SCREEN_STEP);
    }

}
