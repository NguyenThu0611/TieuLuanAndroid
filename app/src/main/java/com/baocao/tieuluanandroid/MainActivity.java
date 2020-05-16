package com.baocao.tieuluanandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init(){
        //btn spinner
        Button btnSpinner = findViewById(R.id.btnSpinner);
        btnSpinner.setOnClickListener(btnSpinnerClicked);

        //btn processbar
        Button btnProcessbar = findViewById(R.id.btnProcessBar);
        btnProcessbar.setOnClickListener(btnProcessbarClicked);

        //btn gridView
        Button btnGridView = findViewById(R.id.btnGridView);
        btnGridView.setOnClickListener(btnGridViewClicked);

        //btn listView
        Button btnlistView = findViewById(R.id.btnListView);
        btnlistView.setOnClickListener(btnlistViewClicked);

        //btn customListView
        Button btncuslistView = findViewById(R.id.btnCustomListView);
        btncuslistView.setOnClickListener(btncuslistViewClicked);
    }

    //su kien cho spinner
    private View.OnClickListener btnSpinnerClicked = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(MainActivity.this, SpinnerActivity.class);
            startActivity(intent);
        }
    };

    //su kien cho processbar
    private View.OnClickListener btnProcessbarClicked = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(MainActivity.this, ProcessbarActivity.class);
            startActivity(intent);
        }
    };

    //su kien cho gridView
    private View.OnClickListener btnGridViewClicked = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(MainActivity.this, GridViewActivity.class);
            startActivity(intent);
        }
    };

    //su kien cho listView
    private View.OnClickListener btnlistViewClicked = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(MainActivity.this, ListViewActivity.class);
            startActivity(intent);
        }
    };

    //su kien cho cuslistView
    private View.OnClickListener btncuslistViewClicked = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(MainActivity.this, CustomListViewActivity.class);
            startActivity(intent);
        }
    };
}