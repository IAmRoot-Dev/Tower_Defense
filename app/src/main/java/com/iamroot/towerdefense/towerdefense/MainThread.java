package com.iamroot.towerdefense.towerdefense;

import android.graphics.Canvas;
import android.view.SurfaceHolder;

public class MainThread extends Thread {
    //Sets maximum FPS to 30, so the game will not speed up on faster devices
    private int FPS = 30;
    private double averageFPS;
    private SurfaceHolder surfaceHolder;
    private GamePanel gamePanel;
    private boolean running;
    public static Canvas canvas;
    public MainThread(SurfaceHolder surfaceholder, GamePanel gamePanel) {
        super();
        this.surfaceHolder = surfaceholder;
        this.gamePanel = gamePanel;
    }
    @Override
    public void run() {
        long startTime;
        long timeMillis;
        long waitTime;
        long totalTime = 0;
        int frameCount = 0;
        long targetTime = 1000/FPS;
        while(running) {
            startTime = System.nanoTime();
            canvas = null;
            //tries locking the canvas for pixel editing
            try {
                canvas = this.surfaceHolder.lockCanvas();
                synchronized (surfaceHolder) {
                    this.gamePanel.update();
                    this.gamePanel.draw(canvas);
                }
            }
            catch(Exception e) {e.printStackTrace();}
            finally{
                if (canvas!=null) {
                    try {
                        surfaceHolder.unlockCanvasAndPost(canvas);
                    }
                    catch (Exception e){e.printStackTrace();}
                }
            }
            timeMillis = (System.nanoTime() - startTime) / 1000000;
            waitTime = targetTime-timeMillis;
            try {
                this.sleep(waitTime);
            }
            catch(Exception e){e.printStackTrace();}
            totalTime += System.nanoTime()-startTime;
            frameCount++;
            //checks FPS and sends readout to Android Monitor so we can gauge speed changes
            if(frameCount == FPS) {
                averageFPS = 1000/((totalTime/frameCount)/1000000);
                frameCount = 0;
                totalTime = 0;
                System.out.println(averageFPS);
            }
        }
    }
    public void setRunning(boolean b) {
        running=b;
    }
}