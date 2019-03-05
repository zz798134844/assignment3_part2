package com.example.game_animals_master;

import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;


public class GameActivity extends AppCompatActivity {
    public int time=10;
    public int score=0;
    private int Type1[] = {R.drawable.bear,R.drawable.bird,R.drawable.elephant,R.drawable.lion,R.drawable.kangaroo};
    private int Type2[] = {R.drawable.house,R.drawable.lion,R.drawable.pig,R.drawable.fish};
    private int[] m_iImageId = {R.id.imageView1, R.id.imageView2, R.id.imageView3, R.id.imageView4};
    private int m_iRightAnswerId = 0;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        Refresh();
        timer.schedule(timerTask,0,1000);
    }

    // 点击图片
    public void imageClick(View view){
        CheckAnswers(view.getId());
    }

    // 检查答案
    private void CheckAnswers(int id){
        if(id == m_iRightAnswerId){
            score+=10;
        }
        else{
            score+=0;
        }
        Refresh();
    }

    Timer timer = new Timer();
    TimerTask timerTask = new TimerTask(){
        @Override
        public void run(){
            ((TextView) findViewById(R.id.textView_time)).setText("Time:"+time+"s");
            time--;
            if(time==0) {
                timer.cancel();
                Toast.makeText(GameActivity.this, "Game Over.Congratulations! You got"+score+"score,very good!", Toast.LENGTH_SHORT).show();
            }
        }
    };

        public void Refresh() {
            Random random = new Random();
            // 生产随机答案
            int x = random.nextInt(4);
            int y = random.nextInt(5);
            int right_index = random.nextInt(4);
            m_iRightAnswerId = m_iImageId[right_index];

            if(right_index==0) {
                ((ImageView) findViewById(m_iImageId[right_index])).setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), Type2[x]));
                ((ImageView) findViewById(m_iImageId[1])).setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), Type1[y]));
                ((ImageView) findViewById(m_iImageId[2])).setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), Type1[y]));
                ((ImageView) findViewById(m_iImageId[3])).setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), Type1[y]));
            }
            if(right_index==1) {
                ((ImageView) findViewById(m_iImageId[right_index])).setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), Type2[x]));
                ((ImageView) findViewById(m_iImageId[0])).setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), Type1[y]));
                ((ImageView) findViewById(m_iImageId[2])).setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), Type1[y]));
                ((ImageView) findViewById(m_iImageId[3])).setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), Type1[y]));
            }
            if(right_index==2) {
                ((ImageView) findViewById(m_iImageId[right_index])).setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), Type2[x]));
                ((ImageView) findViewById(m_iImageId[1])).setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), Type1[y]));
                ((ImageView) findViewById(m_iImageId[0])).setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), Type1[y]));
                ((ImageView) findViewById(m_iImageId[3])).setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), Type1[y]));
            }
            if(right_index==3) {
                ((ImageView) findViewById(m_iImageId[right_index])).setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), Type2[x]));
                ((ImageView) findViewById(m_iImageId[1])).setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), Type1[y]));
                ((ImageView) findViewById(m_iImageId[2])).setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), Type1[y]));
                ((ImageView) findViewById(m_iImageId[0])).setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), Type1[y]));
            }


            ((TextView) findViewById(R.id.textView_score)).setText("Score:"+score);
    }

}
