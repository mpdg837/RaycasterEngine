package com.example.rayx.Model.Raycasting.GameLoop;

import com.example.rayx.Model.Raycasting.RenderInit;

public final class RenderLoopTask extends Thread {

    public static int delay = 0;
    public static RenderInit task;
    public static final int FRAME_DELAY =16;
    public static final long MILLION = 1000000;

    int n;

    private static int countDelay(long start,long stop){
        return (int) ((stop - start) / (int) MILLION);
    }
    public RenderLoopTask(RenderInit renderer,int n){
        this.n = n;

        task = renderer;
        RenderInit.context = this;
    }

    public static void waitMe(int interval){
        long start = System.nanoTime();
        long stop = start;
        while ( countDelay(start,stop)< interval){
            stop = System.nanoTime();
        }

    }
    @Override
    public void run() {


        waitMe(RenderLoopTask.FRAME_DELAY);

        while(true) {

            int diff;

                long start = System.nanoTime();

                RenderInit.update();

                long stop = System.nanoTime();
                int delay = countDelay(start,stop);

                diff = RenderLoopTask.FRAME_DELAY - delay;

                if (delay > FRAME_DELAY) {
                    RenderLoopTask.delay = FRAME_DELAY - diff;
                } else {
                    RenderLoopTask.delay = FRAME_DELAY;
                }

                if(diff>0){
                    waitMe(diff);
                }
        }

    }

}
