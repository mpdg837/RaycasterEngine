package com.example.raycaster.Model.Raycasting;

import com.example.raycaster.Model.RaycasterPoint;

public final class Initializing {


    static int startcycles = 0;

    public static void initizer(){

        int posPix = 0;
        if(startcycles<255) {
            int level = 200;

            for (int y = 0; y < 399; y++) {
                for (int x = 0; x < 639; x++) {


                    RenderProcedure.setPixel(posPix, RenderProcedure.shadowPixel(RenderProcedure.getPixel(posPix),level));

                    posPix+=RenderProcedure.pixelWidth;
                }
                posPix+=RenderProcedure.pixelWidth;
            }

            RenderProcedure.angle +=0.1;
            if(RenderProcedure.angle>5){
                RenderProcedure.angle = 0;
            }
            startcycles +=5;
            RenderProcedure.pos = new RaycasterPoint(61.5f,64.5f);
        }else{
        }
    }
}
