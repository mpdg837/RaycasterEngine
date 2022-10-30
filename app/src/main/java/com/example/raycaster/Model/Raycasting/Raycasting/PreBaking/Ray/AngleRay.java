package com.example.raycaster.Model.Raycasting.Raycasting.PreBaking.Ray;

import com.example.raycaster.Model.Raycasting.Raycasting.PreBaking.Math.Functions;
import com.example.raycaster.Model.Raycasting.RenderProcedure;

public final class AngleRay {


    public static int val;
    public static int dval;

    public static float sinDeltaX;
    public static float cosDeltaY;

    public static float sinPosX;
    public static float cosPosY;
    public static float cosBetaR;

    private AngleRay(){

    }
    public static void setNewAngle(float fi){
        countAngleRayProperties(fi);
    }

    private static void countAngleRayProperties(float fi){
        val = Functions.getValue(fi);
        dval = Functions.getValue(RenderProcedure.angle-fi);

        sinDeltaX = Functions.getSinDeltaX(val);
        cosDeltaY = Functions.getCosDeltaY(val);

        sinPosX = Functions.getSinPosX(val);
        cosPosY = Functions.getCosPosY(val);
        cosBetaR = Functions.getCosBetaR(dval);


    }

}
