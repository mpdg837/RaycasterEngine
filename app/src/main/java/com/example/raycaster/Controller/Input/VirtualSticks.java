package com.example.raycaster.Controller.Input;

import android.annotation.SuppressLint;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;


import com.example.raycaster.View.Activities.MainActivity;
import com.example.raycaster.Model.Game.Moving;

class MovingStickDetect implements View.OnTouchListener {

    private VirtualSticks stick;
    private boolean rotation;
    public MovingStickDetect(VirtualSticks sticks,boolean rotation){
        this.rotation = rotation;
        this.stick = sticks;
    }

    private float countTranslateValue(float value){

        if(value>1){
            value = 1;
        }else if(value<-1){
            value = -1;
        }

        if(value<0.25 && value > -0.25){
            value = 0;
        }

        value *= stick.power;

        return value;
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {


        DisplayMetrics metrics = stick.app.getResources().getDisplayMetrics();

        float width = 0;
        float height = 0;
        int dY =  stick.butt.getMeasuredHeightAndState()/2;
        int dX = stick.butt.getMeasuredWidthAndState()/2;

        if(motionEvent.getAction() == MotionEvent.ACTION_MOVE) {
            width = (float) (motionEvent.getX() - dX)/(float) dX;
            height = (float) (motionEvent.getY() - dY)/(float) dY;

            width = countTranslateValue(width);
            height = countTranslateValue(height);

        }else{
            width = 0;
            height = 0;
        }


            Moving.dAngle = width/10;

        if(height!=0) {
            if (height * stick.power > 0.9 || height * stick.power < -0.9) {
                Moving.trnsY = 0;
            } else {
                if (height > 0) {
                    Moving.trnsY = -0.02f;
                } else {
                    Moving.trnsY = 0.02f;
                }
            }
        }else{
            Moving.trnsY = 0;
        }

        if(width!=0) {
            if (width * stick.power > 0.9 || width * stick.power < -0.9) {
                Moving.dAngle = 0;
            } else {
                if (width > 0) {
                    Moving.dAngle = 0.03f;
                } else {
                    Moving.dAngle = -0.03f;
                }
            }
        }else{
            Moving.dAngle = 0;
        }

        return false;
    }
}
public class VirtualSticks {

    float power = 0.4f;

    protected MainActivity app;
    protected Button butt;

    @SuppressLint("ClickableViewAccessibility")
    public VirtualSticks(MainActivity app, Button butt,boolean rotation){
        this.butt = butt;
        this.app = app;

        MovingStickDetect dstick = new MovingStickDetect(this,rotation);

        this.butt.setOnTouchListener(dstick);


    }

}
