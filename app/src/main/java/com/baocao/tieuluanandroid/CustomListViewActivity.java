package com.baocao.tieuluanandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.baocao.tieuluanandroid.DTO.SinhVien;
import com.baocao.tieuluanandroid.adapter.CustomAdapter;

import java.util.ArrayList;

public class CustomListViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_list_view);
        init();
    }

    private void init() {
        listView = findViewById(R.id.customListView);
        ArrayList<SinhVien> sinhViens = new ArrayList<>();
        for (int i = 0;i < 20; i++){
            sinhViens.add(new SinhVien("Sinh Vien "+i, i + 10));
        }

        CustomAdapter customAdapter = new CustomAdapter(this, sinhViens);

        listView.setAdapter(customAdapter);
    }

    private ListView listView;
}