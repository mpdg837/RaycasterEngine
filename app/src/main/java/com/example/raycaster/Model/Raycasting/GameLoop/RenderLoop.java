package com.example.raycaster.Model.Raycasting.GameLoop;

import com.example.raycaster.View.Activities.MainActivity;
import com.example.raycaster.View.Render;
import com.example.raycaster.Model.Raycasting.RenderInit;

import java.util.Timer;

public final class RenderLoop {

    static RenderInit renderer = new RenderInit();
    static Timer tim = new Timer();

    public static void run(MainActivity app){


            RenderLoopTask task = new RenderLoopTask(renderer,0);

            RenderInit.start(app);


            Render.initscreen();
            task.setPriority(Thread.MAX_PRIORITY);
            task.start();


    }
}