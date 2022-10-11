package com.example.raycaster.Model.Raycasting.Raycasting.PreBaking.Sprites;

import com.example.raycaster.Model.Raycasting.Raycasting.Analyse.Entities.Ray;
import com.example.raycaster.Model.Raycasting.Raycasting.Analyse.Entities.Sight;
import com.example.raycaster.View.Raycasting.Half.Half;
import com.example.raycaster.View.Raycasting.Half.HalfShapes;
import com.example.raycaster.Model.Raycasting.Raycasting.PreBaking.Math.Functions;
import com.example.raycaster.Model.Raycasting.Raycasting.PreBaking.Ray.PointOnRay;
import com.example.raycaster.Model.Raycasting.Raycasting.PreBaking.Ray.PreColumn;
import com.example.raycaster.Model.Raycasting.RenderProcedure;
import com.example.raycaster.View.Raycasting.BasicElements.Floor;
import com.example.raycaster.View.Raycasting.Sprites.SpriteColumn;
import com.example.raycaster.View.Raycasting.Sprites.SpriteRotateColumn;

public final class Sprites {

    private static byte tex = 0;
    private static boolean start = false;
    private static boolean texM = false;
    private static boolean statusofangle = false;

    private static int eq;

    public static boolean isSprite(){
        boolean decision;

        if (Sight.obj != 3) decision = true;
        else {

            int sqx = (PointOnRay.intdeltaPosX - Sight.spritePosX);
            int sqy = (PointOnRay.intdeltaPosY - Sight.spritePosY);
            eq = sqx * sqx + sqy * sqy;
            decision = eq < 512;
        }


        if ((int) PointOnRay.posX == (int) RenderProcedure.pos.x && (int) PointOnRay.posY == (int) RenderProcedure.pos.y) {
            decision = false;
        }

        return decision;
    }

    private static int getShadowValue() {
        return (Ray.ceili == 1) ? 4 : 0;
    }

    public static void detectTypeOfStaticSprite(){
        tex = 0;
        start = false;
        texM = false;

        if ((Sight.obj == 8) && (PointOnRay.intdeltaPosY>>1 == 16)) {
            if(Ray.spriteStableCounter>2) {
                start = true;
                tex = (byte) PointOnRay.intdeltaPosX;
            }
            Ray.spriteStableCounter = 0;
        }else
        if ((Sight.obj == 9) && (PointOnRay.intdeltaPosX>>1) == 16) {
            if(Ray.spriteStableCounter>2) {
                start = true;
                tex = (byte) PointOnRay.intdeltaPosY;

                Ray.spriteStableCounter = 0;
            }
        }else
        if ((Sight.obj == 10) && ((PointOnRay.intdeltaPosX>>1) == 16 || (PointOnRay.intdeltaPosY>>1) == 16)) {

            boolean centerX = ((PointOnRay.intdeltaPosX>>1) < 18) && ((PointOnRay.intdeltaPosX>>1) > 14);
            boolean centerY = ((PointOnRay.intdeltaPosY>>1) < 18) && ((PointOnRay.intdeltaPosY>>1) > 14);

            if(Ray.spriteStableCounter>2 || (centerX && centerY)) {
                start = true;
                texM = (PointOnRay.intdeltaPosX >> 1) == 16;
                if (texM) {
                    tex = (byte) PointOnRay.intdeltaPosY;


                } else {
                    tex = (byte) PointOnRay.intdeltaPosX;


                }
            }

        }else{
            Ray.spriteStableCounter ++;
        }
    }

    public static void renderStaticSprite(double heights, int shadows){
        detectTypeOfStaticSprite();

        if (start) {

            SpriteColumn.render(heights,texM,tex,shadows);
        }
    }

    public static void renderDynamicSprite(double heights,int shadows){
        final int fun = (int) (-Sight.tan * (double) PointOnRay.intdeltaPosX + Sight.tan * (double) Sight.spritePosX + (double) Sight.spritePosY);

        final int posTexX = Functions.getSqrt(eq) + 1;
        statusofangle = PointOnRay.intdeltaPosY > fun;

        if (statusofangle != Ray.lstatusofAngle) {

            SpriteRotateColumn.render(heights,(byte)posTexX,shadows);

        }
    }

    public static void renderHalf(double heights){
        Ray.sprite = true;
        if (Sight.obj == 4) {
            Half.renderHalfBlock(heights);
        } else {

            final int fun = (int) (-Sight.tan * (double) PointOnRay.intdeltaPosX + Sight.tan * (double) Sight.spritePosX + (double) Sight.spritePosY);

            statusofangle = PointOnRay.intdeltaPosY > fun;
        }
    }

    private static void renderFloor(double r){
        Floor.renderFloor((int) PointOnRay.posX, (int) PointOnRay.posY, Ray.renderFloor, Sight.posScreenX, PointOnRay.deltaPosY, PointOnRay.deltaPosX, r,
                Ray.half, Ray.oneheight,Ray.halfupx == 1 || Ray.halfupx == 2, PreColumn.maxhh, PreColumn.minhh);

    }
    public static void renderSprites(double r){
        if (!Ray.oneheight) {

            int shadows = getShadowValue();

            statusofangle = false;

            if (isSprite()) {

                final double heights =  PreColumn.height;


                if(Sight.obj == 12){

                   HalfShapes.renderHalfShapes(PointOnRay.intdeltaPosX,PointOnRay.intdeltaPosY);
                }else
                if (!Ray.sprite) {
                    renderHalf(heights);

                } else if ((Sight.obj == 3)) {
                    renderDynamicSprite(heights,shadows);

                } else if ((Sight.obj >= 8)) {

                    renderStaticSprite(heights,shadows);

                }

                renderFloor(r);
                Ray.lstatusofAngle = statusofangle;
            } else {

                renderFloor(r);
            }
        } else {

            renderFloor(r);
        }

        Ray.spriterendered = true;
    }
}
