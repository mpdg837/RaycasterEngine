package com.example.rayx.Model.Game;

import com.example.rayx.Model.Raycasting.RenderProcedure;
import javafx.stage.Window;

public final class Rotating {
    public static float dAngle;


    private static int lastPosX = 0;
    private static float deltaPos;

    private static boolean move = false;
    private Rotating(){}

    public static void getMousePos(int posX){
        int delta = posX - lastPosX;
        if(posX != 100 - 8) {
            if (lastPosX != 0) {

                deltaPos += delta;
            }
        }

        move = !move;
        lastPosX = posX;
    }

    private static void resetMousPos(){
        deltaPos = 0;

    }
    public static void analyse(){

        dAngle = deltaPos/50;
        if(dAngle!=0){
            RenderProcedure.angle += dAngle;
            if(RenderProcedure.angle<-5.7){
                RenderProcedure.angle = 0;
            }

            if(RenderProcedure.angle > 5.7){
                RenderProcedure.angle = 0;
            }
        }

        resetMousPos();
    }
}
