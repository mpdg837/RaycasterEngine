package com.example.rayx.Model.Raycasting.Raycasting.MatrixBuffers;

public final class UpperInfoBuffer extends InfoBuffer{

    public static float[] lhhheight = new float[neighbourhoodAreaSize];
    public static float[] lhhsheight = new float[neighbourhoodAreaSize];

    public static float[] llhheight = new float[bufferListSize];
    public static float[] lllhheight = new float[bufferListSize];

    public static int[] lluposX =new int[bufferListSize];
    public static int[] lluposY = new int[bufferListSize];

    public static int[] llluposX =new int[bufferListSize];
    public static int[] llluposY =new int[bufferListSize];

    public static float[] lhheight = new float[neighbourhoodAreaSize];

    public static void clearBuffers(){

        llhheight = new float[bufferListSize];
        lllhheight = new float[bufferListSize];

        lluposY = new int[bufferListSize];
        lluposX = new int[bufferListSize];

        llluposY = new int[bufferListSize];
        llluposX = new int[bufferListSize];

        lhhheight= new float[neighbourhoodAreaSize];
        lhhsheight = new float[neighbourhoodAreaSize];

        lhheight= new float[neighbourhoodAreaSize];
    }
}
