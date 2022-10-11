package com.example.raycaster.Model.Raycasting.Raycasting.PreBaking.Ray;

import com.example.raycaster.Model.Raycasting.Raycasting.PreBaking.Math.Functions;
import com.example.raycaster.Model.Raycasting.RenderProcedure;

public final class AngleRay {

    public AngleRay(double fi){
        countAngleRayProperties(fi);
    }
    public static int val;
    public static int dval;

    public static double sinDeltaX;
    public static double cosDeltaY;

    public static double sinPosX;
    public static double cosPosY;
    public static double cosBetaR;

    private static void countAngleRayProperties(double fi){
        val = Functions.getValue(fi);
        dval = Functions.getValue(RenderProcedure.angle-fi);

        sinDeltaX = Functions.getSinDeltaX(val);
        cosDeltaY = Functions.getCosDeltaY(val);

        sinPosX = Functions.getSinPosX(val);
        cosPosY = Functions.getCosPosY(val);
        cosBetaR = Functions.getCosBetaR(dval);


    }

}
