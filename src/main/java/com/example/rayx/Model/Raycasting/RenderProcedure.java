package com.example.rayx.Model.Raycasting;

import com.example.rayx.Model.RaycasterPoint;
import com.example.rayx.RayApp;
import com.example.rayx.Model.Raycasting.GameLoop.RenderLoopTask;
import com.example.rayx.Model.Raycasting.Raycasting.Analyse.RenderSteps.Sight;
import com.example.rayx.Model.Raycasting.Raycasting.PreBaking.Math.Functions;
import com.example.rayx.Model.Raycasting.Raycasting.MatrixBuffers.RenderInfoBuffer;
import com.example.rayx.Model.Raycasting.Raycasting.Textures.TextureContainer;
import com.example.rayx.View.Render;

@SuppressWarnings("SuspiciousNameCombination")
public final class RenderProcedure extends Render {

    public  static int canvasHeight= 300;
    public final  static byte distance =16;
    public final  static int deltaPosMask = 0x3f;


    public static final  float pi = (float) Math.PI;
    public static float realWidth;

    public static RaycasterPoint pos = new RaycasterPoint(61.5f,64.5f);
    public static float angle = 0;

    public static int cameraY = 300;


    public static RayApp app;
    static {

        Functions.precount(Quality.deltaRaycasterStep,Quality.raycasterStep);

    }

    public static void init(RayApp app, RenderLoopTask task){

        initMe(app,task);

        TextureContainer.loadTextures(app);
        RenderProcedure.app = app;

    }


    public static boolean render() {

        if(app.initized) {
            if (context != null) {

                clearMatrix();
                Quality.adaptationQuality();
                RenderInfoBuffer.clearBuffers();

                Sight.analyse();

                Initializing.initizer();

                convertToImage();

            }
        }
        return true;
    }


}
