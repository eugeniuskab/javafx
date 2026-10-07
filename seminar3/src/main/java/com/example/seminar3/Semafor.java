package com.example.seminar3;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class Semafor extends Canvas {
    private int condition = 0;
    private boolean auto = false;
    private Timeline t;

    private boolean off = false;
    private boolean blinkOrange = false;
    private GraphicsContext gc;

    public Semafor() {
        super(150, 400);
        setLayoutX(250);
        this.gc = this.getGraphicsContext2D();

        draw(Color.RED, Color.BLACK, Color.BLACK);

        setOnMousePressed(e -> {
            if (!auto && !off) {
                toggle();
            }
        });

        t = new Timeline(new KeyFrame(Duration.seconds(1), e -> {
            if (off) {
                blink();
            } else {
                toggle();
            }
        }));
        t.setCycleCount(Timeline.INDEFINITE);
    }

    public void draw(Color r, Color y, Color g) {
        gc.setFill(Color.DARKGRAY);
        gc.fillRoundRect(15, 15, 120, 360, 20, 20);

        gc.setFill(r);
        gc.fillOval(35, 30, 80, 80);

        gc.setFill(y);
        gc.fillOval(35, 140, 80, 80);

        gc.setFill(g);
        gc.fillOval(35, 250, 80, 80);
    }

    public void toggle() {
        switch (condition) {
            case 0:
                draw(Color.RED, Color.BLACK, Color.BLACK);
                condition = 1;
                break;
            case 1:
                draw(Color.RED, Color.ORANGE, Color.BLACK);
                condition = 2;
                break;
            case 2:
                draw(Color.BLACK, Color.BLACK, Color.LIMEGREEN);
                condition = 3;
                break;
            case 3:
                draw(Color.BLACK, Color.ORANGE, Color.BLACK);
                condition = 0;
                break;
        }
    }

    private void blink() {
        if (blinkOrange) {
            draw(Color.BLACK, Color.ORANGE, Color.BLACK);
        } else {
            draw(Color.BLACK, Color.BLACK, Color.BLACK);
        }
        blinkOrange = !blinkOrange;
    }

    public void changeMode() {
        if (off) return;

        if (auto) {
            t.stop();
            auto = false;
        } else {
            t.play();
            auto = true;
        }
    }

    public void toggleOnOff() {
        if (!off) {
            off = true;
            blinkOrange = true;
            t.play();
        } else {
            off = false;
            condition = 0;
            toggle();
            if (!auto) {
                t.stop();
            }
        }
    }

    public boolean isAuto() {
        return auto;
    }

    public boolean isOff() {
        return off;
    }
}
