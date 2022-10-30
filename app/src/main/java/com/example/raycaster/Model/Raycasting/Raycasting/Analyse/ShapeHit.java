package com.example.raycaster.Model.Raycasting.Raycasting.Analyse;

import com.example.raycaster.Model.Raycasting.Raycasting.Analyse.ShapeType.Types.Column;
import com.example.raycaster.Model.Raycasting.Raycasting.PreBaking.Ray.PointOnRay;

public final class ShapeHit extends Hit{

    public static boolean inX1;
    public static boolean inX2;

    public static boolean inY1;
    public static boolean inY2;

    private final static int min = 16;
    private final static int max = 48;

    private ShapeHit(){

    }

    public static boolean isInShape(){
        return Column.isInShape();
    }

    public static void analyse(){
        inX1 = (PointOnRay.intdeltaPosX == min && PointOnRay.lintdeltaPosX != min);
        inX2 = (PointOnRay.intdeltaPosY == min && PointOnRay.lintdeltaPosY != min);

        inY1 = (PointOnRay.intdeltaPosY == min && PointOnRay.lintdeltaPosY != min);
        inY2 = (PointOnRay.intdeltaPosY== max && PointOnRay.lintdeltaPosY!=max);
    }
}
