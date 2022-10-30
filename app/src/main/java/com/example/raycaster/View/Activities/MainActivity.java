package com.example.raycaster.View.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.raycaster.Model.Game.StartGame;
import com.example.raycaster.Model.Raycasting.GameLoop.RenderLoopTask;
import com.example.raycaster.Model.Raycasting.RenderProcedure;
import com.example.raycaster.R;

public class MainActivity extends AppCompatActivity {


    public float width = 0;
    public float height = 0;
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
        speedCounter.setText(RenderLoopTask.delay+" ms "+width+" "+height+ " angle:"+ RenderProcedure.angle);
    }

    public void startGame(View view){
        StartGame.initGame(this);

    }



}