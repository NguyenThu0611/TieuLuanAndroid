package com.baocao.tieuluanandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.baocao.tieuluanandroid.DTO.Lop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ListViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        init();
    }

    private void init(){
        listView = findViewById(R.id.listViewNormal);

        //Tao Adapter cho listview
        final List<Lop> list = new ArrayList<>();
        list.add(new Lop(1, "08DHTH1"));
        list.add(new Lop(2, "08DHTH2"));
        list.add(new Lop(3, "08DHTH3"));
        list.add(new Lop(4, "08DHTH4"));
        list.add(new Lop(5, "08DHTH5"));

        ArrayAdapter<Lop> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ListViewActivity.this, "Item: "+list.get(position), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private ListView listView;
}
