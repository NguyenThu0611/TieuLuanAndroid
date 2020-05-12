package com.baocao.tieuluanandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class SpinnerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);
        init();
    }

    private void init() {
        Spinner spinner = findViewById(R.id.spinner);

        //Tao Adapter cho spinner
        final List<TheLoai> list = new ArrayList<>();
        list.add(new TheLoai(1, "Viet"));
        list.add(new TheLoai(2, "Truong"));
        list.add(new TheLoai(3, "Thu"));

        ArrayAdapter<TheLoai> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, list);
        adapter.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        spinner.setAdapter(adapter);

        //event
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                TheLoai itemSelected = list.get(position);
                Toast.makeText(SpinnerActivity.this, "Your choice: "+itemSelected.getMaLoai(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
