package com.baocao.tieuluanandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
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
        btnClick = findViewById(R.id.btnClick);
        spinner = findViewById(R.id.spinner);

        btnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Ok", Toast.LENGTH_SHORT).show();
                Toast.makeText(MainActivity.this, "Ok Vu Truong", Toast.LENGTH_SHORT).show();
            }
        });

        //nap du lieu cho spinner;
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        list.add("6");
        list.add("7");
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, list);
        adapter.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        spinner.setAdapter(adapter);
    }

    private void viet(){
        Toast.makeText(this, "123", Toast.LENGTH_SHORT).show();
    }

    private void viet1(){

        Toast.makeText(this, "123", Toast.LENGTH_SHORT).show();
    }

    private void viet2(){

        Toast.makeText(this, "123", Toast.LENGTH_SHORT).show();
    }

    //control
    private Button btnClick;
    private Spinner spinner;

    private void Thu(){
        Toast.makeText(this, "Thu", Toast.LENGTH_SHORT).show();
    }

    private void Thu1(){
        Toast.makeText(this, "Thu", Toast.LENGTH_SHORT).show();
    }
    private int test1;

    private int test2;
    
    //truong
    private void truongHam(){
        Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
    }
}