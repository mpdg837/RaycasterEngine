package com.example.rayx.Model.Raycasting.Raycasting.PreBaking.Math;

public final class Functions {

    final static  int length = 6283 * 2;
    final static  float[] sinDeltaX = new float[length];
    final static  float[] cosDeltaY = new float[length];

    final static  float[] sinPosX = new float[length];
    final static  float[] cosPosY = new float[length];

    final static  float[] cosBetaR = new float[length];

    final static  float[] tan = new float[length];

    final static  int[] sqrt = new int[32*32*1000];

    private Functions(){

    }

    public static void precount(float deltaRaycasterStep, float raycasterStep) {
        for (double fi = -6.283; fi < 6.283; fi+=0.001) {
            int n=getValue(fi);

            sinDeltaX[n] = (float) ((double)Math.sin(fi) *  (double)deltaRaycasterStep);
            cosDeltaY[n] = (float) ((double)Math.cos(fi) *  (double)deltaRaycasterStep);

            sinPosX[n] = (float) ((double)Math.sin(fi) *  (double)raycasterStep);
            cosPosY[n] =(float)  ((double)Math.cos(fi) *  (double)raycasterStep);
            cosBetaR[n] = (float) ((double)Math.cos(fi) *  (double)raycasterStep);

            tan[n] = (float) ((double)Math.tan(fi));
        }

        for (float fi = 0; fi < 32*32; fi+=0.001) {
            int n=(int)(fi*(float) 1000);
            sqrt[n] = (int)(Math.sqrt(fi)/(float)22*(float) 31);
        }
    }
    public static int getValue(double val){
        int nval = (int)((val + 6.283)*(double) 1000);
        return nval >= 0 ? nval : 0;
    }
    public static float getSinDeltaX(int angle){
        return sinDeltaX[(angle)];
    }

    public static  int getSqrt(float val){
        return sqrt[(int)(val*1000)];
    }

    public static float getCosDeltaY(int angle){
        return cosDeltaY[angle];
    }

    public static  float getSinPosX(int angle){
        return sinPosX[angle];
    }

    public static  float getCosPosY(int angle){
        return cosPosY[angle];
    }

    public static  float getCosBetaR(int angle){
        return cosBetaR[angle];
    }

    public static  float getTan(int angle){return tan[angle];}
}
