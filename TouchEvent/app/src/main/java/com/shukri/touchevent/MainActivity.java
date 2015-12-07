package com.shukri.touchevent;

import android.app.Activity;
//import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.CountDownTimer;
//import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.*;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;

public class MainActivity extends Activity implements OnTouchListener{
    Button b1,b2;
    PopupWindow popUp;
    boolean f1,f2;
    boolean t;
   // String tick;
    MediaPlayer mPlayer;
    CountDownTimer timer;
    int score1=0,score2=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // Intent intent = getIntent();
        setContentView(R.layout.activity_main);
        popUp = new PopupWindow(this);
        b1=(Button)findViewById(R.id.b1);
        b2=(Button)findViewById(R.id.b2);
        b1.setOnTouchListener(this);
        b2.setOnTouchListener(this);
        mPlayer = MediaPlayer.create(this, R.raw.sound);

    }


    /*public void red(View v)
    {
        Toast.makeText(MainActivity.this, "RED Clicked", Toast.LENGTH_SHORT).show();

    }*/

   /* public void blue(View v)
    {
        Toast.makeText(MainActivity.this, "BLUE Clicked", Toast.LENGTH_SHORT).show();
    }*/

    @Override
    public boolean onTouch(View v, MotionEvent event) {

        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            t=false;
            if(v.getId()==R.id.b1) {
                b1.setText("READY");
                f1=true;
                if(f2)
                   timer= new CountDownTimer((int)(Math.random() * 8000)+1, 1000) {
                        public void onTick(long millisUntilFinished) {
                            Toast.makeText(MainActivity.this,"tick" , Toast.LENGTH_SHORT).show();
                        }
                        public void onFinish() {
                            t=true;
                            mPlayer.start();
                        }
                    }.start();
            }

            if(v.getId()==R.id.b2) {
                b2.setText("READY");
                f2=true;
                if(f1)
                   timer= new CountDownTimer((int)(Math.random() * 8000)+1, 1000) {
                        public void onTick(long millisUntilFinished) {
                            Toast.makeText(MainActivity.this,"tick" , Toast.LENGTH_SHORT).show();
                        }
                        public void onFinish() {
                            t=true;
                            mPlayer.start();
                        }
                    }.start();
            }
        }
        if (event.getAction() == MotionEvent.ACTION_UP) {
            if(f1^f2)
            {
                b1.setBackgroundColor(Color.RED);
                b2.setBackgroundColor(Color.BLUE);
                b1.setText("");
                b2.setText("");
                f1=false;
                f2=false;
            }
            if(v.getId()==R.id.b1&&f2==true&&t==false){
                timer.cancel();
                f1=false;

                b1.setText("LOST");
                score1--;
                b2.setText("WON");
                b1.setBackgroundColor(7829368);
                f2=false;
                showScore();


            }

            if(v.getId()==R.id.b2&&f1==true&&t==false){
                timer.cancel();
                f2=false;
                b2.setText("LOST");
                score2--;
                b1.setText("WON");
                b2.setBackgroundColor(7829368);
                f1=false;
                showScore();
            }
            if(t)
            {

                if(v.getId()==R.id.b1)
                {
                    f2=false;
                    b2.setText("LOST");
                    b1.setText("WON");
                    score1++;
                    b2.setBackgroundColor(7829368);
                    f1=false;
                    showScore();
                }
                if(v.getId()==R.id.b2)
                {
                    f1=false;

                    b1.setText("LOST");
                    b2.setText("WON");
                    score2++;
                    b1.setBackgroundColor(7829368);
                    f2=false;
                    showScore();
                }
                t=false;
            }

        }
        return false;
    }
    public void showScore()
    {
        LayoutInflater layoutInflater
                = (LayoutInflater)getBaseContext()
                .getSystemService(LAYOUT_INFLATER_SERVICE);
        View popupView = layoutInflater.inflate(R.layout.popup, null);
        final PopupWindow popupWindow = new PopupWindow(
                popupView,
                LayoutParams.WRAP_CONTENT,
                LayoutParams.WRAP_CONTENT);


        Button btnDismiss = (Button)popupView.findViewById(R.id.dismiss);
        TextView redScore=(TextView)popupView.findViewById(R.id.red);
        TextView blueScore=(TextView)popupView.findViewById(R.id.blue);
        redScore.setTextColor(Color.RED);
        blueScore.setTextColor(Color.BLUE);
        redScore.setText("RED  " + score1);
        blueScore.setText("BLUE  "+score2);
        btnDismiss.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                popupWindow.dismiss();
            }
        });
        popupWindow.showAtLocation(popupView, Gravity.CENTER, 0, 0);



    }

}
