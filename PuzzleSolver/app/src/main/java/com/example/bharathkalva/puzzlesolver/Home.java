package com.example.bharathkalva.puzzlesolver;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class Home extends Activity {
    Button Sudoku;
    Button Boggle;
    Button Anagram;
    Button Settings;
    Button Rubiks;
    ImageView ISudoku;
    ImageView IBoggle;
    ImageView IAnagram;
    ImageView IRubiks;
    ImageView ISettings;
    Button Go;
    Button Home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
        setContentView(R.layout.options);
        Sudoku = (Button)findViewById(R.id.ButtonSudoku);
        Boggle = (Button)findViewById(R.id.ButtonBoggle);
        Anagram = (Button)findViewById(R.id.ButtonAnagram);
        Rubiks = (Button)findViewById(R.id.ButtonRubiks);
        Settings = (Button)findViewById(R.id.ButtonSettings);
        ISudoku = (ImageView)findViewById(R.id.ImageViewSudoku);
        IBoggle = (ImageView)findViewById(R.id.ImageViewBoggle);
        IAnagram = (ImageView)findViewById(R.id.ImageViewAnagram);
        IRubiks = (ImageView)findViewById(R.id.ImageViewRubiks);
        ISettings = (ImageView)findViewById(R.id.ImageViewSettings);
        Go = (Button)findViewById(R.id.ButtonSetting);
        Home = (Button)findViewById(R.id.ButtonHome);
        Typeface Lightfont = Typeface.createFromAsset(getAssets(),"fonts/Aileron-Light.otf");
        Settings.setTypeface(Lightfont);
        Sudoku.setTypeface(Lightfont);
        Boggle.setTypeface(Lightfont);
        Anagram.setTypeface(Lightfont);
        Settings.setTypeface(Lightfont);
        Rubiks.setTypeface(Lightfont);
        setOnClickListeners();
    }
    private void moveOptions(int position){
        Animation animation11 = AnimationUtils.loadAnimation(getApplication(), R.anim.translate11);
        Animation animation12 = AnimationUtils.loadAnimation(getApplication(),R.anim.translate12);
        Animation animation21 = AnimationUtils.loadAnimation(getApplication(),R.anim.translate21);
        Animation animation22 = AnimationUtils.loadAnimation(getApplication(),R.anim.translate22);
        Animation animation31 = AnimationUtils.loadAnimation(getApplication(),R.anim.translate31);
        Animation animation32 = AnimationUtils.loadAnimation(getApplication(),R.anim.translate32);
        Animation animation41 = AnimationUtils.loadAnimation(getApplication(),R.anim.translate41);
        Animation animation42 = AnimationUtils.loadAnimation(getApplication(),R.anim.translate42);
        if(position == 1){
            ISettings.startAnimation(animation11);
            Settings.startAnimation(animation12);
            IRubiks.startAnimation(animation21);
            Rubiks.startAnimation(animation22);
            IAnagram.startAnimation(animation31);
            Anagram.startAnimation(animation32);
            IBoggle.startAnimation(animation41);
            Boggle.startAnimation(animation42);
        }
        if(position == 2){
            ISettings.startAnimation(animation11);
            Settings.startAnimation(animation12);
            IRubiks.startAnimation(animation21);
            Rubiks.startAnimation(animation22);
            IAnagram.startAnimation(animation31);
            Anagram.startAnimation(animation32);
            ISudoku.startAnimation(animation41);
            Sudoku.startAnimation(animation42);
        }
        if(position == 3){
            ISettings.startAnimation(animation11);
            Settings.startAnimation(animation12);
            IRubiks.startAnimation(animation21);
            Rubiks.startAnimation(animation22);
            IBoggle.startAnimation(animation31);
            Boggle.startAnimation(animation32);
            ISudoku.startAnimation(animation41);
            Sudoku.startAnimation(animation42);
        }
        if(position == 4){
            ISettings.startAnimation(animation11);
            Settings.startAnimation(animation12);
            IAnagram.startAnimation(animation21);
            Anagram.startAnimation(animation22);
            IBoggle.startAnimation(animation31);
            Boggle.startAnimation(animation32);
            ISudoku.startAnimation(animation41);
            Sudoku.startAnimation(animation42);
        }
        if(position == 5){
            IRubiks.startAnimation(animation11);
            Rubiks.startAnimation(animation12);
            IAnagram.startAnimation(animation21);
            Anagram.startAnimation(animation22);
            IBoggle.startAnimation(animation31);
            Boggle.startAnimation(animation32);
            ISudoku.startAnimation(animation41);
            Sudoku.startAnimation(animation42);
        }
    }
    private void setOnClickListeners() {
        Sudoku.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveOptions(1);
                Thread timer = new Thread() {
                    public void run() {
                        try {
                            sleep(1000);
                            Intent intent = new Intent(Home.this, Start.class);
                            startActivity(intent);
                            overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                };
                timer.start();
            }
        });
        Boggle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveOptions(2);
                Thread timer = new Thread() {
                    public void run() {
                        try {
                            sleep(1000);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        Intent intent = new Intent(Home.this, BoggleGame.class);
                        startActivity(intent);
                        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                    }
                };
                timer.start();
            }
        });
        Anagram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveOptions(3);
                Thread timer = new Thread() {
                    public void run() {
                        try {
                            sleep(1000);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        Intent intent = new Intent(Home.this, Anagram.class);
                        startActivity(intent);
                        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                    }
                };
                timer.start();
            }
        });
        Rubiks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveOptions(4);
                Thread timer = new Thread(){
                    public void run(){
                        try {
                            sleep(1000);
                        } catch (Exception e){
                            e.printStackTrace();
                        }
                        Intent intent = new Intent(Home.this, Home.class);
                        startActivity(intent);
                        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                    }
                };
                timer.start();
            }
        });
        Settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveOptions(5);
                Thread timer = new Thread(){
                    public void run(){
                        try {
                            sleep(1000);
                        } catch (Exception e){
                            e.printStackTrace();
                        }
                        Intent intent = new Intent(Home.this, Home.class);
                        startActivity(intent);
                        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                    }
                };
                timer.start();
            }
        });
        Home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this,Home.class);
                startActivity(intent);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }
        });
        Go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this,Home.class);
                startActivity(intent);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }
        });
    }
}
