package com.example.raycaster.Model.Game;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.raycaster.Controller.Input.VirtualSticks;
import com.example.raycaster.Model.Raycasting.GameLoop.RenderLoop;
import com.example.raycaster.Model.Raycasting.RenderProcedure;
import com.example.raycaster.R;
import com.example.raycaster.View.Activities.MainActivity;
import com.example.raycaster.View.Render;

public final class StartGame {

    private StartGame(){

    }

    public static void initGame(MainActivity app){


        if(!app.initized) {
            RenderProcedure.app = app;

            RenderLoop.run(app);

            app.img = app.findViewById(R.id.imageView);
            app.img.setWillNotDraw(true);

            BitmapDrawable draw = new BitmapDrawable(Render.screen);
            draw.setFilterBitmap(false);
            app.img.setImageDrawable(draw);

            app.speedCounter = (TextView) app.findViewById(R.id.textView);


            Button butt = (Button) app.findViewById(R.id.start);
            VirtualSticks stick = new VirtualSticks(app,butt,false);

            Thread thread = new Thread() {

                @Override
                public void run() {
                    try {
                        while (!isInterrupted()) {
                            Thread.sleep(200);
                            app.runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    app.updateTextView();

                                }
                            });
                        }
                    } catch (InterruptedException e) {
                    }
                }
            };

            thread.start();


            app.img.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));
            app.img.setScaleType(ImageView.ScaleType.FIT_CENTER);

            ViewGroup.LayoutParams params = (ViewGroup.LayoutParams) app.img.getLayoutParams();

            app.img.setLayoutParams(params);
            app.initized = true;
        }

    }
}
