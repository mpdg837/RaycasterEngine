package com.example.raycaster.View.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.raycaster.Controller.Input.VirtualSticks;
import com.example.raycaster.Model.Raycasting.GameLoop.RenderLoop;
import com.example.raycaster.Model.Raycasting.GameLoop.RenderLoopTask;
import com.example.raycaster.Model.Raycasting.RenderProcedure;
import com.example.raycaster.R;
import com.example.raycaster.View.Render;

public class MainActivity extends AppCompatActivity {


    public double width = 0;
    public double height = 0;
    public boolean initized = false;

    public int value;

    public ImageView img;
    TextView speedCounter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(!initized) {
            RenderProcedure.app = this;

            RenderLoop.run(this);

            img = RenderProcedure.app.findViewById(R.id.imageView);
            img.setWillNotDraw(true);
            img.setImageBitmap(Render.screen);

            speedCounter = (TextView) this.findViewById(R.id.textView);


            Button butt = (Button) this.findViewById(R.id.start);
            VirtualSticks stick = new VirtualSticks(this,butt,false);

            Thread thread = new Thread() {

                @Override
                public void run() {
                    try {
                        while (!isInterrupted()) {
                            Thread.sleep(200);
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    updateTextView();

                                }
                            });
                        }
                    } catch (InterruptedException e) {
                    }
                }
            };

            thread.start();


            img.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));
            img.setScaleType(ImageView.ScaleType.FIT_XY);

            ViewGroup.LayoutParams params = (ViewGroup.LayoutParams) img.getLayoutParams();

            img.setLayoutParams(params);
            initized = true;
        }

    }

    private void updateTextView(){
        // update TextView here!
        speedCounter.setText(RenderLoopTask.delay+" ms "+width+" "+height);
    }
    public void startGame(View view){


    }



}