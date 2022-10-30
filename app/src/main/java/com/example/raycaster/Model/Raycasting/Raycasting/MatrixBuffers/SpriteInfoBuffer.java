package com.example.raycaster.Model.Raycasting.Raycasting.MatrixBuffers;

import com.example.raycaster.Model.Raycasting.RenderProcedure;

public final class SpriteInfoBuffer extends InfoBuffer{

    public static float[] mapsprite = new float[neighbourhoodAreaSize];
    public static byte[] mapsprite2 = new byte[neighbourhoodAreaSize];
    public static boolean[] mapspritechange = new boolean[neighbourhoodAreaSize];
    public static int[] reservedSpritePixels = new int[RenderProcedure.canvasHeight<<6];

    public static void clearBuffers(){

        mapsprite = new float[neighbourhoodAreaSize];
        mapsprite2 = new byte[neighbourhoodAreaSize];
        mapspritechange= new boolean[neighbourhoodAreaSize];
    }
}
