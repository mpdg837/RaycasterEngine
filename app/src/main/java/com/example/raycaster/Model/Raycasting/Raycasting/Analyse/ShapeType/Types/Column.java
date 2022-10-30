package com.example.raycaster.Model.Raycasting.Raycasting.Analyse.ShapeType.Types;

import com.example.raycaster.Model.Raycasting.Raycasting.Analyse.ShapeType.ShapeType;
import com.example.raycaster.Model.Raycasting.Raycasting.PreBaking.Ray.PointOnRay;

public final class Column extends ShapeType {

    private final static int min = 16;
    private final static int max = 48;

    public static final int typeIndex = 11;
    private Column(){

    }

    public static boolean isInShape(){
        boolean inX = PointOnRay.intdeltaPosX > min && PointOnRay.intdeltaPosX < max;
        boolean inY = PointOnRay.intdeltaPosY > min && PointOnRay.intdeltaPosY < max;

        int aintX = PointOnRay.intdeltaPosX - 32;
        int aintY = PointOnRay.intdeltaPosY - 32;

        int fun = aintX * aintX + aintY * aintY;

        boolean inZ = fun < 256;

        return inX && inY && inZ;
    }
}
