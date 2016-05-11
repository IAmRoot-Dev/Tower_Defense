package com.iamroot.towerdefense.towerdefense;

import android.content.Context;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class GamePanel extends SurfaceView implements SurfaceHolder.Callback {
    private MainThread thread;
    public GamePanel(Context context) {
        super(context);
        //adds the callback to the surfaceholder to intercept events
        getHolder().addCallback(this);
        thread = new MainThread(getHolder(), this);
        //makes gamePanel focusable so it can handle events
        setFocusable(true);
    }
    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height){}
    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        boolean retry = true;
        while(retry) {
            try {thread.setRunning(false);
                thread.join();
            }catch(InterruptedException e){e.printStackTrace();}
            retry = false;
        }
    }
    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        //starts the game loop
        thread.setRunning(true);
        thread.start();
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
    }
    public void update(){}
}