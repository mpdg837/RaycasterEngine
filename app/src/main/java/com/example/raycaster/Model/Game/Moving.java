package com.example.raycaster.Model.Game;

import android.graphics.Point;

import com.example.raycaster.Model.RaycasterPoint;
import com.example.raycaster.Model.Raycasting.GameLoop.RenderLoopTask;
import com.example.raycaster.Model.Raycasting.RenderProcedure;
import com.example.raycaster.Model.Resources.Map.Map;


public final class Moving {

    public static double trnsX;
    public static double trnsY;

    public static double dAngle;

    public static Point startMousePos = new Point(0,0);
    public static boolean walking(){

        double step = 1.75f;

        if(RenderLoopTask.delay>RenderLoopTask.FRAME_DELAY) step *= (double) RenderLoopTask.delay/(double) RenderLoopTask.FRAME_DELAY;
        final double sinX = (double) Math.sin(RenderProcedure.angle) * step;
        final double cosY = (double) Math.cos(RenderProcedure.angle) * step;

        final double sinXl = (double) Math.sin(RenderProcedure.angle-Math.PI/2) * (step/2);
        final double cosYl = (double) Math.cos(RenderProcedure.angle-Math.PI/2) * (step/2);

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
