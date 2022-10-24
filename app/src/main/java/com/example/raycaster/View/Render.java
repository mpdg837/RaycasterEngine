package com.example.raycaster.View;

import android.graphics.Bitmap;


import com.example.raycaster.Model.Raycasting.GameLoop.RenderLoopTask;
import com.example.raycaster.View.Activities.MainActivity;

import java.nio.ByteBuffer;

public class Render {

    public static Bitmap screen;
    public static MainActivity app;

    protected static RenderLoopTask context;
    public static int SCREEN_WIDTH = 320;
    public static int SCREEN_HEIGHT = 300;

    public static final int pixelWidth = 4;
    public static final int shiftPixelWidth = 2;
    public static final int maxLen = 192000 << shiftPixelWidth>>1;

    public static int lenScreen = (SCREEN_WIDTH*SCREEN_HEIGHT) << shiftPixelWidth;
    public static byte[] pixels = new byte[lenScreen];


    public Render(MainActivity app,RenderLoopTask task){
        context = task;
        Render.app = app;

        screen = Bitmap.createBitmap(SCREEN_WIDTH,SCREEN_HEIGHT, Bitmap.Config.ARGB_8888);

    }
    public static void initscreen(){

    }
    protected static void startredner(){
          pixels = new byte[lenScreen];

    }
    protected static void convertToImage() {
        if(app!= null) {
            if(app.img != null) {

                synchronized (app.img) {
                    final ByteBuffer raster = ByteBuffer.wrap(pixels);
                    screen.copyPixelsFromBuffer(raster);

                    if (app.img != null) {


                        app.img.invalidate();
                    }
                }
            }
        }
    }

    public static void setPixel(int pos, int rgb){
        if(pos>0 && pos < maxLen) {
            pixels[pos] = (byte)((rgb & 0xFF0000) >> 16);
            pixels[pos + 1] = (byte)((rgb & 0x00FF00) >> 8);
            pixels[pos + 2] = (byte)((rgb & 0xFF));
            pixels[pos + 3] = (byte) 255;
        }
    }

    public static int getPixel(int pos){
        if(pos>0 && pos < maxLen) {

             return  ((pixels[pos]) << 16) | ((pixels[pos + 1]) << 8) | (pixels[pos+2]);
        }else{
            return 0;
        }
    }


    public static boolean isEmpty(int pos){
        return pixels[pos+2]==0 && pixels[pos+1]==0 && pixels[pos] == 0;
    }

    public static boolean render() {
        return false;
    }
}
