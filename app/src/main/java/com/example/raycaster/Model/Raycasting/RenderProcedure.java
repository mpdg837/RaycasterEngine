package com.example.raycaster.Model.Raycasting;

import com.example.raycaster.Model.RaycasterPoint;
import com.example.raycaster.View.Activities.MainActivity;
import com.example.raycaster.Model.Game.Moving;
import com.example.raycaster.Model.Raycasting.GameLoop.RenderLoopTask;
import com.example.raycaster.Model.Raycasting.Raycasting.Analyse.Entities.Sight;
import com.example.raycaster.Model.Raycasting.Raycasting.PreBaking.Math.Functions;
import com.example.raycaster.Model.Raycasting.Raycasting.RenderInfoBuffer;
import com.example.raycaster.Model.Raycasting.Raycasting.Textures.TextureContainer;
import com.example.raycaster.View.Render;

@SuppressWarnings("SuspiciousNameCombination")
public final class RenderProcedure extends Render {

    static int startcycles = 0;

    public final  static int canvasHeight= 150;
    public final  static byte distance = 16;
    public final  static int deltaPosMask = 0x3f;
    public final  static float raycasterStep = 0.064f;
    public final static float lineHeightStep = (float) canvasHeight/(float) distance * raycasterStep;
    public final  static byte textureResolution = 64;

    public final  static float deltaRaycasterStep = raycasterStep * textureResolution;
    public static final  float pi = (float) Math.PI;
    public static int SCREEN_STEP;
    public static int D_SCREEN_STEP;
    public static float realWidth;
    public static float deltaFi;

    public static RaycasterPoint pos = new RaycasterPoint(61.5f,64.5f);
    public static float angle = 0;

    public static final int SCREEN_STEP_STAND =3;
    public static final int SCREEN_STEP_WALK = 4;
    public static final int cameraY = 150;


    public static MainActivity app;
    static {

        Functions.precount(deltaRaycasterStep,raycasterStep);

    }

    public RenderProcedure(MainActivity app, RenderLoopTask task){

        super(app,task);

        TextureContainer.loadTextures(app);
        RenderProcedure.app = app;

    }

    public static void adaptationQuality(){
        if(Moving.walking()){
            SCREEN_STEP =SCREEN_STEP_WALK;
        }else{
            SCREEN_STEP =SCREEN_STEP_STAND;
        }
        D_SCREEN_STEP = SCREEN_STEP << 1;
        realWidth = SCREEN_WIDTH << Render.shiftPixelWidth;

        deltaFi = pi/((float) 1920/(float) SCREEN_STEP);
    }



    public static boolean render() {


        if(app.initized) {
            if (context != null) {

                startredner();
                adaptationQuality();
                RenderInfoBuffer.clearBuffers();

                Sight.renderSight();

                initizer();

                convertToImage();

            }
        }
        return true;
    }

    public static void initizer(){

        int posPix = 0;
        if(startcycles<255) {
            int level = 200;

            for (int y = 0; y < 399; y++) {
                for (int x = 0; x < 639; x++) {


                    setPixel(posPix, shadowPixel(getPixel(posPix),level));

                    posPix+=pixelWidth;
                }
                posPix+=pixelWidth;
            }

            angle +=0.1;
            if(angle>5){
                angle = 0;
            }
            startcycles +=5;
            pos = new RaycasterPoint(61.5f,64.5f);
        }else{
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
}
