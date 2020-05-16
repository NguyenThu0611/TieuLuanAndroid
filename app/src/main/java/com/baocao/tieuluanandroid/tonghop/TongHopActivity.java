package com.baocao.tieuluanandroid.tonghop;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;

import com.baocao.tieuluanandroid.DTO.Lop;
import com.baocao.tieuluanandroid.DTO.SinhVien;
import com.baocao.tieuluanandroid.R;
import com.baocao.tieuluanandroid.TheLoai;
import com.baocao.tieuluanandroid.adapter.CustomAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TongHopActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tong_hop);

        init();
    }

    private void init(){
        progressDialog = createProgressDialog();
        database = taoSinhViens();
        progressBar = findViewById(R.id.progressBarTH);
        progressBar.setMax(100);
        progressBar.setProgress(0);
        adapter = new CustomAdapter(this, database, R.raw.icon_user_male_50);

        //Gia lap tai du lieu cho spinner;
        progressDialog.show();
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                progressDialog.cancel();
                loadDuLieuSpinner();
            }
        }, 4000);//Gia lap tai du lieu 4 s

        ListView listView = findViewById(R.id.lvTH);
        listView.setOnItemClickListener(listViewClicked);
    }

    private void loadDuLieuSpinner(){
        Spinner spinner = findViewById(R.id.spinChonTheLoaiTH);

        //Tao Adapter cho spinner
        final List<Lop> list = new ArrayList<>();
        list.add(new Lop(1, "08DHTH1"));
        list.add(new Lop(2, "08DHTH2"));
        list.add(new Lop(3, "08DHTH3"));
        list.add(new Lop(4, "08DHTH4"));
        list.add(new Lop(5, "08DHTH5"));

        final ArrayAdapter<Lop> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, list);
        adapter.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, final int position, long id) {
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        for (int i = 0; i< 100; i++) {
                            try {
                                Thread.sleep(20);
                                progressBar.setProgress(i);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }

                        final ListView listView = findViewById(R.id.lvTH);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                TongHopActivity.this.adapter.setSinhViens(laySinhVienTheoMaLop(list.get(position).getMaLop()));
                                listView.setAdapter(TongHopActivity.this.adapter);
                            }
                        });

                        progressBar.setProgress(0);
                    }
                });
                thread.start();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private AlertDialog createProgressDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View view = getLayoutInflater().inflate(R.layout.layout_dialog_process, null);
        builder.setView(view);
        return builder.create();
    }

    private ArrayList<SinhVien> taoSinhViens(){
        ArrayList<SinhVien> sinhViens = new ArrayList<>();
        for(int i = 1; i<= 5; i++){
            for (int j = 0; j< 15; j++){
                sinhViens.add(new SinhVien(taoTen(), taoTuoi(), i));
            }
        }

        return sinhViens;
    }

    private ArrayList<SinhVien> laySinhVienTheoMaLop(int maLop){
        ArrayList<SinhVien> sinhViens = new ArrayList<>();
        for(SinhVien sv : database)
            if(sv.getLop() == maLop) {
                sinhViens.add(sv);
                Log.i("myResult", sv.toString());
            }

        return sinhViens;
    }

    private String taoTen(){
        String ten = "";
        Random rd = new Random();
        ten += hos[rd.nextInt(hos.length)];
        ten+= " "+lots[rd.nextInt(lots.length)];
        ten+= " "+tens[rd.nextInt(tens.length)];

        return ten;
    }

    private int taoTuoi(){
        return new Random().nextInt(82) + 18;
    }

    private AdapterView.OnItemClickListener listViewClicked = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Toast.makeText(TongHopActivity.this, parent.getItemAtPosition(position).toString(), Toast.LENGTH_SHORT).show();
        }
    };

    private AlertDialog progressDialog;
    private ArrayList<SinhVien> database;
    private CustomAdapter adapter;
    private ProgressBar progressBar;

    private String[] hos = {"Nguyễn", "Trần", "Lý", "La", "Đinh", "Ngô"};
    private String[] lots = {"Lê", "Hà", "Thị", "Quốc", "Xuân"};
    private String[] tens = {"Việt", "Thành", "Lâm", "Tuấn", "Chi", "Khánh", "Trường"};
}