package com.example.rayx.View;

import com.example.rayx.Model.Raycasting.GameLoop.RenderLoopTask;
import com.example.rayx.RayApp;
import java.nio.ByteBuffer;

public class Render extends Canvas{

    public static RayApp app;

    public static RenderLoopTask context;

    public static void initMe(RayApp app, RenderLoopTask task){

        init();

        context = task;
        Render.app = app;

    }
    public static void initscreen(){

    }

    public static void convertToImage() {
        if(app!= null) {
            if(app.renderScene.view != null) {

                app.renderScene.view.refresh(pixels);

            }
        }
    }

    public static int shadowPixel(int pcol,final int shadowIntensity){
        int r = (pcol >> 16) & 0xFF;
        int g = (pcol >> 8) & 0xFF;
        int b = pcol & 0xFF;

        if(r-shadowIntensity > 0) r-=shadowIntensity;
        else r=0;

        if(g-shadowIntensity >0) g-=shadowIntensity;
        else g=0;

        if(b-shadowIntensity >0) b-=shadowIntensity;
        else b=0;

        int col = (r << 16) | (g << 8) | (b);
        if(col == 0) col = 1;

        return col;
    }

    public static boolean render() {
        return false;
    }
}
