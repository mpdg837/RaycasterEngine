package com.example.raycaster.Model.Raycasting.Raycasting.MatrixBuffers;

public final class RenderInfoBuffer extends InfoBuffer{



    public static int[] lfloord =new int[neighbourhoodAreaSize];
    public static int[] lupperd =new int[neighbourhoodAreaSize];
    public static float[] lheightsh = new float[neighbourhoodAreaSize];
    public static int[] lcolumnd =new int[neighbourhoodAreaSize];
    public static int[] lcolumnh =new int[neighbourhoodAreaSize];


    private RenderInfoBuffer(){

    }

    public static void clearBuffers(){


        SpriteInfoBuffer.clearBuffers();
        UpperInfoBuffer.clearBuffers();

        lheightsh= new float[neighbourhoodAreaSize];
        lcolumnd= new int[neighbourhoodAreaSize];
        lcolumnh= new int[neighbourhoodAreaSize];
        lfloord= new int[neighbourhoodAreaSize];
        lupperd= new int[neighbourhoodAreaSize];

    }
}
