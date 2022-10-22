package com.example.raycaster.Model.Game;

import android.graphics.Point;

import com.example.raycaster.Model.RaycasterPoint;
import com.example.raycaster.Model.Raycasting.GameLoop.RenderLoopTask;
import com.example.raycaster.Model.Raycasting.RenderProcedure;
import com.example.raycaster.Model.Resources.Map.Map;


public final class Moving {

    public static float trnsX;
    public static float trnsY;

    public static float dAngle;

    public static Point startMousePos = new Point(0,0);
    public static boolean walking(){

        float step = 1.75f;

        if(RenderLoopTask.delay>RenderLoopTask.FRAME_DELAY) step *= (float) RenderLoopTask.delay/(float) RenderLoopTask.FRAME_DELAY;
        final float sinX = (float) Math.sin(RenderProcedure.angle) * step;
        final float cosY = (float) Math.cos(RenderProcedure.angle) * step;

        final float sinXl = (float) Math.sin(RenderProcedure.angle-Math.PI/2) * (step/2);
        final float cosYl = (float) Math.cos(RenderProcedure.angle-Math.PI/2) * (step/2);

        Point mousePos = getMousePosition();

        if(dAngle!=0){
            RenderProcedure.angle += dAngle;
            if(RenderProcedure.angle<-5.7){
                RenderProcedure.angle = 0;
            }

            if(RenderProcedure.angle > 5.7){
                RenderProcedure.angle = 0;
            }
        }


        char key = 0;

        if(trnsX !=0 || trnsY!=0) {
            RaycasterPoint npoint1 = new RaycasterPoint(RenderProcedure.pos.x + trnsX, RenderProcedure.pos.y + trnsY);
            if (Map.map[(int) npoint1.x][(int) npoint1.y] == 0 || Map.map[(int) npoint1.x][(int) npoint1.y] == 5) {
                RenderProcedure.pos.x += trnsY * step *sinX;
                RenderProcedure.pos.y += trnsY * step * cosY;
            } else {
                RenderProcedure.pos.x -= trnsY * step * sinX;
                RenderProcedure.pos.y -= trnsY * step* cosY;
            }
            return true;
        }else{
            return false;
        }


    }



    public static Point getMousePosition(){
        return new Point(0,0);

    }
}
