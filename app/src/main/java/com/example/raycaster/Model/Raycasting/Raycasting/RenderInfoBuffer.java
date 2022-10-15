package com.example.raycaster.Model.Raycasting.Raycasting;

import com.example.raycaster.Model.Raycasting.RenderProcedure;

public final class RenderInfoBuffer {

    public static double[] llhheight = new double[16];
    public static double[] lllhheight = new double[16];

    public static int[] lfloord =new int[32<<5];
    public static int[] lupperd =new int[32<<5];
    public static double[] lheightsh = new double[32<<5];
    public static int[] lcolumnd =new int[32<<5];
    public static double[] mapsprite = new double[32<<5];
    public static byte[] mapsprite2 = new byte[32<<5];
    public static double[] lhheight = new double[32<<5];
    public static double[] lhhheight = new double[32<<5];
    public static double[] lhhsheight = new double[32<<5];
    public static int[] lcolumnh =new int[32<<5];

    public static int[] lluposX =new int[16];
    public static int[] lluposY = new int[16];

    public static int[] llluposX =new int[16];
    public static int[] llluposY =new int[16];

    public static boolean[] mapspritechange = new boolean[32<<5];
    public static int[] reservedSpritePixels = new int[RenderProcedure.canvasHeight<<5];

    public static void clearBuffers(){


        llhheight = new double[16];
        lllhheight = new double[16];

        lluposY = new int[16];
        lluposX = new int[16];

        llluposY = new int[16];
        llluposX = new int[16];

        mapsprite = new double[(32 << 5)];
        mapsprite2 = new byte[(32 << 5)];
        mapspritechange= new boolean[(32 << 5)];
        lheightsh= new double[(32 << 5)];
        lcolumnd= new int[(32 << 5)];
        lhheight= new double[(32 << 5)];
        lhhheight= new double[(32 << 5)];
        lcolumnh= new int[(32 << 5)];
        lfloord= new int[(32 << 5)];
        lupperd= new int[(32 << 5)];

        lhhsheight = new double[(32 << 5)];
    }
}
