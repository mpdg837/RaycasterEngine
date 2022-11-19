package com.example.rayx.Model.Raycasting.Raycasting.PreBaking.Ray;

import com.example.rayx.Model.Raycasting.Quality;
import com.example.rayx.Model.Raycasting.Raycasting.Analyse.RenderSteps.Ray;
import com.example.rayx.Model.Raycasting.Raycasting.Analyse.RenderSteps.Sight;
import com.example.rayx.Model.Raycasting.Raycasting.PreBaking.Ray.Buffers.PreColumn;
import com.example.rayx.Model.Raycasting.RenderProcedure;

public final class PointOnRay {


    public static float posX;
    public static float posY;

    public static int lposY = 0;
    public static int lposX = 0;
    public static float deltaPosX;
    public static float deltaPosY;

    static float dr = 0;
    static int step = 0;
    static int nstep = 0;

    public static int intdeltaPosX;
    public static int intdeltaPosY;

    public static int lintdeltaPosX;
    public static int lintdeltaPosY;

    private PointOnRay(){

    }

    public static void resetRay(){
        dr = 0;
        step = 0;
        nstep = 0;

        posX = RenderProcedure.pos.x;
        posY = RenderProcedure.pos.y;

        deltaPosX = Sight.deltaPosXc;
        deltaPosY = Sight.deltaPosYc;

        lposY = 0;
        lposX = 0;
    }

    public static void nextStep(){

        lintdeltaPosY = intdeltaPosY;
        lintdeltaPosX = intdeltaPosX;

        PreColumn.z += AngleRay.cosBetaR;
        PreColumn.fakeHeight -= Quality.lineHeightStep;

        PointOnRay.deltaPosY += AngleRay.cosDeltaY;
        PointOnRay.deltaPosX += AngleRay.sinDeltaX;

        PointOnRay.lposY = (int)  PointOnRay.posY;
        PointOnRay.lposX = (int)  PointOnRay.posX;

        PointOnRay.posX += AngleRay.sinPosX;
        PointOnRay.posY += AngleRay.cosPosY;

        intdeltaPosX = (int) PointOnRay.deltaPosX & RenderProcedure.deltaPosMask;
        intdeltaPosY = (int) PointOnRay.deltaPosY & RenderProcedure.deltaPosMask;

        PreColumn.lheightpos = PreColumn.height;
    }

    public static void reductionAmountOfRaycastStep(){

        if (Sight.posScreenX != 0) {
            dr += Quality.raycasterStep;

            if (dr > 7) { // Sqrt 3
                dr = 0;
                step++;
                Ray.renderFloor = true;
            }

            if (step != 0) {
                if (nstep == step) {
                    Ray.renderFloor = !Ray.renderFloor;
                    nstep = 0;
                } else {
                    nstep++;
                }
            }


        }
    }
}
