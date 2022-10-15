package com.example.raycaster.View.Raycasting.Blocks;

import com.example.raycaster.Model.Raycasting.Raycasting.Analyse.ShapeHit;
import com.example.raycaster.Model.Raycasting.Raycasting.Analyse.WallHit;
import com.example.raycaster.Model.Resources.Map.Map;
import com.example.raycaster.Model.Raycasting.Raycasting.Analyse.Entities.Ray;
import com.example.raycaster.Model.Raycasting.Raycasting.Analyse.Entities.Sight;
import com.example.raycaster.Model.Raycasting.Raycasting.PreBaking.Ray.AngleRay;
import com.example.raycaster.Model.Raycasting.Raycasting.PreBaking.Ray.PointOnRay;
import com.example.raycaster.Model.Raycasting.Raycasting.PreBaking.Ray.PreColumns.PreColumn;
import com.example.raycaster.Model.Raycasting.RenderProcedure;
import com.example.raycaster.View.Raycasting.BasicElements.Column;
import com.example.raycaster.Model.Raycasting.Raycasting.PreBaking.Floor;

public final class Shpaes {


    private static void ignoreBigDiffrence(int value){
        int diff = value- Sight.lcolumn;
        if(diff > 32 || diff < -32){
            Sight.lcolumn = value;
        }
    }

    private static void renderYWall(double height, int shadow){
        Column.drawLine((short) (Sight.posScreenX - RenderProcedure.D_SCREEN_STEP), (int) height, (int) Sight.lheighte,
                PointOnRay.intdeltaPosY, Sight.lcolumn, shadow, Ray.half, false, 0, 400
                , false, Ray.lceili, false, false);

    }

    private static void renderXWall(double height, int shadow){
        Column.drawLine((short) (Sight.posScreenX - RenderProcedure.D_SCREEN_STEP), (int) height, (int) Sight.lheighte,
                PointOnRay.intdeltaPosX, Sight.lcolumn, 0, Ray.half, false, 0, 400
                , false, Ray.lceili, false, false);

    }
    private static int countShadow(int value, int shadow){
        if(value < 19){
            shadow = 1;
        }else{
            shadow = 2;
        }

        if(Ray.ceili == 1){
            shadow +=3;
        }

        return shadow;
    }
    public static void renderShapes(double r){

        if(ShapeHit.isInShape()) {
            Ray.finish = true;

            final double height =  PreColumn.height;
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

                if(PointOnRay.lintdeltaPosX <=16 || PointOnRay.lintdeltaPosX>=48){

                    ignoreBigDiffrence(PointOnRay.intdeltaPosY);

                    shadow = countShadow(PointOnRay.intdeltaPosY,shadow);
                    renderYWall(height,shadow);

                    Sight.lcolumn = PointOnRay.intdeltaPosY;

                }else{


                    ignoreBigDiffrence(PointOnRay.intdeltaPosX);

                    shadow = countShadow(PointOnRay.intdeltaPosX,shadow);
                    renderXWall(height,shadow);

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

    private static void bufferInfoAboutShape(double height){
        PreColumn.llmaxh = RenderProcedure.cameraY - (int) height;
        Sight.lheighte = height;

        Sight.llposX = (int) PointOnRay.posX;
        Sight.llposY = (int) PointOnRay.posY;

        Sight.llcposX = (int) PointOnRay.posX;
        Sight.llcposY = (int) PointOnRay.posY;
    }

    private static void renderFloor(double r){
        Floor.renderFloor((int) PointOnRay.posX, (int) PointOnRay.posY, Ray.renderFloor, Sight.posScreenX, PointOnRay.deltaPosY, PointOnRay.deltaPosX, r,
                Ray.half, Ray.oneheight, Ray.halfupx == 1 || Ray.halfupx == 2, PreColumn.maxhh, PreColumn.minhh);
    }
}
