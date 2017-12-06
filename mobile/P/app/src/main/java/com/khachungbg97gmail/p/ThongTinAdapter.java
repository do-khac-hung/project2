package com.khachungbg97gmail.p;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ASUS on 12/5/2017.
 */

public class ThongTinAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<ThongTin> thongTinListList;
    private ArrayList<ThongTin> arrayList;

    public ThongTinAdapter(Context context, int layout, List<ThongTin> thongTinListList) {
        this.context = context;
        this.layout = layout;
        this.thongTinListList = thongTinListList;
        this.arrayList = new ArrayList<ThongTin>();
        this.arrayList.addAll(thongTinListList);
    }

    @Override
    public int getCount() {
        return thongTinListList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    private class ViewHolder {
        TextView NgayQuaHan, TenSach, TacGia, TrangThai;

    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view == null) {
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout, null);
            holder.TenSach = (TextView) view.findViewById(R.id.tv2Tensach);

            holder.TacGia = (TextView) view.findViewById(R.id.tv2tacgia);
            holder.NgayQuaHan = (TextView) view.findViewById(R.id.tv2han);
            holder.TrangThai = (TextView) view.findViewById(R.id.tv2tt);

            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        ThongTin thongTin = thongTinListList.get(i);
        holder.TenSach.setText("Sách:"+thongTin.getTenSach());
        holder.NgayQuaHan.setText("Hết hạn:" + thongTin.getNgayQuaHan());
        holder.TacGia.setText("Tác Giả:" + thongTin.getTacGia());
        holder.TrangThai.setText("Trạng Thái:" + thongTin.getTrangThai());

        return view;
    }
}