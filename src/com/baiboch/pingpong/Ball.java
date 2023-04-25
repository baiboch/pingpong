package com.baiboch.pingpong;

import java.awt.*;

import static com.baiboch.pingpong.PingPongGame.GAME_PANEL_PADDING;

public class Ball {

    public static final int SIZE = 20;
    private int x;
    private int y;
    private int width;
    private int height;
    private int xSpeed = 3;
    private int ySpeed = 2;

    public Ball(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void move(int windowWidth, int windowHeight, Paddle paddle1, Paddle paddle2) {
        if (x < GAME_PANEL_PADDING || x + width > windowWidth || (collides(paddle1) || collides(paddle2))) {
            xSpeed = -xSpeed;
        }
        if (y < GAME_PANEL_PADDING || y + height > windowHeight) {
            ySpeed = -ySpeed;
        }
        x += xSpeed;
        y += ySpeed;
    }

    private boolean collides(Paddle paddle) {
        return x + width > paddle.getX() && x < paddle.getX() + paddle.getWidth() &&
                y + height > paddle.getY() && y < paddle.getY() + paddle.getHeight();
    }

    public void paint(Graphics g) {
        g.fillOval(x, y, width, height);
    }
}
