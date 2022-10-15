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
import com.example.raycaster.Model.Game.StartGame;
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
    public TextView speedCounter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void updateTextView(){
        // update TextView here!
        speedCounter.setText(RenderLoopTask.delay+" ms "+width+" "+height);
    }

    public void startGame(View view){
        StartGame.initGame(this);

    }



}