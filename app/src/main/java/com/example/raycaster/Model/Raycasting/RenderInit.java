package com.example.raycaster.Model.Raycasting;

import com.example.raycaster.View.Activities.MainActivity;
import com.example.raycaster.Model.Raycasting.GameLoop.RenderLoopTask;
import com.example.raycaster.Model.Resources.Map.Map;

public final class RenderInit {

    public static RenderLoopTask context;
    public static RenderProcedure render;


    public RenderInit(){

    }

    public static void start(MainActivity app){

        try {
            render = new RenderProcedure(app,context);
        }catch (Exception ignore){

        }
        Map.map();
    }
    public static boolean update() {
        if(render!=null) {
            return RenderProcedure.render();
        }else{
            return false;
        }
    }
}
