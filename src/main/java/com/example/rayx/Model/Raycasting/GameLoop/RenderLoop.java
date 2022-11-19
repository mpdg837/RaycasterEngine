package com.example.rayx.Model.Raycasting.GameLoop;

import com.example.rayx.Model.Raycasting.RenderInit;
import com.example.rayx.RayApp;
import com.example.rayx.View.Render;

import java.util.Timer;

public final class RenderLoop {

    static RenderInit renderer = new RenderInit();
    static Timer tim = new Timer();

    public static void run(RayApp app){


            RenderLoopTask task = new RenderLoopTask(renderer,0);

            RenderInit.start(app);

            Render.initscreen();
            task.setPriority(Thread.MAX_PRIORITY);
            task.start();


    }
}