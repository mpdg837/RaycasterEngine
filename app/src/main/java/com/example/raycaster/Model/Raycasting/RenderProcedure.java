package com.example.raycaster.Model.Raycasting;

import com.example.raycaster.Model.RaycasterPoint;
import com.example.raycaster.View.Activities.MainActivity;
import com.example.raycaster.Model.Raycasting.GameLoop.RenderLoopTask;
import com.example.raycaster.Model.Raycasting.Raycasting.Analyse.RenderSteps.Sight;
import com.example.raycaster.Model.Raycasting.Raycasting.PreBaking.Math.Functions;
import com.example.raycaster.Model.Raycasting.Raycasting.MatrixBuffers.RenderInfoBuffer;
import com.example.raycaster.Model.Raycasting.Raycasting.Textures.TextureContainer;
import com.example.raycaster.View.Render;

@SuppressWarnings("SuspiciousNameCombination")
public final class RenderProcedure extends Render {


    public final  static int canvasHeight= 200;
    public final  static byte distance =16;
    public final  static int deltaPosMask = 0x3f;


    public static final  float pi = (float) Math.PI;
    public static float realWidth;

    public static RaycasterPoint pos = new RaycasterPoint(61.5f,64.5f);
    public static float angle = 0;

    public static final int cameraY = 200;


    public static MainActivity app;
    static {

        Functions.precount(Quality.deltaRaycasterStep,Quality.raycasterStep);

    }

    public RenderProcedure(MainActivity app, RenderLoopTask task){

        super(app,task);

        TextureContainer.loadTextures(app);
        RenderProcedure.app = app;

    }


    public static boolean render() {


        if(app.initized) {
            if (context != null) {

                startredner();
                Quality.adaptationQuality();
                RenderInfoBuffer.clearBuffers();

                Sight.renderSight();

                Initializing.initizer();

                convertToImage();

            }
        }
        return true;
    }


}
