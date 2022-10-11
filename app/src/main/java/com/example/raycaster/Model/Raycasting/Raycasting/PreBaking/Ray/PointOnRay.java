package com.example.raycaster.Model.Raycasting.Raycasting.PreBaking.Ray;

import com.example.raycaster.Model.Raycasting.Raycasting.Analyse.Entities.Ray;
import com.example.raycaster.Model.Raycasting.Raycasting.Analyse.Entities.Sight;
import com.example.raycaster.Model.Raycasting.RenderProcedure;

public final class PointOnRay {


    public static double posX;
    public static double posY;

    public static int lposY = 0;
    public static int lposX = 0;
    public static double deltaPosX;
    public static double deltaPosY;

    static double dr = 0;
    static int step = 0;
    static int nstep = 0;

    public static int intdeltaPosX;
    public static int intdeltaPosY;

    public static int lintdeltaPosX;
    public static int lintdeltaPosY;

    public PointOnRay(){
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
        PreColumn.fakeHeight -= RenderProcedure.lineHeightStep;

        PointOnRay.deltaPosY += AngleRay.cosDeltaY;
        PointOnRay.deltaPosX += AngleRay.sinDeltaX;

        PointOnRay.lposY = (int)  PointOnRay.posY;
        PointOnRay.lposX = (int)  PointOnRay.posX;

        PointOnRay.posX += AngleRay.sinPosX;
        PointOnRay.posY += AngleRay.cosPosY;

        intdeltaPosX = (int) PointOnRay.deltaPosX & RenderProcedure.deltaPosMask;
        intdeltaPosY = (int) PointOnRay.deltaPosY & RenderProcedure.deltaPosMask;
    }

    public static void reductionAmountOfRaycastStep(){

        if (Sight.posScreenX != 0) {
            dr += RenderProcedure.raycasterStep;

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
