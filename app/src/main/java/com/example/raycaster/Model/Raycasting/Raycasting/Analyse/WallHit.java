package com.example.raycaster.Model.Raycasting.Raycasting.Analyse;

import com.example.raycaster.Model.Raycasting.Raycasting.PreBaking.Ray.PointOnRay;

public final class WallHit {

    public static boolean pX;
    public static boolean pY;

    public static boolean pY1;
    public static boolean pY2;
    public static boolean pX1;

    private WallHit(){

    }
    public static void analysePotentionalHit(){
        pX = (PointOnRay.lposX == (int) PointOnRay.posX);
        pY = (PointOnRay.lposY == (int) PointOnRay.posY);

        pY1 = (PointOnRay.lposY == (int) PointOnRay.posY - 1);
        pY2 = (PointOnRay.lposY == (int) PointOnRay.posY + 1);
        pX1 = (PointOnRay.lposX == (int) PointOnRay.posX - 1) && pY;
    }
}
