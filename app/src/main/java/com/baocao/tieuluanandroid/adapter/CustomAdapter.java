package com.baocao.tieuluanandroid.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.baocao.tieuluanandroid.DTO.SinhVien;
import com.baocao.tieuluanandroid.R;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {
    private Context context;
    private LayoutInflater inflater;
    private ArrayList<SinhVien> sinhViens;

    public CustomAdapter(Context context, ArrayList<SinhVien> sinhViens){
        this.context = context;
        this.sinhViens = sinhViens;
        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {

        return sinhViens.size();
    }

    @Override
    public Object getItem(int position) {
        return sinhViens.get(position);
    }

    @Override
    public long getItemId(int position) {
        return sinhViens.get(position).getTuoi();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null)
            convertView = inflater.inflate(R.layout.layout_item_list_view, parent, false);

        TextView tvTen = convertView.findViewById(R.id.tvTenItemListView);
        tvTen.setText(sinhViens.get(position).getTen());

        TextView tvTuoi = convertView.findViewById(R.id.tvTuoiItemListView);
        tvTuoi.setText(sinhViens.get(position).getTuoi()+"");
        return convertView;
    }
}
