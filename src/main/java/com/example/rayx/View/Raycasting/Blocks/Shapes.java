package com.example.rayx.View.Raycasting.Blocks;

import com.example.rayx.Model.Raycasting.Raycasting.Analyse.Hits.ShapeHit;
import com.example.rayx.Model.Resources.Map.Map;
import com.example.rayx.Model.Raycasting.Raycasting.Analyse.RenderSteps.Ray;
import com.example.rayx.Model.Raycasting.Raycasting.Analyse.RenderSteps.Sight;
import com.example.rayx.Model.Raycasting.Raycasting.PreBaking.Ray.PointOnRay;
import com.example.rayx.Model.Raycasting.Raycasting.PreBaking.Ray.Buffers.PreColumn;
import com.example.rayx.Model.Raycasting.RenderProcedure;
import com.example.rayx.Model.Raycasting.Raycasting.PreBaking.Floor.FloorAndCeiling;

public final class Shapes extends RenderObject{


    private Shapes(){

    }

    private static void ignoreBigDiffrence(int value){
        int diff = value- Sight.lcolumn;
        if(diff > 32 || diff < -32){
            Sight.lcolumn = value;
        }
    }


    public static void renderShapes(float r){

        if(ShapeHit.isInShape()) {
            Ray.finish = true;

            final float height =  PreColumn.height;
            PreColumn.minh = RenderProcedure.cameraY - (int) height;

            if (Map.isNeighbourhood((int) PointOnRay.posX, (int) PointOnRay.posY, Sight.llcposX, Sight.llcposY)) {

                    Sight.lheighte = height;


            }

            int shadow = 0;


            if(Sight.renderwall) {

                if (!Sight.wallinitized)
                    Sight.lheighte = height;

                if (Sight.lheighte == 0) Sight.lheighte = height;

                Sight.wallinitized = true;

                if(Ray.ceili == 1){
                    shadow +=3;
                }
                if(PointOnRay.lintdeltaPosX <=16 || PointOnRay.lintdeltaPosX>=48){

                    ignoreBigDiffrence(PointOnRay.intdeltaPosY);

                    renderYWall(height,shadow,(int)Sight.lheighte);

                    Sight.lcolumn = PointOnRay.intdeltaPosY;

                }else{


                    ignoreBigDiffrence(PointOnRay.intdeltaPosX);

                    renderXWall(height,shadow,(int)Sight.lheighte);

                    Sight.lcolumn = PointOnRay.intdeltaPosX;

                }
                Sight.lastWall = false;
                Sight.lshadow = shadow;


                bufferInfoAboutShape(height);
            }


            Ray.oneheight = true;
            Ray.sprite = false;

        }else{
           renderFloor(r);
        }

    }

    private static void bufferInfoAboutShape(float height){
        PreColumn.llmaxh = RenderProcedure.cameraY - (int) height;
        Sight.lheighte = height;

        Sight.llposX = (int) PointOnRay.posX;
        Sight.llposY = (int) PointOnRay.posY;

        Sight.llcposX = (int) PointOnRay.posX;
        Sight.llcposY = (int) PointOnRay.posY;
    }

    private static void renderFloor(float r){
        FloorAndCeiling.renderFloor((int) PointOnRay.posX, (int) PointOnRay.posY, Ray.renderFloor, Sight.posScreenX, PointOnRay.deltaPosY, PointOnRay.deltaPosX, r,
                Ray.half, Ray.oneheight, Ray.halfupx == 1 || Ray.halfupx == 2, PreColumn.maxhh, PreColumn.minhh);
    }
}
