package com.example.raycaster.View.Raycasting.Blocks;

import com.example.raycaster.Model.Raycasting.Raycasting.Analyse.RenderSteps.InPoint;
import com.example.raycaster.Model.Raycasting.Raycasting.Analyse.WallHit;
import com.example.raycaster.Model.Resources.Map.Map;
import com.example.raycaster.Model.Raycasting.Raycasting.Analyse.RenderSteps.Ray;
import com.example.raycaster.Model.Raycasting.Raycasting.Analyse.RenderSteps.Sight;
import com.example.raycaster.Model.Raycasting.Raycasting.PreBaking.Ray.PointOnRay;
import com.example.raycaster.Model.Raycasting.Raycasting.PreBaking.Ray.Buffers.PreColumn;
import com.example.raycaster.Model.Raycasting.RenderProcedure;


public final class Blocks extends RenderObject{

    private Blocks(){

    }

    public static void renderBlocks(float r){

        if(InPoint.inPlayerArea()) {

            if (Sight.obj == 11) {
                Shapes.renderShapes(r);
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

                                renderXWall(height,shadow,(int)Sight.lheight);

                                Sight.lcolumn = PointOnRay.intdeltaPosX;
                                Sight.lastWall = true;
                                Sight.lshadow = shadow;
                            } else if (WallHit.pY) {
                                if (Sight.lastWall) {
                                    Sight.lcolumn = 0;
                                }

                                renderYWall(height,shadow,(int)Sight.lheight);

                                Sight.lcolumn = PointOnRay.intdeltaPosY;
                                Sight.lastWall = false;
                                Sight.lshadow = shadow;
                            } else {
                                renderNWall(height,(int)Sight.lheight);

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
