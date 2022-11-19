package com.example.rayx.View.Raycasting.Sprites;

import com.example.rayx.Model.Raycasting.Quality;
import com.example.rayx.Model.Raycasting.Raycasting.Analyse.RenderSteps.Ray;
import com.example.rayx.Model.Raycasting.Raycasting.Analyse.RenderSteps.Sight;
import com.example.rayx.Model.Raycasting.Raycasting.MatrixBuffers.SpriteInfoBuffer;
import com.example.rayx.View.Render;
import com.example.rayx.Model.Raycasting.RenderProcedure;

public final class SpriteBufferRender {

    private SpriteBufferRender(){

    }

    public static void renderBufferedColumn(){
        int width = Quality.SCREEN_STEP << Render.shiftPixelWidth;
        int trns =  Quality.SCREEN_STEP << Render.shiftPixelWidth << 1;

        int mpos = (Sight.posScreenX << Render.shiftPixelWidth) - trns;

        int p = 0;
        int count = 0;

        for (int y = 0; y < RenderProcedure.pixels.length; y = (int) (y + RenderProcedure.realWidth)) {
            int xx = 0;

            for (int x = 0; x < width; x += RenderProcedure.pixelWidth) {

                count = Ray.countPosBuffer(xx, p);

                int readed = SpriteInfoBuffer.reservedSpritePixels[count];

                if (readed != 0 && mpos + x > 0) {
                    RenderProcedure.setPixel(mpos + x, readed);
                    SpriteInfoBuffer.reservedSpritePixels[count] = 0;
                }

                xx++;
            }


            p++;
            mpos += RenderProcedure.realWidth;
        }
    }
}
