package com.example.raycaster.Model.Raycasting.Raycasting.PreBaking.Math;

public final class Functions {

    final static  int length = 62832 * 2;
    final static  double[] sinDeltaX = new double[length];
    final static  double[] cosDeltaY = new double[length];

    final static  double[] sinPosX = new double[length];
    final static  double[] cosPosY = new double[length];

    final static  double[] cosBetaR = new double[length];

    final static  double[] tan = new double[length];

    final static  int[] sqrt = new int[32*32*1000];
    public static void precount(double deltaRaycasterStep, double raycasterStep) {
        for (double fi = -6.2832f; fi < 6.2832; fi+=0.0001) {
            int n=getValue(fi);

            sinDeltaX[n] = (double) Math.sin(fi) * deltaRaycasterStep;
            cosDeltaY[n] = (double)Math.cos(fi) * deltaRaycasterStep;

            sinPosX[n] = (double)Math.sin(fi) * raycasterStep;
            cosPosY[n] =(double) Math.cos(fi) * raycasterStep;
            cosBetaR[n] = (double)Math.cos(fi) * raycasterStep;

            tan[n] = (double)Math.tan(fi);
        }

        for (double fi = 0; fi < 32*32; fi+=0.001) {
            int n=(int)(fi*(double) 1000);
            sqrt[n] = (int)(Math.sqrt(fi)/(double)22*(double) 31);
        }
    }
    public static int getValue(double val){
        return (int)((val + 6.2832)*(double) 10000);
    }
    public static double getSinDeltaX(int angle){
        return sinDeltaX[(angle)];
    }

    public static  int getSqrt(double val){
        return sqrt[(int)(val*1000)];
    }

    public static double getCosDeltaY(int angle){
        return cosDeltaY[angle];
    }

    public static  double getSinPosX(int angle){
        return sinPosX[angle];
    }

    public static  double getCosPosY(int angle){
        return cosPosY[angle];
    }

    public static  double getCosBetaR(int angle){
        return cosBetaR[angle];
    }

    public static  double getTan(int angle){return tan[angle];}
}
