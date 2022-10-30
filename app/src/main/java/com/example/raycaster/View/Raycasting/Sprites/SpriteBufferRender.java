package com.example.raycaster.View.Raycasting.Sprites;

import com.example.raycaster.Model.Raycasting.Raycasting.Analyse.Entities.Ray;
import com.example.raycaster.Model.Raycasting.Raycasting.Analyse.Entities.Sight;
import com.example.raycaster.View.Render;
import com.example.raycaster.Model.Raycasting.Raycasting.RenderInfoBuffer;
import com.example.raycaster.Model.Raycasting.RenderProcedure;

public final class SpriteBufferRender {

    private SpriteBufferRender(){

    }

    public static void renderBufferedColumn(){
        int width = RenderProcedure.SCREEN_STEP << Render.shiftPixelWidth;
        int trns =  RenderProcedure.SCREEN_STEP << Render.shiftPixelWidth << 1;

        int mpos = (Sight.posScreenX << Render.shiftPixelWidth) - trns;

        int p = 0;
        int count = 0;

        for (int y = 0; y < RenderProcedure.pixels.length; y = (int) (y + RenderProcedure.realWidth)) {
            int xx = 0;

            for (int x = 0; x < width; x += RenderProcedure.pixelWidth) {

                count = Ray.countPosBuffer(xx, p);

                int readed = RenderInfoBuffer.reservedSpritePixels[count];

                if (readed != 0 && mpos + x > 0) {
                    RenderProcedure.setPixel(mpos + x, readed);
                    RenderInfoBuffer.reservedSpritePixels[count] = 0;
                }

                xx++;
            }


            p++;
            mpos += RenderProcedure.realWidth;
        }
    }
}
