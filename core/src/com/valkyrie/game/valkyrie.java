package com.valkyrie.game;

//Naci Burak KARABULUT
//Bahtiyar Ali ALHAS
//Kutay Cavusoglu
//Utku Berk Simsek

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Intersector;

import java.util.Random;

public class valkyrie extends ApplicationAdapter {

    SpriteBatch batch;
    Texture background;
    Texture ufo;
    Texture meteor1;
    Texture meteor2;
    Texture meteor3;
    float ufoX = 0;
    float ufoY = 0;
    int gameState = 0;
    float velocity = 0;
    float gravity = 0.1f;
    float enemyVelocity = 2;
    Random random;
    int score = 0;
    int scoredEnemy = 0;
    BitmapFont play;
    BitmapFont font;
    BitmapFont font2;


    Circle ufoCircle;

    ShapeRenderer shapeRenderer;

    int numberOfEnemies = 5;
    float[] enemyX = new float[numberOfEnemies];
    float[] enemyOffSet = new float[numberOfEnemies];
    float[] enemyOffSet2 = new float[numberOfEnemies];
    float[] enemyOffSet3 = new float[numberOfEnemies];
    float distance;

    Circle[] enemyCircles;
    Circle[] enemyCircles2;
    Circle[] enemyCircles3;


    @Override
    public void create() {
        batch = new SpriteBatch();
        background = new Texture("background.png");
        ufo = new Texture("ufo.png");
        meteor1 = new Texture("meteor.png");
        meteor2 = new Texture("meteor.png");
        meteor3 = new Texture("meteor.png");

        distance = Gdx.graphics.getWidth() / 2f;
        random = new Random();

        ufoX = Gdx.graphics.getWidth() / 2f - ufo.getHeight() / 2f;
        ufoY = Gdx.graphics.getHeight() / 3f;

        shapeRenderer = new ShapeRenderer();

        ufoCircle = new Circle();
        enemyCircles = new Circle[numberOfEnemies];
        enemyCircles2 = new Circle[numberOfEnemies];
        enemyCircles3 = new Circle[numberOfEnemies];

        //TAP TO PLAY
        play = new BitmapFont();
        play.setColor(Color.GREEN);
        play.getData().setScale(6f);


        //SCORE BOARD STYLE
        font = new BitmapFont();
        font.setColor(Color.RED);
        font.getData().setScale(4);

        //GAME OVER STYLE
        font2 = new BitmapFont();
        font2.setColor(Color.RED);
        font2.getData().setScale(6f);


        //NUMBER OF ENEMY
        for (int i = 0; i < numberOfEnemies; i++) {

            enemyOffSet[i] = (random.nextFloat() - 0.5f) * (Gdx.graphics.getHeight() - 200);
            enemyOffSet2[i] = (random.nextFloat() - 0.5f) * (Gdx.graphics.getHeight() - 200);
            enemyOffSet3[i] = (random.nextFloat() - 0.5f) * (Gdx.graphics.getHeight() - 200);

            enemyX[i] = Gdx.graphics.getWidth() - meteor1.getWidth() / 2f + i * distance;


            enemyCircles[i] = new Circle();
            enemyCircles2[i] = new Circle();
            enemyCircles3[i] = new Circle();

        }

    }

