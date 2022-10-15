package com.example.raycaster.View.Raycasting.BasicElements;

import com.example.raycaster.Model.Raycasting.Raycasting.Textures.TextureContainer;
import com.example.raycaster.Model.Raycasting.RenderProcedure;

public final class FloorRender {
    public static final double MAX_GOOD_QUALITY_DISTANCE_UP = 1.5;
    public static final double MAX_GOOD_QUALITY_DISTANCE_DOWN = 2;

    public static final double MAX_GOOD_QUALITY_DISTANCE_UP_WALK = 1.25;
    public static final double MAX_GOOD_QUALITY_DISTANCE_DOWN_WALK = 1.5;

    public static int posllY;
    public static int posllX;

    private static boolean isGoodCeilingQuality(int ceil,double r){

        boolean goodQuality = false;

        if(ceil !=2) {
            if (RenderProcedure.SCREEN_STEP == 4) {
                goodQuality = r < MAX_GOOD_QUALITY_DISTANCE_UP;
            } else {
                goodQuality = r < MAX_GOOD_QUALITY_DISTANCE_UP_WALK;
            }
        }
        return goodQuality;
    }

    private static boolean isGoodFloorQuality(double r){

        boolean goodQuality = false;

        if (RenderProcedure.SCREEN_STEP == 4) {
            goodQuality = r < MAX_GOOD_QUALITY_DISTANCE_DOWN;
        } else {
            goodQuality = r < MAX_GOOD_QUALITY_DISTANCE_DOWN_WALK;
        }

        return goodQuality;
    }

    public static void renderCeiling(double r, int ceil, int hei, int poslX, int poslY, int posScreenX, int posstart){

        if (isGoodCeilingQuality(ceil,r)) {
            int[] color = new int[hei + (ceil - 1)];

            double posXa = posllX;
            double posYa = posllY;

            final double deltaPosXa = (double) (poslX - posllX) / (double) hei;
            final double deltaPosYa = (double) (poslY - posllY) / (double) hei;

            for (int k = 0; k < color.length; k++) {
                if (ceil == 1)
                    color[k] = TextureContainer.floor.getPixel((int) posXa, (int) posYa, 7);
                else
                    color[k] = TextureContainer.floor.getPixel((int) posXa, (int) posYa, 1);


                posXa += deltaPosXa;
                posYa += deltaPosYa;
            }

            FloorPixel.setCPixelGoodQuality(posScreenX - (RenderProcedure.SCREEN_STEP << 1),
                    posstart, color, hei + (ceil - 1), false);
        }else{
            int color = 0;

            if (ceil == 1)
                color = TextureContainer.floor.getPixel((int) poslX, (int) poslY, 7);
            else
                color = TextureContainer.floor.getPixel((int) poslX, (int) poslY, 1);


            FloorPixel.setCPixel(posScreenX - (RenderProcedure.SCREEN_STEP << 1),
                    posstart, color, hei + (ceil - 1), false);
        }
    }

    public static void renderFloorDown(double r, int ceil, int hei, int poslX, int poslY, int posScreenX, int posfinish){
        int intensity = 2;
        if (ceil == 1) intensity = 7;

        if(isGoodFloorQuality(r)) {

            int[] scolor = new int[hei];

            double posXa = posllX;
            double posYa = posllY;

            final double deltaPosXa = (double) (poslX - posllX) / (double) hei;
            final double deltaPosYa = (double) (poslY - posllY) / (double) hei;

            for (int k = 0; k < scolor.length; k++) {

                scolor[k] = TextureContainer.floor.getPixel((int) posXa, (int) posYa, intensity);

                posXa += deltaPosXa;
                posYa += deltaPosYa;
            }
            FloorPixel.setCPixelGoodQuality(posScreenX - (RenderProcedure.SCREEN_STEP << 1), posfinish, scolor, hei, true);

        }else{
            int scolor = TextureContainer.floor.getPixel((int) poslX, (int) poslY, intensity);
            FloorPixel.setCPixel(posScreenX - (RenderProcedure.SCREEN_STEP << 1), posfinish, scolor, hei, true);
        }
    }
}
