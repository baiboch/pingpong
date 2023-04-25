package com.baiboch.pingpong;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PingPongGame extends JFrame implements ActionListener, KeyListener {

    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private final Timer timer;
    private final Paddle paddle1;
    private final Paddle paddle2;
    private final Ball ball;
    private final GamePanel gamePanel;

    public static final int GAME_PANEL_PADDING = 50;

    public PingPongGame() {
        setTitle("Pong Game");
        setSize(WIDTH, HEIGHT);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        paddle1 = new Paddle(10 + GAME_PANEL_PADDING, HEIGHT / 2 - Paddle.HEIGHT / 2, Paddle.WIDTH, Paddle.HEIGHT);
        paddle2 = new Paddle(WIDTH - Paddle.WIDTH - 10 - GAME_PANEL_PADDING, HEIGHT / 2 - Paddle.HEIGHT / 2, Paddle.WIDTH, Paddle.HEIGHT);
        ball = new Ball(WIDTH / 2 - Ball.SIZE / 2, HEIGHT / 2 - Ball.SIZE / 2, Ball.SIZE, Ball.SIZE);
        gamePanel = new GamePanel();
        add(gamePanel);
        timer = new Timer(1000 / 60, this);
        addKeyListener(this);
        setFocusable(true);
        setVisible(true);
        timer.start();
    }

    public static void main(String[] args) {
        new PingPongGame();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (ball.getY() < paddle1.getY()) {
            paddle1.setUp(true);
            paddle1.setDown(false);
        } else if (ball.getY() > paddle1.getY()) {
            paddle1.setUp(false);
            paddle1.setDown(true);
        } else {
            paddle1.setUp(false);
            paddle1.setDown(false);
        }

        paddle1.move(HEIGHT);
        paddle2.move(HEIGHT);
        ball.move(WIDTH - GAME_PANEL_PADDING, HEIGHT - GAME_PANEL_PADDING, paddle1, paddle2);
        gamePanel.repaint();
    }

    private class GamePanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            paddle1.paint(g);
            paddle2.paint(g);
            ball.paint(g);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            paddle2.setUp(true);
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            paddle2.setDown(true);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            paddle2.setUp(false);
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            paddle2.setDown(false);
        }
    }
}