    @Override
    public void render() {
        batch.begin();
        batch.draw(background, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        if (gameState == 1) {

            if (enemyX[scoredEnemy] < Gdx.graphics.getWidth() / 2f - ufo.getHeight() / 2f) {
                score++;
                enemyVelocity += 0.2;

                if (scoredEnemy < numberOfEnemies - 1) {
                    scoredEnemy++;
                } else {
                    scoredEnemy = 0;
                }

            }


            if (Gdx.input.justTouched()) {

                //higher jump if decrease
                velocity = -5;

            }


            for (int i = 0; i < numberOfEnemies; i++) {


                //METEOR POSITIONS
                if (enemyX[i] < Gdx.graphics.getWidth() / 15f) {
                    enemyX[i] = enemyX[i] + numberOfEnemies * distance;

                    enemyOffSet[i] = (random.nextFloat() - 0.5f) * (Gdx.graphics.getHeight() - 200);
                    enemyOffSet2[i] = (random.nextFloat() - 0.5f) * (Gdx.graphics.getHeight() - 200);
                    enemyOffSet3[i] = (random.nextFloat() - 0.5f) * (Gdx.graphics.getHeight() - 200);


                } else {
                    enemyX[i] = enemyX[i] - enemyVelocity;
                }


                batch.draw(meteor1, enemyX[i], Gdx.graphics.getHeight() / 2f + enemyOffSet2[i], Gdx.graphics.getWidth() / 10f, Gdx.graphics.getHeight() / 7f);
                batch.draw(meteor2, enemyX[i], Gdx.graphics.getHeight() / 2f + enemyOffSet3[i], Gdx.graphics.getWidth() / 10f, Gdx.graphics.getHeight() / 7f);
                batch.draw(meteor3, enemyX[i], Gdx.graphics.getHeight() / 2f + enemyOffSet[i], Gdx.graphics.getWidth() / 10f, Gdx.graphics.getHeight() / 7f);


                enemyCircles[i] = new Circle(enemyX[i] + Gdx.graphics.getWidth() / 30f, Gdx.graphics.getHeight() / 2f + enemyOffSet[i] + Gdx.graphics.getHeight() / 20f, Gdx.graphics.getWidth() / 30f);
                enemyCircles2[i] = new Circle(enemyX[i] + Gdx.graphics.getWidth() / 30f, Gdx.graphics.getHeight() / 2f + enemyOffSet2[i] + Gdx.graphics.getHeight() / 20f, Gdx.graphics.getWidth() / 30f);
                enemyCircles3[i] = new Circle(enemyX[i] + Gdx.graphics.getWidth() / 30f, Gdx.graphics.getHeight() / 2f + enemyOffSet3[i] + Gdx.graphics.getHeight() / 20f, Gdx.graphics.getWidth() / 30f);

            }

            if (ufoY > Gdx.graphics.getHeight() / 1.1) {
                ufoY = Gdx.graphics.getHeight() / 1.125f;
                velocity = 0;

            }
            if (ufoY > 0) {
                velocity = velocity + gravity;
                ufoY = ufoY - velocity;

            } else {
                gameState = 2;
            }


        } else if (gameState == 0) {
            play.draw(batch, "Tap to Play", Gdx.graphics.getWidth() / 2.5f, Gdx.graphics.getHeight() / 2f);

            if (Gdx.input.justTouched()) {
                enemyVelocity = 2;
                gameState = 1;
            }
        } else if (gameState == 2) {

            font2.draw(batch, "Game Over! Tap To Play Again!", Gdx.graphics.getWidth() / 6f, Gdx.graphics.getHeight() / 2f);

            if (Gdx.input.justTouched()) {
                gameState = 1;
                enemyVelocity = 2;
                ufoY = Gdx.graphics.getHeight() / 2f;


                for (int i = 0; i < numberOfEnemies; i++) {


                    enemyOffSet[i] = (random.nextFloat() - 0.5f) * (Gdx.graphics.getHeight() - 200);
                    enemyOffSet2[i] = (random.nextFloat() - 0.5f) * (Gdx.graphics.getHeight() - 200);
                    enemyOffSet3[i] = (random.nextFloat() - 0.5f) * (Gdx.graphics.getHeight() - 200);

                    enemyX[i] = Gdx.graphics.getWidth() - meteor1.getWidth() / 2f + i * distance;


                    enemyCircles[i] = new Circle();
                    enemyCircles2[i] = new Circle();
                    enemyCircles3[i] = new Circle();

                }

                velocity = 0;
                scoredEnemy = 0;
                score = 0;

            }
        }


        batch.draw(ufo, ufoX, ufoY, Gdx.graphics.getWidth() / 15f, Gdx.graphics.getHeight() / 10f);

        font.draw(batch, String.valueOf(score), 100, 200);

        batch.end();

        ufoCircle.set(ufoX + Gdx.graphics.getWidth() / 30f, ufoY + Gdx.graphics.getHeight() / 20f, Gdx.graphics.getWidth() / 30f);


        for (int i = 0; i < numberOfEnemies; i++) {

            if (Intersector.overlaps(ufoCircle, enemyCircles[i]) || Intersector.overlaps(ufoCircle, enemyCircles2[i]) || Intersector.overlaps(ufoCircle, enemyCircles3[i])) {
                gameState = 2;
            }
        }

    }

    @Override
    public void dispose() {

    }
}