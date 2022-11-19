package com.example.rayx.Model.Raycasting;

import com.example.rayx.Model.Raycasting.GameLoop.RenderLoopTask;
import com.example.rayx.Model.Resources.Map.Map;
import com.example.rayx.RayApp;

public final class RenderInit {

    public static RenderLoopTask context;
    public static RenderProcedure render;
    public RenderInit(){

    }

    public static void start(RayApp app){

        RenderProcedure.init(app,context);

        Map.map();
    }
    public static boolean update() {

        return RenderProcedure.render();

    }
}
