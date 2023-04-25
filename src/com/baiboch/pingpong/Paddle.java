package com.baiboch.pingpong;

import java.awt.*;

import static com.baiboch.pingpong.PingPongGame.GAME_PANEL_PADDING;

public class Paddle {

    public static final int WIDTH = 15;
    public static final int HEIGHT = 100;
    private int x;
    private int y;
    private int speed = 5;
    private boolean up;
    private boolean down;

    public Paddle(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
    }

    public void move(int windowHeight) {
        if (up && y > GAME_PANEL_PADDING) {
            y -= speed;
        }
        if (down && y + HEIGHT < windowHeight - GAME_PANEL_PADDING) {
            y += speed;
        }
    }

    public void paint(Graphics g) {
        g.fillRect(x, y, WIDTH, HEIGHT);
    }

    public void setUp(boolean up) {
        this.up = up;
    }

    public void setDown(boolean down) {
        this.down = down;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return WIDTH;
    }

    public int getHeight() {
        return HEIGHT;
    }
}
