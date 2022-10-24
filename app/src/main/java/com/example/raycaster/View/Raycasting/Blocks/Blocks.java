package com.example.raycaster.View.Raycasting.Blocks;

import com.example.raycaster.Model.Raycasting.Raycasting.Analyse.WallHit;
import com.example.raycaster.Model.Resources.Map.Map;
import com.example.raycaster.Model.Raycasting.Raycasting.Analyse.Entities.Ray;
import com.example.raycaster.Model.Raycasting.Raycasting.Analyse.Entities.Sight;
import com.example.raycaster.Model.Raycasting.Raycasting.PreBaking.Ray.AngleRay;
import com.example.raycaster.Model.Raycasting.Raycasting.PreBaking.Ray.PointOnRay;
import com.example.raycaster.Model.Raycasting.Raycasting.PreBaking.Ray.PreColumns.PreColumn;
import com.example.raycaster.Model.Raycasting.RenderProcedure;
import com.example.raycaster.View.Raycasting.BasicElements.Column;


public final class Blocks {

    private static void renderXWall(float height,int shadow){
        Column.drawLine((short) (Sight.posScreenX - RenderProcedure.D_SCREEN_STEP), (int) height, (int) Sight.lheight,
                PointOnRay.intdeltaPosX, Sight.lcolumn, shadow, Ray.half, false, 0, 400
                , false, Ray.lceili, false, false,false);
    }

    private static void renderYWall(float height,int shadow){
        Column.drawLine((short) (Sight.posScreenX - RenderProcedure.D_SCREEN_STEP), (int) height, (int) Sight.lheight,
                PointOnRay.intdeltaPosY, Sight.lcolumn, shadow, Ray.half, false, 0, 400
                , false, Ray.lceili, false, false,false);
    }

    private static void renderNWall(float height){
        Column.drawLine((short) (Sight.posScreenX - RenderProcedure.D_SCREEN_STEP), (int) height, (int) Sight.lheight,
                Sight.lcolumn, Sight.lcolumn, Sight.lshadow, Ray.half, false, 0, 400
                , false, Ray.lceili, false, false,false);
    }

    public static void renderBlocks(float r){

        if((int) PointOnRay.posX != (int) RenderProcedure.pos.x || (int)PointOnRay.posY != (int)RenderProcedure.pos.y) {

            if (Sight.obj == 11) {
                Shpaes.renderShapes(r);
            } else {
                Ray.finish = true;

                final float height = PreColumn.height;
                PreColumn.minh = RenderProcedure.cameraY - (int) height;

                if (Sight.renderwall) {

                    if (Map.isNeighbourhood((int) PointOnRay.posX, (int) PointOnRay.posY, Sight.llposX, Sight.llposY)) {

                        Sight.lheight = height;


                    }

                    if (Sight.lheight == 0) Sight.lheight = height;
                    if (!Sight.wallinitized)
                        Sight.lheight = height;

                        if (Sight.posScreenX != 0) {

                            int shadow = 0;


                            if ((WallHit.pY1 || WallHit.pY2)) {
                                if (!Sight.lastWall) {
                                    Sight.lcolumn = 0;
                                }

                                renderXWall(height,shadow);

                                Sight.lcolumn = PointOnRay.intdeltaPosX;
                                Sight.lastWall = true;
                                Sight.lshadow = shadow;
                            } else if (WallHit.pY) {
                                if (Sight.lastWall) {
                                    Sight.lcolumn = 0;
                                }

                                renderYWall(height,shadow);

                                Sight.lcolumn = PointOnRay.intdeltaPosY;
                                Sight.lastWall = false;
                                Sight.lshadow = shadow;
                            } else {
                                renderNWall(height);

                            }
                            Sight.wallinitized = true;

                        }


                }


                bufferInfo(height);
                Ray.oneheight = true;
                Ray.sprite = false;
            }
        }
    }

    public static void bufferInfo(float height){
        PreColumn.llmaxh = RenderProcedure.cameraY - (int) height;
        Sight.lheight = height;

        Sight.llposX = (int) PointOnRay.posX;
        Sight.llposY = (int) PointOnRay.posY;
    }
}
