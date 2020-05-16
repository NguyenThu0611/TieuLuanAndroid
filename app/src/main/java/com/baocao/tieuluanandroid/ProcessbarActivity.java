package com.baocao.tieuluanandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

public class ProcessbarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_processbar);

        init();
    }

    private void init(){
        Button btnTestProgress = findViewById(R.id.btnTestProgess);
        btnTestProgress.setOnClickListener(btnTestProgressClicked);
    }

    private View.OnClickListener btnTestProgressClicked = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (progressBarTron != null && progressBarTron.getVisibility() == View.VISIBLE){
                Toast.makeText(ProcessbarActivity.this, "Please Wait While process!", Toast.LENGTH_SHORT).show();
                return;
            }

            progressBarTron = findViewById(R.id.progressBarVongTron);
            progressBarNgang = findViewById(R.id.progressBarNgang);
            progressBarTron.setVisibility(View.VISIBLE);
            progressBarNgang.setMax(100);
            progressBarNgang.setProgress(0);

            process();
        }
    };

    private void process(){
        Log.i("myResult", "ok");
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0;i< 1000; i++){
                    if (i % 10 == 0){
                        progressBarNgang.setProgress(progressBarNgang.getProgress() + 1);
                    }
                    for(int j=0;j< 100;j++){
                        Log.i("myResult", i+"-"+j);
                    }
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(ProcessbarActivity.this, "Finish!", Toast.LENGTH_SHORT).show();
                        progressBarTron.setVisibility(View.GONE);
                    }
                });
            }
        });
        thread.start();
    }

    private ProgressBar progressBarNgang, progressBarTron;
}
