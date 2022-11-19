package com.example.rayx.Model.Game;

import com.example.rayx.Model.RaycasterPoint;
import com.example.rayx.Model.Raycasting.GameLoop.RenderLoopTask;
import com.example.rayx.Model.Raycasting.RenderProcedure;
import com.example.rayx.Model.Resources.Map.Map;


public final class Moving {

    public static float trnsY;
    public static float trnsX;
    public static float dAngle;

    private static float step;
    private static float deltaFi;
    private static float trns;

    private Moving(){

    }

    public static void setWalkY(float trnsY){
        Moving.trnsY = trnsY;
    }
    public static void setWalkX(float trnsX){
        Moving.trnsX = trnsX;
    }

    public static void stopWalk(){
        Moving.trnsY = 0;
        Moving.trnsX = 0;
    }

    private static void preCount(){
        step = 0.75f;
        deltaFi = 0;
        if(RenderLoopTask.delay>RenderLoopTask.FRAME_DELAY) step *= (float) RenderLoopTask.delay/(float) RenderLoopTask.FRAME_DELAY;

        trns = trnsX != 0 ? Math.abs(trnsX) : trnsY;

        if(trnsX > 0){
            deltaFi = (float)Math.PI/(float)2;
        }else if(trnsX<0){
            deltaFi = -(float) Math.PI/(float) 2;
        }else{
            step = 1.75f;
        }

    }
    public static boolean walking(){

        preCount();

        final float sinX = (float) Math.sin(RenderProcedure.angle + deltaFi) * step;
        final float cosY = (float) Math.cos(RenderProcedure.angle + deltaFi) * step;

        Rotating.analyse();


        char key = 0;


        float nposX = RenderProcedure.pos.x + trns * step *sinX;
        float nposY = RenderProcedure.pos.y + trns * step * cosY;
        if(trns!=0) {
            RaycasterPoint npoint1 = new RaycasterPoint(nposX, nposY);
            if (Map.map[(int) npoint1.x][(int) npoint1.y] == 0 || Map.map[(int) npoint1.x][(int) npoint1.y] == 5) {
                RenderProcedure.pos.x = nposX;
                RenderProcedure.pos.y = nposY;
            }
            return true;
        }else{
            return false;
        }


    }

}
